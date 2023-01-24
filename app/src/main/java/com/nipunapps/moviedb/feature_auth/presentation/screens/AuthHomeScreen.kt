package com.nipunapps.moviedb.feature_auth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.nipunapps.moviedb.R
import com.nipunapps.moviedb.core.Constants
import com.nipunapps.moviedb.core.components.CustomFilledButton
import com.nipunapps.moviedb.core.components.CustomOutlinedButton
import com.nipunapps.moviedb.core.components.GradientImage
import com.nipunapps.moviedb.ui.AuthScreens
import com.nipunapps.moviedb.ui.Screen
import com.nipunapps.moviedb.ui.theme.SpacingXL

@Composable
fun AuthHomeScreen(
    navController: NavController
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            GradientImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.75f),
                imageUri = Constants.REG_BACK_IMAGE
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.75f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.marvel_logo),
                    contentDescription = "marvel logo",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth(0.57f),
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.Center
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.35f)
                    .align(Alignment.BottomCenter)
                    .padding(SpacingXL),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomFilledButton(text = R.string.login, modifier = Modifier.fillMaxWidth()) {
                    navController.navigate(AuthScreens.LoginScreen.route)
                }
                Spacer(modifier = Modifier.height(SpacingXL))
                CustomOutlinedButton(text = R.string.register, modifier = Modifier.fillMaxWidth()) {
                    navController.navigate(AuthScreens.RegisterScreen.route)
                }
            }
        }
    }
}