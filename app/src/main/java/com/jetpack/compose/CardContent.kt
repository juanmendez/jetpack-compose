package com.jetpack.compose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * A Compose app is made up of composable functions - just regular functions marked with @Composable, which can call other composable functions.
 * A function is all you need to create a new UI component. The annotation tells Compose to add special support to the function for updating and
 * maintaining your UI over time. Compose lets you structure your code into small chunks. Composable functions are often referred to as "composables"
 * for short.
 */
@Composable
fun CardContent(cardData: CardData, onExpandedAction: (CardData) -> Unit = {}) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Text(text = cardData.greeting)
                Text(
                    text = cardData.title,
                    style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                if (cardData.isExpanded) {
                    Text(
                        text = cardData.description,
                    )
                }
            }
            IconButton(
                onClick = {
                    onExpandedAction(cardData)
                }
            ) {
                Icon(
                    imageVector = if (cardData.isExpanded) {
                        Icons.Filled.ExpandLess
                    } else {
                        Icons.Filled.ExpandMore
                    },
                    contentDescription = if (cardData.isExpanded) {
                        stringResource(R.string.show_less)
                    } else {
                        stringResource(R.string.show_more)
                    }

                )
            }
        }

    }
}

@Preview
@Composable
fun CardContentPreview(viewModel: MainViewModel = viewModel()) {
    val firstCard = viewModel.cardDataItems.first()
    CardContent(cardData = firstCard, viewModel::onCardToggled)
}