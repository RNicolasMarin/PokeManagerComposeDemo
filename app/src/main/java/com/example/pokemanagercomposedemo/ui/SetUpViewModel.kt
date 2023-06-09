package com.example.pokemanagercomposedemo.ui

import androidx.lifecycle.ViewModel
import com.example.pokemanagercomposedemo.data.SetUpUiState
import com.example.pokemanagercomposedemo.ui.ChooseDataAccessModeOption.*
import com.example.pokemanagercomposedemo.ui.ChooseNameLanguagesOption.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

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
}