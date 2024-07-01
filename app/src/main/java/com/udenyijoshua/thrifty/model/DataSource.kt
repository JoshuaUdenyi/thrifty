package com.udenyijoshua.thrifty.model

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import com.udenyijoshua.thrifty.R

object DataSource {
    val ProductList = listOf<Product>(
        Product(
            productName = R.string.vintage,
            productPrice = R.string.vintage_price,
            productImageBitmap = null // Load them later using a viewmodel
        ),
        Product(
            productName = R.string.boho,
            productPrice = R.string.boho_price,
            productImageBitmap = null
        ),
        Product(
            productName = R.string.classic,
            productPrice = R.string.classic_price,
            productImageBitmap = null
        ),
        Product(
            productName = R.string.retro,
            productPrice = R.string.retro_price,
            productImageBitmap = null
        ),
        Product(
            productName = R.string.timeless,
            productPrice = R.string.timeless_price,
            productImageBitmap = null
        )
    )
}
