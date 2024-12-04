package com.ats.quickmart.auth

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ats.quickmart.auth.screen.LoginScreen
import com.ats.quickmart.auth.screen.RegisterScreen

@Composable
fun AuthNavigation(
    navController: NavHostController
) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = AuthScreen.LoginScreen.route
    ) {
        composable(AuthScreen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(AuthScreen.SignUpScreen.route) {
            RegisterScreen(navController = navController)
        }
    }
}