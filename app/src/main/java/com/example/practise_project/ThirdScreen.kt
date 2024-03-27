package com.example.practise_project

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

class ThirdScreen {
    @Composable
    fun Display(nav:NavController, city:String, context: Context = LocalContext.current){
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "City Name: $city", fontSize = 35.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Item("Tempreature", "36 C")
            Item("Humidity", "78%")
            Item("Conidtion", "Good")
        }
    }

    @Composable
    fun Item(title:String, value:String){
        Row(
            Modifier.fillMaxWidth().padding(vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(15.dp))
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "", Modifier.size(25.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column (
                verticalArrangement = Arrangement.Center
            ){

                Text(text = title, fontSize = 22.sp)

                Text(text = value, fontSize = 15.sp)
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ThirdScreenPreview(){
    ThirdScreen().Display(city="Karachi", nav = NavController(LocalContext.current))
}