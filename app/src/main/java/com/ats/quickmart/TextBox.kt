package com.droid.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.KeyboardType
import com.ats.quickmart.ui.theme.primary

@Composable
fun TextBox(
    modifier: Modifier,
    label: String,
    value: String? = null,
    keyboardType: KeyboardType,
    isEnabled: Boolean = true,
    onValueChange: (String) -> Unit
) {
    val name = remember { mutableStateOf("") }
    val isFocused = remember { mutableStateOf(false) }
    val labelColor = if (isFocused.value) primary else primary.copy(alpha = 0.6f)
    if (value != null) {
        name.value = value
    }
    OutlinedTextField(
        modifier = modifier.onFocusChanged { focusState ->
            isFocused.value = focusState.isFocused
        },
        enabled = isEnabled,
        label = {
            MediumText(text = label, color = labelColor)
        },
        value = name.value,
        onValueChange = {
            name.value = it
            onValueChange(it)
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = primary,
            unfocusedLabelColor = primary.copy(alpha = 0.6f)
        ), textStyle = MaterialTheme.typography.titleMedium
    )
}
