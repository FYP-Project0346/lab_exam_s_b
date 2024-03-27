package com.example.practise_project

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.navArgument

class SecondScreen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Display(nav:NavController, context: Context = LocalContext.current){
        var tfValue by remember {
            mutableStateOf("")
        }
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Select City") })
            }
        ) {
            Column(
                Modifier.padding(it)
            ) {
                Row {
                    Image(imageVector = Icons.Default.AddCircle, contentDescription = "Weather")
                }
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){
                    TextField(value = tfValue, onValueChange = {
                        tfValue = it
                    })
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        nav.navigate("/third-screen/$tfValue")
                    }) {
                        Text(text = "Show Weather")
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun SecondScreenPreview(){
    SecondScreen().Display(NavController(LocalContext.current))
}