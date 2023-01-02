package com.jetpack.compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.jetpack.compose.ui.theme.colors.DarkColors
import com.jetpack.compose.ui.theme.colors.LightColors
import com.jetpack.compose.ui.theme.types.JetNewsTypography

@Composable
fun JetNewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
        typography = JetNewsTypography,
        shapes = JetNewsShapes,
        content = content
    )
}