package com.udenyijoshua.thrifty.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.udenyijoshua.thrifty.R
import com.udenyijoshua.thrifty.component.BottomNavigation
import com.udenyijoshua.thrifty.navigation.AppNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostScreen(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = stringResource(R.string.thrifty))
            })
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
        ){
          AppNavHost(navController = navController)
        }

    }
}