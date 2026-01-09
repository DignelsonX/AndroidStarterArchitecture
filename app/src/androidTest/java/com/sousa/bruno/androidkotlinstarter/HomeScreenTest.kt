package com.sousa.bruno.androidkotlinstarter

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sousa.bruno.androidkotlinstarter.app.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class HomeScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun homeScreen_isReachable_and_displaysCorrectTitle() {
        // 1. We start on HomeInfoScreen. Find the button to navigate to the list.
        //    Replace "Go to Mockup List" with the real text from your HomeInfoScreen.kt file.
        val navigationButton = composeTestRule.onNodeWithText("Go to Mockup List", ignoreCase = true)

        // 2. Assert it exists and click it.
        navigationButton.assertExists()
        navigationButton.performClick()

        // 3. Now we are on HomeScreen. Check for the title from HomeScreen.kt ("People").
        composeTestRule.onNodeWithText("People", ignoreCase = true).assertExists()
    }
}