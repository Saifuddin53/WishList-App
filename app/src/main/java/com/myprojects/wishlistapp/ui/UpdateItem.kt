package com.myprojects.wishlistapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.myprojects.wishlistapp.AppBar
import com.myprojects.wishlistapp.WishViewModel
import com.myprojects.wishlistapp.data.Wish
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddWishView(
    id: Long,
    wishViewModel: WishViewModel,
    navController: NavController
) {

    val snackMessage = remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    if(id != 0L) {
        val wish = wishViewModel.getWishById(id).collectAsState(initial = Wish(0L, "", ""))
        wishViewModel.wishTitleState = wish.value.title
        wishViewModel.wishDescriptionState = wish.value.description
    }else{
        wishViewModel.wishTitleState = ""
        wishViewModel.wishDescriptionState = ""
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { AppBar(title = (
            if(id != 0L) "Update Wish" else "Add Wish" )
            , onBackNav = {navController.navigateUp()})
        })
    {
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.heightIn(8.dp))

            ViewTextField("Title",
                wishViewModel.wishTitleState,
                {wishViewModel.onWishTitleChange(it)})

            Spacer(modifier = Modifier.heightIn(8.dp))

            ViewTextField("Description",
                wishViewModel.wishDescriptionState,
                {wishViewModel.onWishDescriptionChange(it)})

            Spacer(modifier = Modifier.heightIn(40.dp))

            Button(onClick = {
                if(wishViewModel.wishTitleState.isNotEmpty()
                    &&
                    wishViewModel.wishDescriptionState.isNotEmpty()) {
                    if(id != 0L) {
                            wishViewModel.updateWish(
                                Wish(id = id,
                                    title = wishViewModel.wishTitleState.trim(),
                                    description = wishViewModel.wishDescriptionState)
                            )
                        snackMessage.value = "Wish updated successfully"
                    }else {
                        wishViewModel.insertWish(
                            Wish(title = wishViewModel.wishTitleState,
                                description = wishViewModel.wishDescriptionState)
                        )
                        snackMessage.value = "Wish added successfully"
                    }
                }else {
                    snackMessage.value = "Enter the required fields"
                }
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                    navController.navigateUp()
                }
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                )) {
                Text(text = if(id != 0L) "Update Wish" else "Add Wish" )
            }
        }
    }
}

@Composable
fun ViewTextField(
    placeHolder: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = placeHolder)
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            cursorColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            )
    )
}