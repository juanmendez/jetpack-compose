# [Shapes](https://developer.android.com/codelabs/jetpack-compose-theming#6)

In Android we define a theme, and stick to it. Whereas in Compose, we are based on a Singleton theme which is updated by a composable method. It is misleading at first since the composable method and the singleton object are named the same.

In `JetNewsTheme`

The composable method which assigns attributes to the singleton which are merged into its original ones.
```
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
```

The singleton theme.
```
package androidx.compose.material

/**
 * Contains functions to access the current theme values provided at the call site's position in the hierarchy.
 */
object MaterialTheme {
    /**
     * Retrieves the current [Colors] at the call site's position in the hierarchy.
     *
     * @sample androidx.compose.material.samples.ThemeColorSample
     */
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    /**
     * Retrieves the current [Typography] at the call site's position in the hierarchy.
     *
     * @sample androidx.compose.material.samples.ThemeTextStyleSample
     */
    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    /**
     * Retrieves the current [Shapes] at the call site's position in the hierarchy.
     */
    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}

```

So after reading this it is easier to understand how we get a shape from the app's theme.

```
Image(
    ...    
	modifier = Modifier.clip(shape = MaterialTheme.shapes.small)
)
```

