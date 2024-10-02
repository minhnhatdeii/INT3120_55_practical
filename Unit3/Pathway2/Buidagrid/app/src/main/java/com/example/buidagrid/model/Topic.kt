package com.example.buidagrid.model
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val number: Int,
    @DrawableRes val drawableResId: Int,
)
