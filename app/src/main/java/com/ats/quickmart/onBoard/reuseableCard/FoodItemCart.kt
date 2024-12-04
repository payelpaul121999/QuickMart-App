package com.ats.quickmart.onBoard.reuseableCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ats.quickmart.onBoard.data.Food

@Composable
fun FoodHorizontalGrid(foodItems: List<Food>) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2), // Two rows
        modifier = Modifier
            .padding(1.dp).height(220.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalArrangement = Arrangement.Top // No space between rows
    ) {
        items(foodItems) { food ->
            FoodItem(
                imageUrl = food.imageUrl,
                foodName = food.name
            )


        }
    }
}

@Composable
fun FoodItem(imageUrl: String, foodName: String) {
    Column(
        modifier = Modifier.padding(1.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Circular Image
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = "Food Image",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        // Food Name
        Text(
            text = foodName,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}


