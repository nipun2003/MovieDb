package com.nipunapps.moviedb.feature_auth.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nipunapps.moviedb.R
import com.nipunapps.moviedb.core.components.CustomFilledButton
import com.nipunapps.moviedb.core.components.CustomOutlinedButton
import com.nipunapps.moviedb.core.components.CustomTextFieldFilled
import com.nipunapps.moviedb.core.components.KeyboardCategory
import com.nipunapps.moviedb.feature_auth.presentation.components.AlternateAuthOption
import com.nipunapps.moviedb.feature_auth.presentation.components.SocialMediaButton
import com.nipunapps.moviedb.feature_auth.presentation.view_models.LoginViewModel
import com.nipunapps.moviedb.ui.AuthScreens
import com.nipunapps.moviedb.ui.Screen
import com.nipunapps.moviedb.ui.theme.SpacingL
import com.nipunapps.moviedb.ui.theme.SpacingS
import com.nipunapps.moviedb.ui.theme.SpacingXL
import com.nipunapps.moviedb.ui.theme.SpacingXXL

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val email = loginViewModel.emailState.collectAsState().value
    val password = loginViewModel.passwordState.collectAsState().value
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = SpacingL, horizontal = SpacingXL),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.marvel_logo),
                    contentDescription = "marvel logo",
                    modifier = Modifier
                        .fillMaxWidth(0.57f),
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.Center
                )
                Spacer(modifier = Modifier.height(SpacingXXL))
                CustomTextFieldFilled(
                    value = email,
                    hint = R.string.email_hint,
                    keyboardCategory = KeyboardCategory.EMAIL,
                    onTextChange = loginViewModel::onEmailChange
                )
                Spacer(modifier = Modifier.height(SpacingS))
                CustomTextFieldFilled(
                    value = password,
                    hint = R.string.password_hint,
                    keyboardCategory = KeyboardCategory.PASSWORD,
                    onTextChange = loginViewModel::onPasswordChange
                )
                Spacer(modifier = Modifier.height(SpacingL))
                CustomFilledButton(text = R.string.login) {

                }
                Spacer(modifier = Modifier.height(SpacingS))
                Text(
                    text = stringResource(id = R.string.forgot_password),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                    modifier = Modifier.align(Alignment.End)
                )
                Spacer(modifier = Modifier.height(SpacingXXL))
                Text(
                    text = stringResource(id = R.string.or),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                )
                Spacer(modifier = Modifier.height(SpacingL))
                Text(
                    text = stringResource(id = R.string.continue_with),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Spacer(modifier = Modifier.height(SpacingL))
                SocialMediaButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = SpacingL)
                )
                Spacer(modifier = Modifier.height(SpacingXXL))
                AlternateAuthOption(
                    disabledText = R.string.no_account,
                    clickableText = R.string.register
                ) {
                    navController.navigate(AuthScreens.LoginScreen.route) {
                        popUpTo(Screen.AuthScreen.route)
                    }
                }
            }
        }
    }
}