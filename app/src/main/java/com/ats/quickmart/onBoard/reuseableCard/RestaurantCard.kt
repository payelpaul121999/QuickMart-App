package com.ats.quickmart.onBoard.reuseableCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter


import com.ats.quickmart.R

@Composable
fun RestaurantCard(image:String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.height(290.dp)
                .background(Color.White)
        ) {
            // Image section with overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
            ) {
                // Background image
                Image(
                    painter = rememberAsyncImagePainter(image),
                    contentDescription = "Food Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(160.dp).fillMaxWidth()
                )
                // Text overlay
                Text(
                    text = "Mutton Riyazi Biryani [20...] ₹430",
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
                // Top-right icons
                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                ) {
                    /*Icon(
                        imageVector = Icons.Default.Star, // Replace with the right icon
                        contentDescription = "Bookmark",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )*/
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.Favorite, // Replace with the right icon
                        contentDescription = "Hide",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }

            }
            Spacer(modifier = Modifier.height(2.dp))
            // Restaurant details section
            Column(modifier = Modifier.padding(5.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_refresh), // Replace with your flash icon
                        contentDescription = null,
                        tint = Color.Green,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "14 mins • 1 km",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Taj Mahal Restaurant & Caterer",
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Biryani • North Indian • ₹200 for one",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider(color = Color.Gray.copy(alpha = 0.5f), thickness = 1.dp)
                Spacer(modifier = Modifier.height(8.dp))
                // Discount and rating
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_refresh), // Replace with your offer icon
                            contentDescription = null,
                            tint = Color.Blue,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Flat ₹50 OFF above ₹199",
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "4.1",
                            color = Color.White,
                            modifier = Modifier
                                .background(Color.Green, RoundedCornerShape(4.dp))
                                .padding(horizontal = 1.dp, vertical = 2.dp),
                            fontSize = 12.sp
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_star_rate), // Replace with your star icon
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }
            }

        }
    }
}
