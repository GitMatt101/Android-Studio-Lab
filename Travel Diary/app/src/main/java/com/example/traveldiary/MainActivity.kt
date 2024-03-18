package com.example.traveldiary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.traveldiary.ui.theme.TravelDiaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelDiaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        topBar = {
                            AppBar(title = "First Scene", navController = navController)
                        }
                    ) {
                        contentPadding -> NavGraph(navController, Modifier.padding(contentPadding))
                    }
                }
            }
        }
    }
}

sealed class NavigationRoute(val route: String) {
    data object Home: NavigationRoute("Home")
    data object Details: NavigationRoute("Details")
    data object Add: NavigationRoute("Add")
    data object Settings: NavigationRoute("Settings")
}

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.Home.route,
        modifier = modifier
    ) {
        composable(NavigationRoute.Home.route) {
            Home(navController)
        }
        composable(NavigationRoute.Details.route) {
            Details(navController)
        }
        composable(NavigationRoute.Add.route) {
            Add(navController)
        }
        composable(NavigationRoute.Settings.route) {
            Settings(navController)
        }
    }
}