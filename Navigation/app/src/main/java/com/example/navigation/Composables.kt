package com.example.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, navController: NavHostController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val title = when (backStackEntry?.destination?.route) {
        NavigationRoute.Screen1.route -> "First Screen"
        NavigationRoute.Screen2.route -> "Second Screen"
        NavigationRoute.Screen3.route -> "Third Screen"
        else -> ""
    }
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Outlined.ArrowBack, contentDescription = "Go back")
                }
            }
        }
    )
}

@Composable
fun Screen1(navController: NavHostController) {
    Button(onClick = { navController.navigate(NavigationRoute.Screen2.route) }) {
        Text("Screen1")
    }
}

@Composable
fun Screen2(navController: NavHostController) {
    Row {
        Button(onClick = { navController.navigateUp() }) {
            Text("Screen1")
        }
        Button(onClick = { navController.navigate(NavigationRoute.Screen3.route) }) {
            Text("Screen3")
        }
    }
}

@Composable
fun Screen3(navController: NavHostController) {
    Button(onClick = { navController.navigateUp() }) {
        Text("Screen2")
    }
}