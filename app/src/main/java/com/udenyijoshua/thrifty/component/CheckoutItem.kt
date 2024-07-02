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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.udenyijoshua.thrifty.R
import com.udenyijoshua.thrifty.model.Product


@Composable
fun CheckoutItem( product: Product, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), // Add padding for better spacing
            verticalAlignment = Alignment.CenterVertically // Vertically center items in Row
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
                modifier = Modifier.weight(1f), // Allow Column to take up remaining space
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Hello World",
                    modifier.padding(start = 16.dp)
                )
                CounterRow()
            }}
    }
}

@Composable
fun GetProductImage(){
    val context = LocalContext.current

    val imageBitmap = remember {
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.mock_stock_edit)
        bitmap.asImageBitmap()
    }
    Image(
        bitmap =imageBitmap  ,
        contentDescription = "Hello World",
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun CounterRow(modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ){

        Text(text = "$149")
        Counter()
    }
}

@Composable
@Preview
fun CheckoutItemPreview(){
}
