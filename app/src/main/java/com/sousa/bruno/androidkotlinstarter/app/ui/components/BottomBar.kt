package com.sousa.bruno.androidkotlinstarter.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.WbIncandescent
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.navigation.NavController
import com.sousa.bruno.androidkotlinstarter.app.ui.navigation.Screen

@Composable
fun BottomBar(navController: NavController) {
    NavigationBar {
        val currentRoute = navController.currentBackStackEntry?.destination?.route

        NavigationBarItem(
            selected = currentRoute == Screen.HomeInfo.route,
            onClick = { navController.navigate(Screen.HomeInfo.route) },
            icon = { Icon(Icons.Default.WbIncandescent, contentDescription = null) },
            label = { Text("Welcome") }
        )

        NavigationBarItem(
            selected = currentRoute == Screen.Home.route,
            onClick = { navController.navigate(Screen.Home.route) },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = currentRoute == Screen.Settings.route,
            onClick = { navController.navigate(Screen.Settings.route) },
            icon = { Icon(Icons.Default.Settings, contentDescription = null) },
            label = { Text("Settings") }
        )

        NavigationBarItem(
            selected = currentRoute == Screen.Profile.route,
            onClick = { navController.navigate(Screen.Profile.route) },
            icon = { Icon(Icons.Default.Person, contentDescription = null) },
            label = { Text("Profile") }
        )


    }
}
