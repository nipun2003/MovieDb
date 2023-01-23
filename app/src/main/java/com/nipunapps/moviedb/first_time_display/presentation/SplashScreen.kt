package com.nipunapps.moviedb.first_time_display.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nipunapps.moviedb.first_time_display.presentation.view_models.SplashViewModel
import com.nipunapps.moviedb.ui.Screen
import kotlinx.coroutines.delay
import com.nipunapps.moviedb.R

@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val appRemember = splashViewModel.appRemember
    LaunchedEffect(key1 = true) {
        delay(1000)
        val route = if (appRemember.value.isOnboardingViewed) Screen.AuthScreen.route
        else Screen.OnBoardingScreen.route
        navController.navigate(route) {
            popUpTo(Screen.SplashScreen.route) {
                inclusive = true
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.marvel_logo),
            contentDescription = "Marvel Logo",
            modifier = Modifier.fillMaxWidth(0.75f),
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center
        )
    }
}