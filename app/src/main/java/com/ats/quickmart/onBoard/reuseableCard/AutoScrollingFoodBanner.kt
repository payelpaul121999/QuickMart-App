package com.ats.quickmart.onBoard.reuseableCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AutoScrollingFoodBanner(imageUrls: List<String>, autoScrollDelay: Long = 2000L) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var selectedPage by remember { mutableStateOf(0) }

    LaunchedEffect(selectedPage) {
        delay(autoScrollDelay) // Wait for the specified delay
        selectedPage = (selectedPage + 1) % imageUrls.size // Move to the next page
        coroutineScope.launch {
            listState.animateScrollToItem(selectedPage)
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Horizontal Banner
        LazyRow(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(imageUrls.size) { index ->
                Image(
                    painter = rememberAsyncImagePainter(imageUrls[index]),
                    contentDescription = null,
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.LightGray),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Dot Indicator
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            repeat(imageUrls.size) { index ->
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(
                            if (index == selectedPage) Color.Blue else Color.Gray
                        )
                )
            }
        }
    }
}
