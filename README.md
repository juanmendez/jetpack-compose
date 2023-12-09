# Jetpack Compose

Each learning chapter is stored in its own branch.

- `codelabs-basics/*` has all chapters which are part of [Jetpack Compose basics in Codelabs](https://developer.android.com/codelabs/jetpack-compose-basics).
- `codelabs-layouts/*` has all chapters which are part of [Layouts in Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-layouts)
- `codelabs-states/*` has all chapters which are part of [State in Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-state)
- `codelabs-states-advanced/*` has all chapters which are part of [Advanced State and Side Effects in Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-advanced-state-side-effects)
- `codelabs-theming/*` has all chapters which are part of [Jetpack Compose theming](https://developer.android.com/codelabs/jetpack-compose-theming)
- `codelabs-material-theming/*` has all chapters which are part of [Material Theming with Jetpack Compose](https://developer.android.com/codelabs/basic-android-kotlin-compose-material-theming)
- `codelabs-migration/*` learn how to migrate to Compose incrementally from a layout designed application, [Migrating to Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-migration) 
- `codelabs-navigation/*` learn how to migrate to write a navigation composable with the same concepts of the Jetpack Navigation library, [Jetpack Compose Navigation](https://developer.android.com/codelabs/jetpack-compose-navigation) 
- `codelabs-compose-animation/*` learn how to add a simple animation to your Android app, [Jetpack Compose Animation](https://developer.android.com/codelabs/jetpack-compose-animation)

Good to read

- [Thinking in Compose](https://developer.android.com/jetpack/compose/mental-model)


### Color animation

We are learning how to animate. What used to be a simple swap of color for the background, now has a color animation. By the way, this tutorial uses TODOs which makes it easier to find each step just by looking at the TODO console.

```
// before
    val backgroundColor = if (tabPage == TabPage.Home) Purple100 else Green300

// after, I like to set conditions in blocks
    val backgroundColor by animateColorAsState(
        if (tabPage == TabPage.Home) {
            Purple100
        } else {
            Green300
        }, label = ""
    )
```

Here we are going to ensure a button is expanded with animation and also the text displayed.

```
            if (extended) {
                Text(
                    text = stringResource(R.string.edit),
                    modifier = Modifier
                        .padding(start = 8.dp, top = 3.dp)
                )
            }
```

Now with animation

```
AnimatedVisibility(extended) {
    Text(
        text = stringResource(R.string.edit),
        modifier = Modifier
            .padding(start = 8.dp, top = 3.dp)
    )
}
