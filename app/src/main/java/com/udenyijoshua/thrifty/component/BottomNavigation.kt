package com.udenyijoshua.thrifty.component

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.udenyijoshua.thrifty.model.NavigationItem

@Composable
fun BottomNavigation(
    navController: NavHostController,
    showBadge: Boolean,
    onShowBadgeChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,

) {
    // Observe current route to updateselectedItemIndex
    val currentRoute = currentRoute(navController)

    val items = listOf(NavigationItem.Home, NavigationItem.Checkout)
    val selectedItemIndex = items.indexOfFirst { it.route == currentRoute }

    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    navController.navigate(item.route)
                    if (item == NavigationItem.Checkout) {
                        onShowBadgeChange(false)
                    }
                },
                label = { Text(text = item.title) },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item == NavigationItem.Checkout && showBadge) {
                                Badge() // Show badge for Checkout if showBadge is true
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (index == selectedItemIndex) {item.selectedIcon
                            } else item.unselectedIcon,
                            contentDescription = item.title
                        )
                    }
                }
            )
        }
    }
}

// Helper function to get the current route
@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}