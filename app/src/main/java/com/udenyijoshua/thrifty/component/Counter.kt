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
fun Counter(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        var counter by remember {
            mutableIntStateOf(1)
        }
        TextButton(
            onClick = {
                counter--
            }
        ) {
            Text(
                text = "-",
            )
        }
        Text(
            text = counter.toString(),
            //style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(16.dp)
        )
        TextButton(
            onClick = {
                counter++
            }
        ) {
            Text(
                text = "+",
               // style = MaterialTheme.typography.h2
            )
        }
    }
}