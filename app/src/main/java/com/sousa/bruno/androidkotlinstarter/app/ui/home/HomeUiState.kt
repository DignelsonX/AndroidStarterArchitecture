package com.sousa.bruno.androidkotlinstarter.app.ui.home

data class HomeUiState(
    val people: List<PersonUi> = emptyList(),
    val loading: Boolean = true,
    val loadingMore: Boolean = false,
    val error: String? = null
)
