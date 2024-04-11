package com.myprojects.wishlistapp

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
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddWishView(
    id: Long,
    wishViewModel: WishViewModel,
    navController: NavController
) {
    var valueTitle by remember {
        mutableStateOf("")
    }
    var valueDescription by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = { AppBar(title = (
            if(id != 0L) "Update Wish" else "Add Wish" )
            , onBackNav = {})
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
            ViewTextField("Title", valueTitle, {valueTitle = it})
            Spacer(modifier = Modifier.heightIn(8.dp))
            ViewTextField("Description", valueDescription, {valueDescription = it})
            Spacer(modifier = Modifier.heightIn(40.dp))
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                )) {
                Text(text = "Update Wish")
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