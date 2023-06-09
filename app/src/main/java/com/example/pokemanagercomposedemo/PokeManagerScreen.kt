package com.example.pokemanagercomposedemo

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemanagercomposedemo.ui.ChooseDataAccessModeScreen
import com.example.pokemanagercomposedemo.ui.ChooseNameLanguagesScreen
import com.example.pokemanagercomposedemo.ui.SetUpViewModel

enum class PokeManagerScreen {
    NamesLanguages,
    DataAccessMode,
    DownloadingAllData
}

@Composable
fun PokeManagerApp(
    viewModel: SetUpViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()
    NavHost(
        navController = navController,
        startDestination = PokeManagerScreen.NamesLanguages.name,
        modifier = Modifier.padding(0.dp)
    ) {
        composable(route = PokeManagerScreen.NamesLanguages.name) {
            ChooseNameLanguagesScreen(
                englishSelected = uiState.nameLanguageEnglishSelected,
                roomajiSelected = uiState.nameLanguageRoomajiSelected,
                kanaSelected = uiState.nameLanguageKanaSelected,
                onOptionButtonClicked = {
                    viewModel.nameLanguageOptionClicked(it)
                },
                isContinueButtonEnabled = uiState.nameLanguageContinueEnabled,
                onContinueButtonClicked = {
                    navController.navigate(PokeManagerScreen.DataAccessMode.name)
                }
            )
        }
        composable(route = PokeManagerScreen.DataAccessMode.name) {
            ChooseDataAccessModeScreen(
                downloadAllSelected = uiState.dataAccessModeDownloadAllSelected,
                onlyRequestSelected = uiState.dataAccessModeOnlyRequestSelected,
                onOptionButtonClicked = {
                    viewModel.dataAccessModeOptionClicked(it)
                },
                isContinueButtonEnabled = uiState.dataAccessModeContinueEnabled,
                onContinueButtonClicked = {

                }
            )
        }
        composable(route = PokeManagerScreen.DownloadingAllData.name) {

        }
    }
}















