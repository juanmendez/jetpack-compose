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

In Android and in the Web we have our declaration stylied separately through xml or css files, here in Jetpack Compose we are centric in Kotlin. 

Although in Android we can apply a default style and customize it such as one for a button, in Compose to achieve that we need to create our own signature of components and include a style..

See example.

```
@Composable
fun AcmeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,

  // expose Button params consumers should be able to change
) {
  val acmeButtonShape: Shape = ...
  Button(
    shape = acmeButtonShape,
    onClick = onClick,
    modifier = modifier
    // other params
  )
}
```

For further reading
[Design systems in Compose](https://developer.android.com/jetpack/compose/designsystems)
[Material Design](https://m3.material.io/) 