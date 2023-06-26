package com.jetpack.compose

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _cardDataItems = mutableStateListOf<CardData>().apply {
        addAll(List(1000) { CardData(title = "$it") })
    }
    val cardDataItems: List<CardData> = _cardDataItems

    private var _shouldShowOnboard = mutableStateOf(true)
    val shouldShowOnboard: State<Boolean> = _shouldShowOnboard

    fun onCardToggled(cardData: CardData) {
        val index = _cardDataItems.indexOfFirst {
            it.title == cardData.title
        }

        if (index >= 0) {
            val nextExpandedValue = !cardData.isExpanded
            _cardDataItems[index] = cardData.copy(isExpanded = nextExpandedValue)
        }
    }

    fun onBoardingToggled() {
        _shouldShowOnboard.value = !_shouldShowOnboard.value
    }
}