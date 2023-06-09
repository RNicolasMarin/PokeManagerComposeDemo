package com.example.pokemanagercomposedemo.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pokemanagercomposedemo.R
import com.example.pokemanagercomposedemo.ui.ChooseDataAccessModeOption.*
import com.example.pokemanagercomposedemo.ui.components.SetUpButtonOptionData
import com.example.pokemanagercomposedemo.ui.components.SetUpScreen

enum class ChooseDataAccessModeOption(@StringRes val text: Int) {
    DownloadAll(text = R.string.setUp_data_rb_download_all),
    OnlyRequest(text = R.string.setUp_data_rb_only_request)
}

@Composable
fun ChooseDataAccessModeScreen(
    downloadAllSelected: Boolean,
    onlyRequestSelected: Boolean,
    onOptionButtonClicked: (ChooseDataAccessModeOption) -> Unit,
    onContinueButtonClicked: () -> Unit,
    isContinueButtonEnabled: Boolean,
    modifier: Modifier = Modifier
) {
    val buttonList = listOf(
        SetUpButtonOptionData(
            textRes = DownloadAll.text,
            isSelected = downloadAllSelected,
            onOptionSelected = {
                onOptionButtonClicked.invoke(DownloadAll)
            }
        ),
        SetUpButtonOptionData(
            textRes = OnlyRequest.text,
            isSelected = onlyRequestSelected,
            onOptionSelected = {
                onOptionButtonClicked.invoke(OnlyRequest)
            }
        )
    )
    SetUpScreen(
        titleRes = R.string.setUp_data_tv_title,
        descriptionRes = R.string.setUp_data_tv_description,
        buttons = buttonList,
        onContinueButtonClicked = onContinueButtonClicked,
        isContinueButtonEnabled = isContinueButtonEnabled,
        modifier = modifier
    )
}