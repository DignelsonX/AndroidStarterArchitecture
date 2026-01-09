plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //alias(libs.plugins.apollo) // <-- Use the alias now
    alias(libs.plugins.hilt)
    id("org.jetbrains.kotlin.kapt") // Use the ID directly
}

android {
    namespace = "com.sousa.bruno.androidkotlinstarter"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.sousa.bruno.androidkotlinstarter"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        // Use your custom HiltTestRunner for instrumented tests
        testInstrumentationRunner = "com.sousa.bruno.androidkotlinstarter.HiltTestRunner" // <-- ADD THIS LINE

        // testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    // Core Jetpack & Compose Dependencies (using libs and BOM)
    // The BOM (Bill of Materials) handles the versions for compose libraries like ui, graphics, tooling, and material3
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)


    // Hilt (using libs from your versions.toml)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation("androidx.hilt:hilt-work:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    // Coroutines (using libs)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Room (using libs)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    // Retrofit + OkHttp + Moshi (these can be added to your toml file later)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0") // It's good practice to align this version
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.10.1")

    implementation("androidx.compose.material:material-icons-extended:1.7.5")

    implementation ("io.coil-kt:coil-compose:2.5.0")

    // WorkManager (can also be added to toml)
    implementation("androidx.work:work-runtime-ktx:2.9.0") // Updated to a more recent version


    // Test
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.48") // Use a recent version
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.48")
    testImplementation(libs.junit)
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

}
