package com.udenyijoshua.thrifty.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Counter(
    count: Int, // Current count value
    onIncrement: () -> Unit,
    onDecrement: () -> Unit, // Callback for decrement
    modifier: Modifier = Modifier
) {
    Row {
        TextButton(onClick = onDecrement ) {
            Text(text = "-")
        }
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.bodyMedium, // Use appropriate typography
            modifier = Modifier.padding(16.dp)
        )
        TextButton(
            onClick = onIncrement // Call the increment callback
        ) {
            Text(text = "+")
        }
    }

}
