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
import com.droidcon.gatekey.logo.Logo
import com.droidcon.gatekey.signinbuttons.SignInButtons
import com.droidcon.gatekey.signinfields.SignInFields
import com.droidcon.gatekey.signinmessages.SignInMessages
import com.droidcon.gatekey.termsandconditions.IsChecked
import com.droidcon.gatekey.termsandconditions.TermsAndConditions

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSignInButtonTapped: () -> Unit = {},
    onSignUpButtonTapped: () -> Unit = {},
) {
    var isTermsChecked by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(modifier.fillMaxSize()) {
        Column(
            modifier
                .fillMaxSize()
                .padding(vertical = 64.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Logo(modifier = Modifier.fillMaxWidth())
            SignInMessages(modifier = Modifier.fillMaxWidth())
            SignInFields(modifier = Modifier.fillMaxWidth(),
                email = email,
                password = password,
                onEmailChange = {email = it},
                onPasswordChange = {password = it}
                )
            TermsAndConditions(
                modifier = Modifier.fillMaxWidth(),
                onTap = { isTermsChecked = !isTermsChecked },
                isChecked = if (isTermsChecked) IsChecked.True else IsChecked.False,
                description = "I agree to the Terms and Conditions"
            )
            SignInButtons(
                modifier = Modifier.fillMaxWidth(),
                signInLabel = "Sign in now",
                signUpLabel = "Sign Up",
                onSignInTapped = onSignInButtonTapped,
                onSignUpTapped = onSignUpButtonTapped,
            )
        }
    }
}