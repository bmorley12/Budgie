package com.example.budgie.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun Theme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Checks if your system is in dark theme mode.
    content: @Composable () -> Unit
) {
    val colors = if (!darkTheme) LightColorScheme else DarkColorScheme
    MaterialTheme(
        colorScheme = colors,
        typography = appTypography(),
        shapes = Shapes,
        content = content,
    )
}