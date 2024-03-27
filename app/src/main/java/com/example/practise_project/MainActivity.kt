package com.example.practise_project

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practise_project.ui.theme.Practise_projectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practise_projectTheme {
                // A surface container using the 'background' color from the theme
                Main()
            }
        }
    }
}

@Composable
fun Main(context: Context = LocalContext.current) {
    var controller = rememberNavController()
    NavHost(navController = controller, startDestination = "/") {
        composable("/") {
            SplashScreen().Display(nav = controller)
        }
        composable("/second-screen"){
            SecondScreen().Display(controller)
        }
        composable("/third-screen/{city}"){
            var city = it.arguments?.getString("city")
            ThirdScreen().Display(city = city ?: "No City", nav=controller)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Main()
}