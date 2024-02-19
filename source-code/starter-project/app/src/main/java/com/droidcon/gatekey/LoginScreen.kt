package com.droidcon.gatekey

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSignInButtonTapped: () -> Unit = {},
    onSignUpButtonTapped: () -> Unit = {},
) {
    Box(modifier.fillMaxSize()) {
        Column(
            modifier
                .fillMaxSize()
                .padding(vertical = 64.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text("Hello World", modifier.fillMaxSize(), textAlign = TextAlign.Center)
        }
    }
}