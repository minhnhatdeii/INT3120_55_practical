package com.example.a30days.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30days.R

data class ItemMN(
    @DrawableRes val imageResourceId: Int,
    @StringRes val title: Int,
    val day: String,
    @StringRes val description: Int
)

val itemsMN = listOf(
    ItemMN(R.drawable.img1, R.string.title_1, "Day 1", R.string.description_1),
    ItemMN(R.drawable.img2, R.string.title_2, "Day 2", R.string.description_2),
    ItemMN(R.drawable.img3, R.string.title_3, "Day 3", R.string.description_3),
    ItemMN(R.drawable.img4, R.string.title_4, "Day 4", R.string.description_4),
    ItemMN(R.drawable.img5, R.string.title_5, "Day 5", R.string.description_5),
)