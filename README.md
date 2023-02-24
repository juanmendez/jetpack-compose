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

### Creating composable from the xml layout.

This used to be within the nested scroll view.

```
<TextView
    android:id="@+id/plant_detail_name"
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_marginStart="@dimen/margin_small"
    android:layout_marginEnd="@dimen/margin_small"
    android:gravity="center_horizontal"
    android:text="@{viewModel.plant.name}"
    android:textAppearance="?attr/textAppearanceHeadline5"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    tools:text="Apple" />
```

This is going to be replaced by

```
@Composable
private fun PlantName(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.h5,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.margin_small))
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}
```

Here we are maintaining the same `textAppereance`while making sure the textfield expands completely in its hosting composable.
We make sure the text is centered, and we also make sure it has the specific padding.

### Supporting features not available in Compose

Originally we were able to assign html content to a TextView previously in `fragment_plant_detail.xml`. 

```
<TextView
                    android:id="@+id/plant_description"
                    style="?android:attr/textAppearanceMedium"
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_marginStart="@dimen/margin_small"
                    android:layout_marginTop="@dimen/margin_small"
                    android:layout_marginEnd="@dimen/margin_small"
                    android:minHeight="@dimen/plant_description_min_height"
                    app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toBottomOf="@id/plant_watering"
                    app:renderHtml="@{viewModel.plant.description}"
                    tools:text="Details about the plant" />
```

We cannot support html content directly in Compose, but we will be able to inject a native ui element via `AndroidView`

`
AndroidView allows you to create a View programmatically. In case you want to inflate a View from an XML file, you can do it using view binding with the AndroidViewBinding API from the androidx.compose.ui:ui-viewbinding library.

`

### Ensuring your ComposeView is up to date with its Android lifecycle owner

[Compose Strategy](https://developer.android.com/jetpack/compose/migrate/interoperability-apis/compose-in-views#composition-strategy)

`
By default, Compose disposes of the Composition whenever the view becomes detached from a window. Compose UI View types such as ComposeView and AbstractComposeView use a ViewCompositionStrategy that defines this behavior.
`


### Backing up Native Material Theme in Compose.

There is a way to bridge material theme declared in Android to be translated into the MaterialTheme in JetpackCompose. We can make use of the [Theme Adapter Material library](https://google.github.io/accompanist/themeadapter-material/
)

![composable](https://user-images.githubusercontent.com/3371622/221266369-c6a81e43-14dd-4eb0-a608-7403a5acbc6d.gif)

