# Jetpack Compose - Scaffold

This is another retro to Flutter, Scafold is a widget which lays out children with Material theme in mind. Here we see how our new navigation is applied at the bottom

```
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { SearchBar(Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)) },
        bottomBar = { BottomNavigation() }
    ) {
        Column {
            HomeSection(R.string.align_your_body) {
                AlignYourBodyRow()
            }
            Spacer(modifier = Modifier.height(15.dp))
            HomeSection(R.string.favorite_collections) {
                FavoriteCollectionsGrid()
            }
        }
    }
}
```


<img width="551" alt="image" src="https://user-images.githubusercontent.com/3371622/172025276-7eb5c07f-9542-4329-8b18-959ee0080caa.png">