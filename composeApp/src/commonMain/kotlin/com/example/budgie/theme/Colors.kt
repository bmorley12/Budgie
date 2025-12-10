package com.example.budgie.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Primary
val LightPrimary = Color(0xFF4A4A4A)
val LightOnPrimary = Color(0xFFFFFFFF)

val DarkPrimary = Color(0xFFFFFFFF)
val DarkOnPrimary = Color(0xFF4A4A4A)


// Secondary
val LightSecondary = Color(0xFFB0B0B0)
val LightOnSecondary = Color(0xFF333333)

val DarkSecondary = Color(0xFF4A4A4A)
val DarkOnSecondary = Color(0xFFE0E0E0)


// Background
val LightBackground = Color(0xFFF8F8F8)
val LightOnBackground = Color(0xFF333333)

val DarkBackground = Color(0xFF1C1C1C)
val DarkOnBackground = Color(0xFFE0E0E0)


// Surface
val LightSurface = Color(0xFFFFFFFF)
val LightOnSurface = Color(0xFF4A4A4A)

val DarkSurface = Color(0xFF2A2A2A)
val DarkOnSurface = Color(0xFFFFFFFF)


internal val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
)

internal val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
)