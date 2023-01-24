package com.nipunapps.moviedb.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.nipunapps.moviedb.feature_auth.presentation.screens.AuthHomeScreen
import com.nipunapps.moviedb.feature_auth.presentation.screens.LoginScreen
import com.nipunapps.moviedb.feature_auth.presentation.screens.RegisterScreen
import com.nipunapps.moviedb.first_time_display.presentation.OnboardingScreen
import com.nipunapps.moviedb.first_time_display.presentation.SplashScreen
import com.nipunapps.moviedb.ui.theme.MovieDbTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MovieDbTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberAnimatedNavController()

                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Screen.SplashScreen.route,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        composable(route = Screen.SplashScreen.route) {
                            SplashScreen(navController = navController)
                        }
                        composable(route = Screen.OnBoardingScreen.route) {
                            OnboardingScreen(navController = navController)
                        }
                        authGraph(navController)
                    }
                }
            }
        }
    }

    private fun NavGraphBuilder.authGraph(navController: NavController) {
        navigation(
            startDestination = AuthScreens.HomeScreen.route,
            route = Screen.AuthScreen.route
        ) {
            composable(route = AuthScreens.HomeScreen.route) {
                AuthHomeScreen(navController = navController)
            }
            composable(route = AuthScreens.RegisterScreen.route) {
                RegisterScreen(navController = navController)
            }
            composable(route = AuthScreens.LoginScreen.route) {
                LoginScreen(navController = navController)
            }
        }
    }
}