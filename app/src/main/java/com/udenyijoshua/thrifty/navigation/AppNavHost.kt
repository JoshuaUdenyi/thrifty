package com.udenyijoshua.thrifty.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.udenyijoshua.thrifty.screens.CheckOutCompletedScreen
import com.udenyijoshua.thrifty.screens.CheckoutScreen
import com.udenyijoshua.thrifty.screens.ProductScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier : Modifier = Modifier
){
    NavHost(
        navController = navController ,
        startDestination = Home.route
    ) {
        composable(route = Home.route)
        {
            ProductScreen()
        }
        composable(route = Checkout.route)
        {
            CheckoutScreen(navController=navController)
        }
        composable(route = CheckoutCompleted.route){
            CheckOutCompletedScreen(navController=navController)
        }
    }
}