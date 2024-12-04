package com.ats.quickmart.onBoard.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ats.quickmart.onBoard.screen.CartScreen
import com.ats.quickmart.onBoard.screen.HomeScreen
import com.ats.quickmart.onBoard.screen.OfferScreen
import com.ats.quickmart.onBoard.screen.ProfileScreen
import com.ats.quickmart.onBoard.screen.SearchScreen

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(paddingValues = padding),
        builder = {
            composable("home") {
                HomeScreen()
            }
            composable("search") {
                SearchScreen()
            }
            composable("offer") {
                OfferScreen()
            }
            composable("cart") {
                CartScreen()
            }
            composable("profile") {
                ProfileScreen()
            }
        })

}
