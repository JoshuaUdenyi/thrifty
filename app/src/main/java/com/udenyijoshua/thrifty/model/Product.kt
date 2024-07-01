package com.udenyijoshua.thrifty.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.ImageBitmap

data class Product(
    @StringRes val productName: Int,
    @StringRes val productPrice: Int,
    val productImageBitmap: ImageBitmap? = null
)