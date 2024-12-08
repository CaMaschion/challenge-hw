package com.challenge_hw

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.challenge_hw.data.repository.PropertyRepository
import com.challenge_hw.data.service.PropertyApi
import com.challenge_hw.ui.presentation.PropertyDetailScreen
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
                ChallengeApp()
            }
        }
    }
}

@Composable
fun ChallengeApp(
    viewModel: PropertyViewModel = PropertyViewModel(PropertyRepository(PropertyApi())),
    navController: NavHostController = rememberNavController()
) {

    NavHost(navController = navController, startDestination = "property_list") {
        composable("property_list") {
            PropertyListScreen(viewModel = viewModel, navigation = navController)
        }
        composable("property_details/{propertyId}") { backStackEntry ->

            PropertyDetailScreen(propertyId = backStackEntry.arguments?.getString("propertyId"))
        }
    }
}
