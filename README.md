# Jetpack Compose

Each learning chapter is stored in its own branch.

- `codelabs-basics/*` has all chapters which are part of [Jetpack Compose basics in Codelabs](https://developer.android.com/codelabs/jetpack-compose-basics).
- `codelabs-layouts/*` has all chapters which are part of [Layouts in Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-layouts)
- `codelabs-states/*` has all chapters which are part of [State in Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-state)
- `codelabs-states-advanced/*` has all chapters which are part of [Advanced State and Side Effects in Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-advanced-state-side-effects)
- `codelabs-theming/*` has all chapters which are part of [Jetpack Compose theming](https://developer.android.com/codelabs/jetpack-compose-theming)
- `codelabs-material-theming/*` has all chapters which are part of [Material Theming with Jetpack Compose](https://developer.android.com/codelabs/basic-android-kotlin-compose-material-theming)
- `codelabs-migration/*` learn how to migrate to Compose incrementally from a layout designed application, [Migrating to Jetpack Compose](url) 
#### Guidelines:

The recommended migration strategy is this:

- Build new features with Compose
- As you're building features, identify reusable elements and start to create a library of common UI components
- Replace existing features one screen at a time

### First time switching an Android ui element into a composable.

```
<androidx.core.widget.NestedScrollView
    android:id="@+id/plant_detail_scrollview"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:clipToPadding="false"
    android:paddingBottom="@dimen/fab_bottom_padding"
    app:layout_behavior="@string/appbar_scrolling_view_behavior">

	<!-- the original content has been removed in favor of this element which can host a composable -->
    <androidx.compose.ui.platform.ComposeView
        android:id="@+id/compose_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</androidx.core.widget.NestedScrollView>
```

Then in the Fragment's view binding, we assign our composable.

```
composeView.setContent {
    // You're in Compose world!
    MaterialTheme {
        PlantDetailDescription()
    }
}
```

And by the way this is the composable

```
@Composable
fun PlantDetailDescription() {
    Surface {
        Text("Hello Compose")
    }
}
```

Here is the result

<img width="350" alt="composable injected in xml layout" src="https://user-images.githubusercontent.com/3371622/220806865-098d99b9-44ae-40fa-b10d-500ef70672d7.png">


