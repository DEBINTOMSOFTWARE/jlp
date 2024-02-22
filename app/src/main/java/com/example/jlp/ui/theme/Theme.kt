package com.example.jlp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.foundation.isSystemInDarkTheme


@Composable
fun JlpTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (useDarkTheme) DarkThemeColors else LightThemeColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}