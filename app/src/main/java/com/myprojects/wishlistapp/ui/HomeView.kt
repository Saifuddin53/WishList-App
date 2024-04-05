package com.myprojects.wishlistapp.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myprojects.wishlistapp.R


@Preview(showBackground = true)
@Composable
fun HomeView() {
    Scaffold (
        modifier = Modifier,
        topBar = { AppBar("WishListapp") }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    onBackNav: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "")
        },
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.app_bar_color)
    )
}