package com.sousa.bruno.androidkotlinstarter.app.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sousa.bruno.androidkotlinstarter.domain.usecase.GetPeopleUseCase
import com.sousa.bruno.androidkotlinstarter.domain.usecase.ToggleFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    private var currentPage = 1
    private val pageSize = 25
    private var isLoadingPage = false
    private var endReached = false

    init {
        loadPeople()
    }

    /** Carrega a próxima página de pessoas */
    fun loadPeople() {
        if (isLoadingPage || endReached) return
        isLoadingPage = true

        viewModelScope.launch {
            try {
                val newPeople = getPeopleUseCase(currentPage, pageSize)
                val newPeopleUi = newPeople.map { it.toUi() }

                // Se não vier nada, chegamos ao fim
                if (newPeopleUi.isEmpty()) endReached = true

                uiState = uiState.copy(
                    people = uiState.people + newPeopleUi,
                    loading = false
                )
                currentPage++
            } catch (e: Exception) {
                uiState = uiState.copy(error = e.message, loading = false)
            } finally {
                isLoadingPage = false
            }
        }
    }

    /** Alterna favorito */
    fun toggleFavorite(person: PersonUi) {
        viewModelScope.launch {
            toggleFavoriteUseCase(person.toDomain())
            uiState = uiState.copy(
                people = uiState.people.map {
                    if (it.id == person.id) it.copy(isFavorite = !it.isFavorite) else it
                }
            )
        }
    }
}
