package com.example.traveldiary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, navController: NavHostController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val title = when (backStackEntry?.destination?.route) {
        NavigationRoute.Home.route -> "TravelDiary"
        NavigationRoute.Details.route -> "Travel Details"
        NavigationRoute.Add.route -> "Add Travel"
        NavigationRoute.Settings.route -> "Settings"
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
fun Home(navController: NavHostController) {
    val items = (1..100).toList().map { "item n°$it" }
    LazyColumn {
        items(items) {
            Button(onClick = { navController.navigate(NavigationRoute.Details.route) }) {
                Text(it)
            }
        }
    }
}

@Composable
fun Details(navController: NavHostController) {
    /*Row {
        Button(onClick = { navController.navigateUp() }) {
            Text("Screen1")
        }
        Button(onClick = { navController.navigate(NavigationRoute.Screen3.route) }) {
            Text("Screen3")
        }
    }*/
}

@Composable
fun Add(navController: NavHostController) {

}

@Composable
fun Settings(navController: NavHostController) {

}