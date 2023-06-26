package com.jetpack.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CardListView(
    cardDataItems: List<CardData> = listOf(),
    onExpandedAction: (CardData) -> Unit = {}
) {

    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = cardDataItems) { cardData ->
            CardContent(cardData = cardData, onExpandedAction = onExpandedAction)
        }
    }
}

@Preview
@Composable
fun CardListViewPreview(viewModel: MainViewModel = viewModel()) {
    CardListView(
        viewModel.cardDataItems,
        onExpandedAction = viewModel::onCardToggled
    )
}