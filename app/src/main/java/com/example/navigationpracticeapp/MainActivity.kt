package com.example.navigationpracticeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationpracticeapp.screens.ScreenA
import com.example.navigationpracticeapp.screens.ScreenB
import com.example.navigationpracticeapp.ui.theme.NavigationPracticeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationPracticeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Box(modifier = Modifier.padding(innerPadding)) {
                       MyNavigation()
                   }
                }
            }
        }
    }
}

@Composable
fun MyNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenA.route){
        composable(ScreenA.route){
            ScreenA(navController)
        }
        composable(ScreenB.route){
            ScreenB(navController)
        }
    }
}
