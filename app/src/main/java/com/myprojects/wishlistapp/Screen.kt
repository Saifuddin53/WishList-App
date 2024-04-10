package com.myprojects.wishlistapp

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object UpdateScreen: Screen("update_screen")
}