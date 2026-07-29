package com.gfilipe.fittrack.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val AccentRed = Color(0xFFE53E3E)
private val AccentRedDark = Color(0xFFB91C1C)

private val DarkColors = darkColorScheme(
    primary = AccentRed,
    secondary = AccentRed,
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    surfaceVariant = Color(0xFF262626),
    onPrimary = Color.White,
    onBackground = Color(0xFFF5F5F5),
    onSurface = Color(0xFFF5F5F5)
)

private val LightColors = lightColorScheme(
    primary = AccentRedDark,
    secondary = AccentRedDark,
    background = Color(0xFFFAFAFA),
    surface = Color.White,
    onPrimary = Color.White
)

@Composable
fun FitTrackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}
