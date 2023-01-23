package com.nipunapps.moviedb.feature_auth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.nipunapps.moviedb.R
import com.nipunapps.moviedb.core.Constants
import com.nipunapps.moviedb.core.components.CustomFilledButton
import com.nipunapps.moviedb.core.components.CustomOutlinedButton
import com.nipunapps.moviedb.ui.theme.SpacingL
import com.nipunapps.moviedb.ui.theme.SpacingXL

@Composable
fun AuthHomeScreen(
    navController: NavController
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.75f)
            ) {
                AsyncImage(
                    model = Constants.REG_BACK_IMAGE,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.Center,
                    alpha = 0.6f
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.background.copy(alpha = 0.1f),
                                    MaterialTheme.colorScheme.background.copy(alpha = 0.2f),
                                    MaterialTheme.colorScheme.background.copy(alpha = 0.2f),
                                    MaterialTheme.colorScheme.background.copy(alpha = 0.2f),
                                    MaterialTheme.colorScheme.background.copy(alpha = 0.2f),
                                    MaterialTheme.colorScheme.background.copy(alpha = 0.6f),
                                    MaterialTheme.colorScheme.background.copy(alpha = 0.9f),
                                    MaterialTheme.colorScheme.background.copy(alpha = 1.0f),
                                )
                            )
                        )
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

                }
                Spacer(modifier = Modifier.height(SpacingXL))
                CustomOutlinedButton(text = R.string.register, modifier = Modifier.fillMaxWidth()) {

                }
            }
        }
    }
}