package com.example.navigationpracticeapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ScreenA(navController: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC107)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Text(
            text = "Screen",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 30.sp,
            color = Color(0xFF2196F3),
            modifier = Modifier.padding(20.dp)
        )
        Button(
            onClick = {
                      navController.navigate("Settings")
                      },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3),
                contentColor = Color.Black
            )
            ) {
            Text("Go to Settings Screen")
        }
    }
}