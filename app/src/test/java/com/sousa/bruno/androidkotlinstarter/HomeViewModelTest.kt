package com.sousa.bruno.androidkotlinstarter

import com.sousa.bruno.androidkotlinstarter.app.ui.home.HomeViewModel
import com.sousa.bruno.androidkotlinstarter.domain.model.Person
import com.sousa.bruno.androidkotlinstarter.domain.repository.PeopleRepository
import com.sousa.bruno.androidkotlinstarter.domain.usecase.GetPeopleUseCase
import com.sousa.bruno.androidkotlinstarter.domain.usecase.ToggleFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    // --- Fakes Setup ---

    // A fake repository that gives us full control over the data returned in tests.
    private lateinit var fakeRepository: PeopleRepository

    // Fake Use Cases correctly extend and call the parent constructor.
    // They will use the fakeRepository provided in each test.
    class FakeGetPeopleUseCase(repository: PeopleRepository) : GetPeopleUseCase(repository)
    class FakeToggleFavoriteUseCase(repository: PeopleRepository) : ToggleFavoriteUseCase(repository)

    @Before
    fun setup() {
        // Set the Main dispatcher to our test dispatcher before each test.
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        // Reset the Main dispatcher after each test.
        Dispatchers.resetMain()
    }

    @Test
    fun `toggleFavorite should update person's favorite status in uiState`() = runTest(testDispatcher) {
        // --- ARRANGE ---

        val initialPerson = Person(id = 1, name = "John Doe", age = 25, isFavorite = false)

        // Configure the fake repository for this specific test case.
        fakeRepository = object : PeopleRepository {
            // Implement ALL interface members.
            override suspend fun getPeople(page: Int, limit: Int): List<Person> = listOf(initialPerson)
            override suspend fun loadNextPage(): List<Person> = emptyList() // Needs to be implemented.
            override fun getFavorites(): Flow<List<Person>> = flowOf(emptyList())
            override suspend fun toggleFavorite(person: Person) { /* no-op */ }
        }

        // Initialize the ViewModel with our fake use cases, which use the configured fake repository.
        val viewModel = HomeViewModel(
            getPeopleUseCase = FakeGetPeopleUseCase(fakeRepository),
            toggleFavoriteUseCase = FakeToggleFavoriteUseCase(fakeRepository)
        )

        // Let the init block of the ViewModel run to load the initial data.
        testDispatcher.scheduler.advanceUntilIdle()

        // --- ACT ---

        // Get the person from the state and call the public toggle function.
        // FIX: Remove .value - the uiState property in the ViewModel is likely not a StateFlow.
        val personToToggle = viewModel.uiState.people.first()
        viewModel.toggleFavorite(personToToggle)

        // Allow the coroutine in toggleFavorite to complete.
        testDispatcher.scheduler.advanceUntilIdle()

        // --- ASSERT ---

        // Check the public uiState for the expected change.
        // FIX: Remove .value here as well.
        val updatedPerson = viewModel.uiState.people.first { it.id == 1 }
        assertEquals("The person should be marked as favorite", true, updatedPerson.isFavorite)
    }
}