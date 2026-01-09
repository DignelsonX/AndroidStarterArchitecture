package com.sousa.bruno.androidkotlinstarter.app.ui.navigation

sealed class Screen(val route: String) {
    object HomeInfo : Screen("home_info")
    object Home : Screen("home")
    object Settings : Screen("settings")
    object Profile : Screen("profile")
}