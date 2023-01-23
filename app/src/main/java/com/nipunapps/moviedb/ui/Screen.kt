package com.nipunapps.moviedb.ui

sealed class Screen(val route : String){
    object SplashScreen : Screen("/")
    object OnBoardingScreen : Screen("/on-boarding")
    object AuthScreen : Screen("/auth")
}

sealed class AuthScreens(val route: String){
    object HomeScreen : AuthScreens("/auth/")
    object RegisterScreen : AuthScreens("/auth/register")
    object LoginScreen : AuthScreens("/auth/login")
}
