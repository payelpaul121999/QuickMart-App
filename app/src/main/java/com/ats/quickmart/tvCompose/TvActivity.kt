package com.ats.quickmart.tvCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class TvActivity  : ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val splashScreen = installSplashScreen()
        setContent {
            BottomScrollableRow()
        }
    }
}


