package com.example.pokemanagercomposedemo.data

data class SetUpUiState(
    val nameLanguageEnglishSelected: Boolean = false,
    val nameLanguageRoomajiSelected: Boolean = false,
    val nameLanguageKanaSelected: Boolean = false,
    val nameLanguageContinueEnabled: Boolean = false,

    val dataAccessModeDownloadAllSelected: Boolean = false,
    val dataAccessModeOnlyRequestSelected: Boolean = false,
    val dataAccessModeContinueEnabled: Boolean = false,
)
