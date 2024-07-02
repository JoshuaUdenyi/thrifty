package com.udenyijoshua.thrifty.component

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.udenyijoshua.thrifty.R
import com.udenyijoshua.thrifty.model.CheckoutDataSource
import com.udenyijoshua.thrifty.model.Product

@Composable
fun ProductItem(product: Product, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp)
    ){
        ProductImageCard(product = product)

        Column {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = stringResource(id = product.productName))
            Text(text = stringResource(id = product.productPrice))
        }

        Button(
            onClick = {
                CheckoutDataSource.addProduct(product) // Close the parenthesis here
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            modifier = modifier.fillMaxWidth()
        ) {
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "ShoppingCart")
                Spacer(modifier = modifier.width(10.dp))
                Text(text = "Add")
            }

        }
    }
}

@Composable
fun ProductImageCard(product: Product, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val productImageBitmap = remember(product.productName) {
        val bitmap = BitmapFactory.decodeResource(
            context.resources,
            getProductImageResourceId(product)
        )
        bitmap.asImageBitmap()
    }

    Card(
        modifier = modifier
            .wrapContentSize(),
        colors = CardDefaults.cardColors(
            contentColor = Color(0xFFF5F5F5) // Use hex color code for consistency
        )
    ) {
        Image(
            bitmap = productImageBitmap,
            contentDescription = stringResource(id = product.productName), // Provide content description
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f),
            contentScale = ContentScale.FillBounds
        )
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