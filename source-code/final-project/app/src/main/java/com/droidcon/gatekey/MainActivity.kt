package com.droidcon.gatekey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.droidcon.gatekey.ui.theme.GateKeyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GateKeyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GateKeyNavHost()
                }
            }
        }
    }
}

@Composable
fun GateKeyNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(onSignInButtonTapped = {
            navController.navigate("home")
        }, onSignUpButtonTapped = {
            navController.navigate("home")
        }) }
        composable("home") { HomeScreen() }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GateKeyTheme {
        LoginScreen()
    }
}