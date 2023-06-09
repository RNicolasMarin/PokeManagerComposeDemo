package com.example.pokemanagercomposedemo.data

data class SetUpUiState(
    val nameLanguageEnglishSelected: Boolean = false,
    val nameLanguageRoomajiSelected: Boolean = false,
    val nameLanguageKanaSelected: Boolean = false,
    val nameLanguageContinueEnabled: Boolean = false,

    val dataAccessModeDownloadAllSelected: Boolean = false,
    val dataAccessModeOnlyRequestSelected: Boolean = false,
    val dataAccessModeContinueEnabled: Boolean = false,

    val isDownloading: Boolean = false,
    val downloadProgress: Float = 0.0f,
    val downloadProgressToShow: Int = 0,
    val downloadContinueEnabled: Boolean = false,
)
