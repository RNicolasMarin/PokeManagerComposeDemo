package com.example.pokemanagercomposedemo.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemanagercomposedemo.R
import com.example.pokemanagercomposedemo.ui.ChooseNameLanguagesOption.*
import com.example.pokemanagercomposedemo.ui.components.SetUpButtonOptionData
import com.example.pokemanagercomposedemo.ui.components.SetUpScreen

enum class ChooseNameLanguagesOption(@StringRes val text: Int) {
    English(text = R.string.setUp_name_cb_english),
    Roomaji(text = R.string.setUp_name_cb_roomaji),
    Kana(text = R.string.setUp_name_cb_kana)
}

@Composable
fun ChooseNameLanguagesScreen(
    englishSelected: Boolean,
    roomajiSelected: Boolean,
    kanaSelected: Boolean,
    onOptionButtonClicked: (ChooseNameLanguagesOption) -> Unit,
    onContinueButtonClicked: () -> Unit,
    isContinueButtonEnabled: Boolean,
    modifier: Modifier = Modifier
) {
    val buttonList = listOf(
        SetUpButtonOptionData(
            textRes = English.text,
            isSelected = englishSelected,
            onOptionSelected = {
                onOptionButtonClicked.invoke(English)
            }
        ),
        SetUpButtonOptionData(
            textRes = Roomaji.text,
            isSelected = roomajiSelected,
            onOptionSelected = {
                onOptionButtonClicked.invoke(Roomaji)
            }
        ),
        SetUpButtonOptionData(
            textRes = Kana.text,
            isSelected = kanaSelected,
            onOptionSelected = {
                onOptionButtonClicked.invoke(Kana)
            }
        )
    )
    SetUpScreen(
        titleRes = R.string.setUp_name_tv_title,
        descriptionRes = R.string.setUp_name_tv_description,
        buttons = buttonList,
        onContinueButtonClicked = onContinueButtonClicked,
        isContinueButtonEnabled = isContinueButtonEnabled,
        modifier = modifier
    )
    /*Column(
        modifier = modifier,
    ) {
        Column(
            modifier = modifier.align(Alignment.CenterHorizontally).weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.setUp_name_tv_title),
                fontSize = 22.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(id = R.string.setUp_name_tv_description),
                fontSize = 16.sp,
                color = Color.Gray,
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SetUpButtonOption(
                textId = ChooseNameLanguagesOption.English.text,
                onOptionSelected = { },
                isSelected = false
            )
            SetUpButtonOption(
                textId = ChooseNameLanguagesOption.Roomaji.text,
                onOptionSelected = { },
                isSelected = true
            )
            SetUpButtonOption(
                textId = ChooseNameLanguagesOption.Kana.text,
                onOptionSelected = { },
                isSelected = false
            )
        }
        Column(
            modifier = modifier
                .padding(10.dp)
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SetUpButtonContinue(
                onOptionSelected = { },
                isEnabled = false
            )
        }
    }*/
}

@Preview
@Composable
fun ChooseNameLanguagesPreview() {
    ChooseNameLanguagesScreen(
        englishSelected = false,
        roomajiSelected = false,
        kanaSelected = false,
        onOptionButtonClicked = {},
        onContinueButtonClicked = {},
        isContinueButtonEnabled = false,
        modifier = Modifier.fillMaxSize(),
    )
}