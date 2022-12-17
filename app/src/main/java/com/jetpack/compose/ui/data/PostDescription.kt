package com.jetpack.compose.ui.data

import androidx.compose.runtime.Immutable

@Immutable
data class PostDescription(
    val author: PostAuthor,
    val date: String,
    val readTimeMinutes: Int
)