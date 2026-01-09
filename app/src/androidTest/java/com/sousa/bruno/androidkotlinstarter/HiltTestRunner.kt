package com.sousa.bruno.androidkotlinstarter

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

/**
 * A custom test runner required by Hilt to replace the app's default Application
 * class with a Hilt-specific one (`HiltTestApplication`) for testing.
 *
 * This allows Hilt to manage test-specific dependency graphs.
 */
class HiltTestRunner : AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        // We force the test to use Hilt's Test Application class.
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}