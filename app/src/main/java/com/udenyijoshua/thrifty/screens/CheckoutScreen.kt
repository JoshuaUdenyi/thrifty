package com.udenyijoshua.thrifty.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.udenyijoshua.thrifty.component.CheckoutItem
import com.udenyijoshua.thrifty.model.CheckoutDataSource
import com.udenyijoshua.thrifty.navigation.CheckoutCompleted


@Composable
fun CheckoutScreen(navController: NavHostController, modifier: Modifier = Modifier){

   val dataSource = remember { CheckoutDataSource.checkOutList }
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)
                    .padding(
                        top = WindowInsets
                            .statusBars
                            .asPaddingValues()
                            .calculateTopPadding()
                    )
            ) {
                items(dataSource) { item ->
                    CheckoutItem(item)
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
                    .padding(
                        bottom = WindowInsets
                            .navigationBars
                            .asPaddingValues()
                            .calculateBottomPadding()
                    ),
                enabled = !isListEmpty
            ) {
                Text(text = "Checkout")
            }
        }
    }
}