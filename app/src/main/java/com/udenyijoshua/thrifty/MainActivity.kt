package com.udenyijoshua.thrifty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.udenyijoshua.thrifty.screens.HostScreen
import com.udenyijoshua.thrifty.ui.theme.ThriftyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThriftyTheme {
                HostScreen()
            }
        }
    }
}