package com.example.pokemanagercomposedemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemanagercomposedemo.data.SetUpUiState
import com.example.pokemanagercomposedemo.ui.ChooseDataAccessModeOption.*
import com.example.pokemanagercomposedemo.ui.ChooseNameLanguagesOption.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SetUpViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(SetUpUiState())
    val uiState: StateFlow<SetUpUiState> = _uiState.asStateFlow()

    fun nameLanguageOptionClicked(option: ChooseNameLanguagesOption) {
        _uiState.update { currentState ->
            with(currentState) {
                val englishValue = if (option == English) !nameLanguageEnglishSelected else nameLanguageEnglishSelected
                val roomajiValue = if (option == Roomaji) !nameLanguageRoomajiSelected else nameLanguageRoomajiSelected
                val kanaValue = if (option == Kana) !nameLanguageKanaSelected else nameLanguageKanaSelected
                val continueEnabled = englishValue || roomajiValue || kanaValue
                currentState.copy(
                    nameLanguageEnglishSelected = englishValue,
                    nameLanguageRoomajiSelected = roomajiValue,
                    nameLanguageKanaSelected = kanaValue,
                    nameLanguageContinueEnabled = continueEnabled
                )
            }
        }
    }

    fun dataAccessModeOptionClicked(option: ChooseDataAccessModeOption) {
        _uiState.update { currentState ->
            with(currentState) {
                val downloadValue = option == DownloadAll
                val requestValue = option == OnlyRequest
                val continueEnabled = downloadValue || requestValue
                currentState.copy(
                    dataAccessModeDownloadAllSelected = downloadValue,
                    dataAccessModeOnlyRequestSelected = requestValue,
                    dataAccessModeContinueEnabled = continueEnabled
                )
            }
        }
    }

    fun simulateDownload() {
        if (_uiState.value.isDownloading) return

        _uiState.update { currentState ->
            currentState.copy(
                isDownloading = true
            )
        }
        viewModelScope.launch {
            repeat(11) {
                delay(500)
                _uiState.update { currentState ->
                    val newProgressValue = it.toFloat() / 10
                    currentState.copy(
                        downloadProgress = newProgressValue,
                        downloadProgressToShow = it * 10,
                        downloadContinueEnabled = newProgressValue == 1.0f
                    )
                }
            }
        }
    }
}