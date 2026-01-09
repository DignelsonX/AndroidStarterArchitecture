package com.sousa.bruno.androidkotlinstarter.app.ui.homeInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeInfoScreen(
    onBack: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Welcome!") },
                navigationIcon = {
                   /* IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }*/
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color(0xFFE8E8E8),
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }
    ) { padding ->
        HomeInfoContent(padding)
    }
}

@Composable
fun HomeInfoContent(padding: PaddingValues) {
    val scroll = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(padding)
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(scroll)
    ) {
        SectionTitle("Clean Architecture Android Starter Template — Quick Guide")

        BodyText("Hello! My name is Bruno. Welcome to the Android Kotlin Starter, and thank you for downloading this project.")
        BodyText("After researching and experimenting with different architectures to match my development style, I decided to create this Starter Template.")
        BodyText("The goal is to provide a modern, organized, and easy-to-use base that works both for learning and real projects, something I would love to use myself.")
        BodyText("I hope this template helps you start faster, maintain consistent code, and evolve your app more smoothly.")

        CardBlock("Technologies Used", "- Kotlin\n- Hilt\n- Retrofit\n- Room\n- Coroutines\n- ViewModel\n- Clean Architecture")

        CardBlock("Project Folder Structure", """
app/            # UI layer, DI, and navigation
    di/         # Dependency Injection (Hilt)
    navigation/ # App routes
    ui/         # Screens and components
core/           # Core logic
    database/   # Room Database
    network/    # Retrofit + APIs
    utils/      # Utility functions
    model/      # Base models
data/           # Repositories and data sources
    repository/
    remote/
    local/
domain/         # Business rules
    model/
    repository/
    usecase/
        """.trimIndent()
        )

        CardBlock("What Each Folder Contains", """
- app/di: Hilt modules, singletons
- app/navigation: NavHost and destinations
- app/ui/components: Buttons, Cards, dialogs
- core/database: DAOs, entities
- core/network: Retrofit service
- data/remote: API calls, DTOs
- data/local: Room database implementation
- domain/usecase: Use cases
- domain/repository: Interfaces to abstract the data layer
        """.trimIndent()
        )

        CardBlock("How to Create a New Feature", """
ui/featureName/
    FeatureFragment.kt
    FeatureViewModel.kt
    FeatureUiState.kt
domain/
    usecase/
    model/
    repository/
data/
    repository/
    remote/
    local/
        """.trimIndent()
        )

        CardBlock("How to Run the Project", """
1. Open Android Studio
2. Sync Gradle
3. Run on a device or emulator
4. For testing, run available instrumented/unit tests
        """.trimIndent()
        )
    }
}

@Composable
fun SectionTitle(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 12.dp)
    ) {
        Icon(Icons.Filled.Info, contentDescription = "Info", tint = Color(0xFF1E88E5))
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF038DC0)
            )
        )
    }
}

@Composable
fun BodyText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
        modifier = Modifier.padding(vertical = 4.dp)
    )
}

@Composable
fun CardBlock(title: String, content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1a1e25)),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(0xFF1BA403)
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 15.sp,
                    color = Color(0xFFE8E8E8)
                )
            )
        }
    }
}
