package com.sousa.bruno.androidkotlinstarter.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {
    // Inicialização global, se necessário
}