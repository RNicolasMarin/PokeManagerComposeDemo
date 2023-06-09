package com.example.pokemanagercomposedemo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemanagercomposedemo.R
import com.example.pokemanagercomposedemo.ui.components.SetUpButtonContinue

@Composable
fun DownloadingAllDataScreen(
    progress: Float,
    progressToShow: Int,
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
                text = stringResource(id = R.string.setUp_downloading_tv_title),
                fontSize = 22.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(id = R.string.setUp_downloading_tv_description),
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
        ) {
            LinearProgressIndicator(
                modifier = Modifier.height(40.dp).fillMaxWidth(),
                progress = progress
            )
            Text(
                text = "$progressToShow%",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
            )
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