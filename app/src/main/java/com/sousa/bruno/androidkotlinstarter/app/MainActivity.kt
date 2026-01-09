package com.sousa.bruno.androidkotlinstarter.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sousa.bruno.androidkotlinstarter.app.ui.components.BottomBar
import com.sousa.bruno.androidkotlinstarter.app.ui.navigation.AppNavHost
import com.sousa.bruno.androidkotlinstarter.app.ui.theme.AndroidKotlinStarterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidKotlinStarterTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomBar(navController = navController)
                    }
                ) { padding ->
                    AppNavHost(
                        navController = navController,
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    }
}
