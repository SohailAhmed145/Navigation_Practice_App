package com.example.navigationpracticeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationpracticeapp.screens.Destination
import com.example.navigationpracticeapp.screens.HomeScreen
import com.example.navigationpracticeapp.screens.SettingsScreen
import com.example.navigationpracticeapp.ui.theme.NavigationPracticeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationPracticeAppTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(){
    MyNavigation()
    val navController = rememberNavController()
    Scaffold(bottomBar = { MyBottomNavigation(navController = navController) }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(navController = navController, startDestination = HomeScreen.route){
                composable(HomeScreen.route){
                    HomeScreen(navController)
                }
                composable(SettingsScreen.route){
                    SettingsScreen(navController)
                }
            }


        }
    }
}


@Composable
fun MyNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreen.route){
        composable(HomeScreen.route){
            HomeScreen(navController)
        }
        composable(SettingsScreen.route){
            SettingsScreen(navController)
        }
    }
    MyBottomNavigation(navController = navController)
}

@Composable
fun MyBottomNavigation( navController : NavController){
    val destinationList = listOf<Destination>(
        HomeScreen,
        SettingsScreen
    )
    var selectedIndex by rememberSaveable {
        mutableStateOf(0)
    }
    BottomNavigation (
        backgroundColor = Color(0xFFF44336)
    ){
        destinationList.forEachIndexed { index, destination ->
            BottomNavigationItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                label = { Text(text = destination.title, color = Color(0xFF59FF00)) },
                selected = index == selectedIndex,
                onClick = {
                          selectedIndex = index
                    navController.navigate(destinationList[index].route){
                        popUpTo(HomeScreen.route)
                        launchSingleTop = true
                    }
                          },
                icon = { Icon(imageVector = destination.icon,
                    contentDescription = destination.title, tint = Color(0xFF59FF00)
                )
                },
                selectedContentColor = Color.White,
            )

        }
    }

}
