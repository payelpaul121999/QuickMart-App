package com.ats.quickmart.onBoard.reuseableCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


@Composable
fun biriyaniCard(){
    Column(modifier = Modifier) {
        Box(){
            Image(
                painter = rememberAsyncImagePainter("https://img.freepik.com/free-photo/meat-sadj-vegetables-greens-spices-top-view_140725-11308.jpg"),
                contentDescription = "Food Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(60.dp).fillMaxWidth()
            )
            Text(
                text = "Mutton Riyazi Biryani [20...] ₹430",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}