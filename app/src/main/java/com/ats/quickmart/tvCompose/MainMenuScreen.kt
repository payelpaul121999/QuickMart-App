package com.ats.quickmart.tvCompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ats.quickmart.onBoard.data.Food
@Composable
fun BottomScrollableRow() {
    val sampleFoodItems = listOf(
        Food("https://img.freepik.com/free-photo/chicken-skewers-with-slices-apples-chili_2829-19992.jpg", "Biryani"),
        Food("https://img.freepik.com/free-photo/lavash-rolls-with-stuffings-tomatoes_114579-3418.jpg", "Pasta"),
        Food("https://img.freepik.com/free-photo/meat-sadj-vegetables-greens-spices-top-view_140725-11308.jpg", "Pizza"),
        Food("https://img.freepik.com/free-photo/chicken-skewers-with-slices-apples-chili_2829-19992.jpg", "Salad"),
        Food( "https://img.freepik.com/free-photo/lavash-rolls-with-stuffings-tomatoes_114579-3418.jpg", "Soup")

    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Add your background content here if needed
        Image(
            painter = rememberAsyncImagePainter("https://img.bdcnetwork.com/files/base/ebm/bdcnetwork/image/2024/09/66fb24141a3f5983e2d514ae-adobestock_624499925.png"),
            contentDescription = "Food Image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp), // Adjust padding if needed
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .fillMaxWidth(), // Allows the Row to scroll horizontally
                horizontalArrangement = Arrangement.Center
            ) {
                sampleFoodItems.forEach {
                    CustomIconCard() // Replace with your composable
                }
            }
        }
    }
}
