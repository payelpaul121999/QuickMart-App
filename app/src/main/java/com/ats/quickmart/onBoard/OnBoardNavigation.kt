package com.ats.quickmart.onBoard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ats.quickmart.onBoard.screen.HomeScreenPage
import com.ats.quickmart.ui.theme.primary

@Composable
fun HomeNavigation(
    navController: NavHostController
) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = HomeScreen.Home.route
    ) {
        composable(HomeScreen.Home.route) {
            HomeScreenPage(navController = navController)
        }
        composable(HomeScreen.WinScreen.route) {
          //  GameRulesScreen(navController = navController)
        }
        composable(HomeScreen.ContactUsScreen.route) {
           // ContactScreen(navController = navController)
        }
        composable(HomeScreen.ProfileScreen.route) {
           // ProfileScreen(navController = navController)
        }
        composable(HomeScreen.YourBetScreen.route) {
           // YourBetScreen(navController = navController)
        }
    }
}




