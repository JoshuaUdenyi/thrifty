package com.udenyijoshua.thrifty.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.udenyijoshua.thrifty.R
import com.udenyijoshua.thrifty.navigation.Home

@Composable
fun CheckOutCompletedScreen(navController: NavHostController,modifier: Modifier = Modifier){
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            Image(painter = painterResource(
                id = R.drawable.ic_checkout_completed),
                contentDescription = "CheckOutCompleted"
            )
            Spacer(modifier = modifier.height(32.dp))
            Text(text = "You have Successfully checked out your cart")
            Text(text = "Thank you for Shopping with Us!!")

            Spacer(modifier = modifier.height(50.dp))
            Button(onClick = {
                    navController.navigate(Home.route)
            }) {
                Text(text = "Return to Shop")
            }
        }
    }
}
