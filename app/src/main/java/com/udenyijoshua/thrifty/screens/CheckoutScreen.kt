package com.udenyijoshua.thrifty.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.udenyijoshua.thrifty.component.CheckoutItem
import com.udenyijoshua.thrifty.model.CheckoutDataSource
import com.udenyijoshua.thrifty.model.Product
import com.udenyijoshua.thrifty.navigation.CheckoutCompleted

@Composable
fun CheckoutScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val dataSource = remember { CheckoutDataSource.checkOutList }
    var productCounts by remember {
        mutableStateOf(dataSource.associateWith { 1 }.toMutableMap())
    }

    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)
                    .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding())
            ) {
                items(productCounts.keys.toList()) { product ->
                    val count = productCounts[product] ?: 1
                    CheckoutItem(
                        product = product,
                        count = count,
                        onCountChange = { updatedProduct, newCount ->
                            productCounts = productCounts.toMutableMap().apply {
                                this[updatedProduct] = newCount
                            }
                        },
                        onRemove = { removedProduct ->
                            productCounts = productCounts.toMutableMap().apply {
                                remove(removedProduct)
                            }
                        }
                    )
                }
            }

            val isListEmpty = dataSource.isEmpty()
            Button(
                onClick = {
                    navController.navigate(CheckoutCompleted.route)
                    dataSource.clear()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .padding(bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()),
                enabled = !isListEmpty
            ) {
                Text(text = "Checkout")
            }
        }
    }
}