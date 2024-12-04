package com.ats.quickmart.onBoard.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ats.quickmart.onBoard.reuseableCard.RestaurantCard
import com.ats.quickmart.onBoard.reuseableCard.SearchBar

@Composable
fun SearchScreen() {
    val foodImages = listOf(
        "https://img.freepik.com/free-photo/chicken-skewers-with-slices-apples-chili_2829-19992.jpg",
        "https://img.freepik.com/free-photo/lavash-rolls-with-stuffings-tomatoes_114579-3418.jpg",
        "https://img.freepik.com/free-photo/asian-food-restaurant_7939-2017.jpg",
        "https://img.freepik.com/free-photo/meat-sadj-vegetables-greens-spices-top-view_140725-11308.jpg",
        "https://img.freepik.com/free-photo/chicken-skewers-with-slices-apples-chili_2829-19992.jpg",
        "https://img.freepik.com/free-photo/lavash-rolls-with-stuffings-tomatoes_114579-3418.jpg",
        "https://img.freepik.com/free-photo/asian-food-restaurant_7939-2017.jpg",
        "https://img.freepik.com/free-photo/meat-sadj-vegetables-greens-spices-top-view_140725-11308.jpg"
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
        SearchBar()
        foodImages.forEach {
            RestaurantCard(it)
        }
    }
}