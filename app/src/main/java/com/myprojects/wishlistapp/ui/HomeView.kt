package com.myprojects.wishlistapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprojects.wishlistapp.R
import com.myprojects.wishlistapp.Wish


@SuppressLint("ResourceAsColor")
@Preview(showBackground = true)
@Composable
fun HomeView() {
    val wishList: List<Wish> = listOf(Wish(2, "This is the title", "Descritption of title"))

    Scaffold (
        modifier = Modifier,
        topBar = { AppBar(title = "WishList", onBackNav = {}) },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(20.dp),
                backgroundColor = Color(R.color.app_bar_color),
                contentColor = Color.White,
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(corner = CornerSize(40.dp))
            ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Next screen navigation button")
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(wishList) {
                wish ->
                WishItem(wish = wish) {

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    onBackNav: () -> Unit
) {

    val navigationIcon: (@Composable () -> Unit)? =
        if(!title.contains("WishList")) {
            {
                IconButton(onClick = onBackNav) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        tint = Color.White,
                        contentDescription = null
                    )
                }
            }
        }else {
            null
        }

    TopAppBar(
        title = {
            Text(text = title,
                color = colorResource(R.color.white),
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 28.dp),
                fontSize = 20.sp
            )
        },
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.app_bar_color),
        navigationIcon = navigationIcon
    )
}


@Composable
fun WishItem(wish: Wish, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .clickable { },
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
