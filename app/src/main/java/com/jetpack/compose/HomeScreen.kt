package com.jetpack.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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