package com.myprojects.wishlistapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.myprojects.wishlistapp.AppBar
import com.myprojects.wishlistapp.R
import com.myprojects.wishlistapp.Screen
import com.myprojects.wishlistapp.WishViewModel
import com.myprojects.wishlistapp.data.Wish


@SuppressLint("ResourceAsColor")
@Composable
fun HomeView(navController: NavController, wishViewModel: WishViewModel) {
    val scope = rememberCoroutineScope()

    Scaffold (
        modifier = Modifier,
        topBar = { AppBar(title = "WishList", onBackNav = {}) },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(20.dp),
                backgroundColor = Color(R.color.app_bar_color),
                contentColor = Color.White,
                onClick = {
                          navController.navigate(Screen.UpdateScreen.route + "/0L")
                },
                shape = RoundedCornerShape(corner = CornerSize(40.dp))
            ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Next screen navigation button")
            }
        }
    ) {
        val wishList = wishViewModel.getAllWishes.collectAsState(initial = listOf())
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(wishList.value) {
                wish ->
                WishItem(wish = wish) {
                    val id = wish.id
                    navController.navigate(Screen.UpdateScreen.route + "/$id")
                }
            }
        }
    }
}

@Composable
fun WishItem(wish: Wish, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = wish.title,
                fontWeight = FontWeight.ExtraBold
            )
            Text(text = wish.description)
        }
    }
}
