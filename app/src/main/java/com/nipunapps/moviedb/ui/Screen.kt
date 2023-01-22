package com.nipunapps.moviedb.ui

sealed class Screen(val route : String){
    object SplashScreen : Screen("/")
    object OnBoardingScreen : Screen("/on-boarding")
}
