package com.example.gridwithphotos.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val label: Int,
    @DrawableRes val imageResourceId: Int
)
