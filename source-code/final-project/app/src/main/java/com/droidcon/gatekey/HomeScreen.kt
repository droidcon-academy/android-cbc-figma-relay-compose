package com.droidcon.gatekey

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {
    Box {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Welcome!",
            style = MaterialTheme.typography.displayLarge
        )
    }
}