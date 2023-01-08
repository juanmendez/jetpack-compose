package com.example.woof.view

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.woof.data.dogItems
import com.example.woof.ui.theme.WoofTheme

/**
 * Composable that displays an app bar and a list of dogs.
 */
@Composable
fun WoofApp() {
    LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
        items(dogItems) {
            DogRow(dog = it)
        }
    }
}

/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 */
@Preview
@Composable
fun WoofPreview() {
    WoofTheme(darkTheme = false) {
        WoofApp()
    }
}