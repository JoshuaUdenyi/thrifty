package com.udenyijoshua.thrifty.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.udenyijoshua.thrifty.navigation.Destinations

sealed class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean = false,
    override val route: String
) : Destinations {


    object Home : NavigationItem(
        title = "Shop",
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
        hasNews = false,
        route = "Home" // Provide the route for Home
    )

    object Checkout: NavigationItem(
        title = "Checkout",
        selectedIcon = Icons.Filled.ExitToApp,
        unselectedIcon = Icons.Outlined.ExitToApp,
        hasNews = true,
        route = "Checkout" // Provide the route for Checkout
    )
}