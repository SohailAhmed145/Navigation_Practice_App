package com.example.navigationpracticeapp.screens

interface Destination{
    val route: String
}

object ScreenA : Destination {
    override val route = "screenA"
}

object ScreenB : Destination{
    override val route = "screenB"
}