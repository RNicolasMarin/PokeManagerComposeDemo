package com.example.pokemanagercomposedemo.ui.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemanagercomposedemo.R

@Composable
fun SetUpButtonContinue(
    onContinue: () -> Unit,
    isEnabled: Boolean,
    modifier: Modifier = Modifier
) {
    val borderColor = if (isEnabled) Color.Red else Color.Black
    val textColor = if (isEnabled) Color.White else Color.Black
    val backgroundColor = if (isEnabled) Color.Red else Color.White
    OutlinedButton(
        onClick = onContinue,
        border = BorderStroke(1.dp, borderColor),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = textColor, containerColor = backgroundColor),
        enabled = isEnabled,
        modifier = modifier.fillMaxWidth().height(50.dp)
    ) {
        Text(
            text = stringResource(id = R.string.global_btn_continue),
            fontSize = 24.sp
        )
    }
}