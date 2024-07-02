package com.udenyijoshua.thrifty.component

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.udenyijoshua.thrifty.R
import com.udenyijoshua.thrifty.model.Product

@Composable
fun CheckoutItem(
    product: Product,
    count: Int,
    onCountChange: (Product, Int) -> Unit,
    onRemove: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = modifier
                    .size(width = 100.dp, height = 100.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Black)
            ) {
                GetProductImage()
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = stringResource(product.productName),
                    modifier.padding(start = 16.dp)
                )
                CounterRow(
                    product = product,
                    count = count,
                    onCountChange = { newCount ->
                        if (newCount == 0) {
                            onRemove(product)
                        } else {
                            onCountChange(product, newCount)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun GetProductImage() {
    val context = LocalContext.current

    val imageBitmap = remember {
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.mock_stock_edit)
        bitmap.asImageBitmap()
    }
    Image(
        bitmap = imageBitmap,
        contentDescription = "Product Image",
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun CounterRow(
    product: Product,
    count: Int,
    onCountChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Text(text = stringResource(product.productPrice))
        Counter(
            count = count,
            onIncrement = { onCountChange(count + 1) },
            onDecrement = { if (count > 0) onCountChange(count - 1) }
        )
    }
}
