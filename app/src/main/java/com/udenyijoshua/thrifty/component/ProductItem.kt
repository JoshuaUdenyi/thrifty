package com.udenyijoshua.thrifty.component

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.udenyijoshua.thrifty.R
import com.udenyijoshua.thrifty.model.Product

@Composable
fun ProductItem(product: Product, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val productName = context.getString(product.productName)
    val productPrice = context.getString(product.productPrice)

    // Load image resource
    val productImageBitmap = remember(product.productName) {
        val bitmap =
            BitmapFactory.decodeResource(context.resources, getProductImageResourceId(product))
        bitmap.asImageBitmap()
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Transparent)
    ) {
        Card(
            modifier = Modifier
                .wrapContentSize(),
            colors = CardDefaults.cardColors(
                contentColor = Color(245, 245, 245)
            )
        ) {
            Image(
                bitmap = productImageBitmap,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .aspectRatio(1f),
                contentScale = ContentScale.FillBounds
            )
        }
        Column(
            modifier = modifier
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = productName)
            Text(text = productPrice)
        }
    }


}

fun getProductImageResourceId(product: Product): Int {
    return when (product.productName) {
        R.string.vintage -> R.drawable.mock_stock_edit
        R.string.boho -> R.drawable.mock_stock_edit
        R.string.classic -> R.drawable.mock_stock_edit
        R.string.retro -> R.drawable.mock_stock_edit
        R.string.timeless -> R.drawable.mock_stock_edit
        else -> R.drawable.mock_stock_edit // Default image
    }
}