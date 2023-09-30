package com.droidcon.gatekey

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.droidcon.gatekey.logo.Logo
import com.droidcon.gatekey.signinbuttons.SignInButtons
import com.droidcon.gatekey.signinfields.SignInFields
import com.droidcon.gatekey.signinmessages.SignInMessages
import com.droidcon.gatekey.termsandconditions.TermsAndConditions

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSignInButtonTapped: () -> Unit = {},
    onSignUpButtonTapped: () -> Unit = {},
) {
    var email by remember { mutableStateOf("account@gmail.com") }
    var password by remember { mutableStateOf("password") }
    Box(modifier.fillMaxSize()) {
        Column(
            modifier
                .fillMaxSize()
                .padding(vertical = 64.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Logo(modifier = Modifier.fillMaxWidth())
            SignInMessages(modifier = Modifier.fillMaxWidth())
            SignInFields(
                modifier = Modifier.fillMaxWidth(),
                onEmailChanged = {email = it},
                onPasswordChange = {password = it},
                email = email,
                password = password,
            )
            TermsAndConditions(
                modifier = Modifier.fillMaxWidth(),
                description = "I agree to the Terms and conditions"
            )
            SignInButtons(
                modifier = Modifier.fillMaxWidth(),
                onSignInButtonTapped = onSignInButtonTapped,
                onSignUpButtonTapped = onSignUpButtonTapped,
            )
        }
    }
}