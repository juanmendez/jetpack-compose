package com.jetpack.compose

data class CardData(
    val greeting: String = "Hello, ",
    val title: String = "1",
    val description: String = ("Composem ipsum color sit lazy, " + "padding theme elit, sed do bouncy. ").repeat(4),
    val isExpanded: Boolean = false,
)
