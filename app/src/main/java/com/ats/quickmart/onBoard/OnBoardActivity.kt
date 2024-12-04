package com.ats.quickmart.onBoard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.ats.quickmart.auth.AuthNavigation
import com.ats.quickmart.onBoard.navigation.BottomNavigationBar
import com.ats.quickmart.onBoard.navigation.NavHostContainer
import com.ats.quickmart.ui.theme.QuickMartTheme

class OnBoardActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickMartTheme {
                val navController = rememberNavController()

                Surface(color = Color.White) {
                    // Scaffold Component
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        }, content = { padding ->
                            NavHostContainer(navController = navController, padding = padding)
                        }
                    )
                }
            }
        }
    }
}