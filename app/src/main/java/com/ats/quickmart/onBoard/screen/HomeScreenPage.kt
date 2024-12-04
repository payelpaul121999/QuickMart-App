package com.ats.quickmart.onBoard.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ats.quickmart.auth.viewmodel.AuthViewModel
import com.ats.quickmart.onBoard.data.Food
import com.ats.quickmart.onBoard.navigation.BottomNavigationBar
import com.ats.quickmart.onBoard.navigation.NavHostContainer
import com.ats.quickmart.onBoard.reuseableCard.AutoScrollingFoodBanner
import com.ats.quickmart.onBoard.reuseableCard.FoodHorizontalGrid
import com.ats.quickmart.onBoard.reuseableCard.RestaurantCard
import com.ats.quickmart.onBoard.reuseableCard.SearchBar
import com.ats.quickmart.onBoard.reuseableCard.SearchBarWithVegMode
import org.koin.androidx.compose.getViewModel



@Composable
fun HomeScreenPage(
    navController: NavController,
    viewModel: AuthViewModel = getViewModel()
) {
    val navController = rememberNavController()

    Surface(color = Color.White) {
        // Scaffold Component
        Scaffold(
            // Bottom navigation
            bottomBar = {
                BottomNavigationBar(navController = navController)
            }, content = { padding ->
                // Navhost: where screens are placed
                NavHostContainer(navController = navController, padding = padding)
            }
        )
    }
}







@Composable
fun HomeScreen() {

    val foodImages = listOf(
        "https://img.freepik.com/free-photo/chicken-skewers-with-slices-apples-chili_2829-19992.jpg",
        "https://img.freepik.com/free-photo/lavash-rolls-with-stuffings-tomatoes_114579-3418.jpg",
        "https://img.freepik.com/free-photo/asian-food-restaurant_7939-2017.jpg",
        "https://img.freepik.com/free-photo/meat-sadj-vegetables-greens-spices-top-view_140725-11308.jpg"
    )
    val sampleFoodItems = listOf(
        Food("https://img.freepik.com/free-photo/chicken-skewers-with-slices-apples-chili_2829-19992.jpg", "Biryani"),
        Food("https://img.freepik.com/free-photo/lavash-rolls-with-stuffings-tomatoes_114579-3418.jpg", "Pasta"),
        Food("https://img.freepik.com/free-photo/meat-sadj-vegetables-greens-spices-top-view_140725-11308.jpg", "Pizza"),
        Food("https://img.freepik.com/free-photo/chicken-skewers-with-slices-apples-chili_2829-19992.jpg", "Salad"),
        Food( "https://img.freepik.com/free-photo/lavash-rolls-with-stuffings-tomatoes_114579-3418.jpg", "Soup"),
        Food("https://img.freepik.com/free-photo/chicken-skewers-with-slices-apples-chili_2829-19992.jpg", "Dessert"),
        Food("https://img.freepik.com/free-photo/lavash-rolls-with-stuffings-tomatoes_114579-3418.jpg", "Sushi"),
        Food("https://img.freepik.com/free-photo/meat-sadj-vegetables-greens-spices-top-view_140725-11308.jpg", "Samosa")
    )
    // Column Composable,
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(Color.White)
            .padding(0.dp,20.dp,0.dp,0.dp)
        ,
        // Parameters set to place the items in center
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        //SearchBarWithVegMode()
        SearchBar()
        // Icon Composable
        AutoScrollingFoodBanner(foodImages)
        FoodHorizontalGrid(foodItems = sampleFoodItems)
        foodImages.forEach {
            RestaurantCard(it)
        }


       /* Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "home",
            tint = Color(0xFF0F9D58)
        )
        // Text to Display the current Screen
        Text(text = "Home", color = Color.Black)*/
    }
}

