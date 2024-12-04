package com.droid.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


@Composable
fun NormalText(
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 12.sp,
    text: String,
    singleLine: Boolean = true,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        maxLines = if (singleLine) 1 else Int.MAX_VALUE,
        style = MaterialTheme.typography.titleSmall,
        fontSize = fontSize,
        textAlign = textAlign
    )
}

@Composable
fun MediumText(
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp,
    text: String,
    singleLine: Boolean = true,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        maxLines = if (singleLine) 1 else Int.MAX_VALUE,
        style = MaterialTheme.typography.titleMedium,
        fontSize = fontSize,
        textAlign = textAlign
    )
}

@Composable
fun LargeText(
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 20.sp,
    text: String,
    singleLine: Boolean = true,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        maxLines = if (singleLine) 1 else Int.MAX_VALUE,
        style = MaterialTheme.typography.labelLarge,
        fontSize = fontSize,
        textAlign = textAlign
    )
}

@Composable
fun LargeBoldText(
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 22.sp,
    text: String,
    singleLine: Boolean = true,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start,
    style: TextStyle = MaterialTheme.typography.titleLarge
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = style,
        maxLines = if (singleLine) 1 else Int.MAX_VALUE,
        fontSize = fontSize,
        textAlign = textAlign
    )
}