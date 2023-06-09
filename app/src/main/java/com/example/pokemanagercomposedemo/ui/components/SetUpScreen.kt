package com.example.pokemanagercomposedemo.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemanagercomposedemo.R

data class SetUpButtonOptionData(
    @StringRes val textRes: Int,
    val isSelected: Boolean,
    val onOptionSelected: () -> Unit
)

@Composable
fun SetUpScreen(
    @StringRes titleRes: Int,
    @StringRes descriptionRes: Int,
    buttons: List<SetUpButtonOptionData>,
    onContinueButtonClicked: () -> Unit,
    isContinueButtonEnabled: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        Column(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = titleRes),
                fontSize = 22.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(id = descriptionRes),
                fontSize = 16.sp,
                color = Color.Gray,
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
        ) {
            buttons.forEach {item ->
                with(item) {
                    SetUpButtonOption(
                        textId = textRes,
                        onOptionSelected = onOptionSelected,
                        isSelected = isSelected
                    )
                }
            }
        }
        Column(
            modifier = modifier
                .padding(20.dp)
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SetUpButtonContinue(
                onContinue = onContinueButtonClicked,
                isEnabled = isContinueButtonEnabled
            )
        }
    }
}