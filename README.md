# Jetpack Compose - Lazy Grids

Lazy grid is only available currently in vertical flavor.
The demo has horizontal, but that's no longer available. What we could have done instead was to use a lazy row which was populated by columns having two cells.

What was in Codelabs

```kotlin
// Step: Favorite collections grid - LazyGrid
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(120.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(item.drawable, item.text, Modifier.height(56.dp))
        }
    }
}
```

What I did instead:

```kotlin
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(favoriteCollectionsData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}
```

Here is the new vertical grid. Disregard Guns n' Roses copy. I needed to make sure the text was centered. :)

<img width="427" alt="image" src="https://user-images.githubusercontent.com/3371622/172023212-88f889bb-4986-4a7d-a34c-c31ee09f2706.png">


View from a Samsung S21

<img width="427" alt="image" src="https://user-images.githubusercontent.com/3371622/172023290-cc09c30d-e06f-4682-883e-0672de267078.png">


Now the two view groups are wrapped in another new composable called `HomeSection`.
See the new main layout

```kotlin
@Composable
fun ColumnDisplay() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(R.string.align_your_body) {
            AlignYourBodyRow()
        }
        Spacer(modifier = Modifier.height(15.dp))
        HomeSection(R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
```

<img width="427" alt="image" src="https://user-images.githubusercontent.com/3371622/172024254-bf6a4109-dff0-4595-bde0-81d25f05996f.png">