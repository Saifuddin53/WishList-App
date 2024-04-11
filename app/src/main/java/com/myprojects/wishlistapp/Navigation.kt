package com.myprojects.wishlistapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myprojects.wishlistapp.ui.HomeView

@Composable
fun Navigation(wishViewModel: WishViewModel = viewModel(), 
               navController: NavHostController = rememberNavController()
    )
    {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeView()
        }
//        composable(route = Screen.UpdateScreen.route) {
//            AddWishView()
//        }
    }
}