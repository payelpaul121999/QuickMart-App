package com.ats.quickmart

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ats.quickmart.auth.AuthActivity
import com.ats.quickmart.onBoard.OnBoardActivity
import com.ats.quickmart.ui.theme.QuickMartTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val splashScreen = installSplashScreen()
        setContent {
            LaunchedEffect(Unit) {
                delay(2000)
                withContext(Dispatchers.Main) {
                    val localAPiToken = ""/*dataPreferences.getApiKey()*/
                    finish()
                    if (localAPiToken != "m") {
                        startActivity(Intent(this@MainActivity, OnBoardActivity::class.java))
                    } else {
                        startActivity(Intent(this@MainActivity, AuthActivity::class.java))
                    }
                }
            }
            Scaffold(
                modifier = Modifier.fillMaxSize()
            ) {
                var offsetState by remember { mutableStateOf(0f) }
                val animatedOffset by animateFloatAsState(
                    targetValue = offsetState,
                    animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
                )

                LaunchedEffect(Unit) {
                    while (true) {
                        offsetState = 20f
                        delay(1000)
                        offsetState = -20f
                        delay(1000)
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .offset(y = animatedOffset.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.app_icon),
                        contentScale = ContentScale.Fit,
                        contentDescription = "description"
                    )
                }
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuickMartTheme {
        Greeting("Android")
    }
}