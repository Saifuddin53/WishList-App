package com.myprojects.wishlistapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.myprojects.wishlistapp.ui.AddWishView
import com.myprojects.wishlistapp.ui.HomeView

@Composable
fun Navigation(wishViewModel: WishViewModel = viewModel(), 
               navController: NavHostController = rememberNavController()
    )
    {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeView(navController, wishViewModel)
        }
        composable(route = Screen.UpdateScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = 0L
                    nullable = false
                }
            )
        ) {entry ->
            val id = if(entry.arguments != null) entry.arguments!!.getLong("id") else 0L
            AddWishView(id, wishViewModel, navController = navController)
        }
    }
}