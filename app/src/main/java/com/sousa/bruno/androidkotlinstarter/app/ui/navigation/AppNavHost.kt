package com.sousa.bruno.androidkotlinstarter.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sousa.bruno.androidkotlinstarter.app.ui.home.HomeScreen
import com.sousa.bruno.androidkotlinstarter.app.ui.homeInfo.HomeInfoScreen
import com.sousa.bruno.androidkotlinstarter.app.ui.profile.ProfileScreen
import com.sousa.bruno.androidkotlinstarter.app.ui.settings.SettingsScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeInfo.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToInfo = { navController.navigate(Screen.HomeInfo.route) }
            )
        }
        composable(Screen.HomeInfo.route) {
            HomeInfoScreen(
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.Profile.route) { ProfileScreen() }
        composable(Screen.Settings.route) { SettingsScreen() }
    }
}



