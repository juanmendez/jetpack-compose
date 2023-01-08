package com.example.woof.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.woof.R

/**
 * A data class to represent the information presented in the dog card
 */
data class DogItem(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)

val dogItems = listOf(
    DogItem(R.drawable.koda, R.string.dog_name_1, 2, R.string.dog_description_1),
    DogItem(R.drawable.lola, R.string.dog_name_2, 16, R.string.dog_description_2),
    DogItem(R.drawable.frankie, R.string.dog_name_3, 2, R.string.dog_description_3),
    DogItem(R.drawable.nox, R.string.dog_name_4, 8, R.string.dog_description_4),
    DogItem(R.drawable.faye, R.string.dog_name_5, 8, R.string.dog_description_5),
    DogItem(R.drawable.bella, R.string.dog_name_6, 14, R.string.dog_description_6),
    DogItem(R.drawable.moana, R.string.dog_name_7, 2, R.string.dog_description_7),
    DogItem(R.drawable.tzeitel, R.string.dog_name_8, 7, R.string.dog_description_8),
    DogItem(R.drawable.leroy, R.string.dog_name_9, 4, R.string.dog_description_9)
)