package com.challenge_hw

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.challenge_hw.data.repository.PropertyRepository
import com.challenge_hw.data.service.PropertyApi
import com.challenge_hw.ui.theme.ChallengehwTheme
import com.challenge_hw.ui.presentation.PropertyListScreen
import com.challenge_hw.ui.presentation.PropertyViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChallengehwTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    PropertyListScreen(
                        PropertyViewModel(PropertyRepository(PropertyApi()))
                    )
                }
            }
        }
    }
}
