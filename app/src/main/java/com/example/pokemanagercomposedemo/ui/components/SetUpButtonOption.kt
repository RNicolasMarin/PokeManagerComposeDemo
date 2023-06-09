package com.example.pokemanagercomposedemo.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
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

@Composable
fun SetUpButtonOption(
    @StringRes textId : Int,
    onOptionSelected: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    val borderColor = Color.Red
    val textColor = if (isSelected) Color.White else Color.Red
    val backgroundColor = if (isSelected) Color.Red else Color.White
    OutlinedButton(
        onClick = onOptionSelected,
        border = BorderStroke(1.dp, borderColor),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = textColor, containerColor = backgroundColor),
        contentPadding = PaddingValues(0.dp),
        modifier = modifier.fillMaxWidth().height(50.dp)
    ) {
        Text(
            text = stringResource(id = textId),
            fontSize = 18.sp,
        )
    }
}