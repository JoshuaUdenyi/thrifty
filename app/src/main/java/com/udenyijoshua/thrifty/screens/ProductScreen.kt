package com.udenyijoshua.thrifty.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.udenyijoshua.thrifty.component.ProductItem
import com.udenyijoshua.thrifty.model.DataSource


@Composable
fun ProductScreen(modifier: Modifier = Modifier){
    val products = remember { DataSource.ProductList }

    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp),
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(products) { product ->
                ProductItem(product)
            }
        }
    }

}