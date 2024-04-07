package com.myprojects.wishlistapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.IconButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprojects.wishlistapp.R


@Preview(showBackground = true)
@Composable
fun HomeView() {
    Scaffold (
        modifier = Modifier,
        topBar = { AppBar(title = "WishList", onBackNav = {}) }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    onBackNav: () -> Unit
) {

    val navigationIcon: (@Composable () -> Unit)? = {
        IconButton(onClick = onBackNav) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                tint = Color.White,
                contentDescription = null
            )
        }
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
        navigationIcon = { Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")}
    )
}