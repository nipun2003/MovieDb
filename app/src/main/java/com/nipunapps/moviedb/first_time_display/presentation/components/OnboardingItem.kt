package com.nipunapps.moviedb.first_time_display.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.nipunapps.moviedb.R
import com.nipunapps.moviedb.ui.theme.SpacingL
import com.nipunapps.moviedb.ui.theme.SpacingS
import com.nipunapps.moviedb.ui.theme.SpacingXS


val onboardingItems = listOf(
    OnboardingItem(R.drawable.on_boarding_1, R.string.on_boarding_text_1),
    OnboardingItem(R.drawable.on_boarding_2, R.string.on_boarding_text_2),
    OnboardingItem(R.drawable.on_boarding_3, R.string.on_boarding_text_3),
    OnboardingItem(R.drawable.on_boarding_4, R.string.on_boarding_text_4),
    OnboardingItem(R.drawable.on_boarding_5, R.string.on_boarding_text_5)
)

data class OnboardingItem(
    @DrawableRes
    val image: Int,
    @StringRes
    val text: Int,
)

@Composable
fun SingleOnboarding(
    onboardingItem: OnboardingItem
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = onboardingItem.image),
            contentDescription = stringResource(id = onboardingItem.text),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center,
            alpha = 0.9f
        )
        Image(
            painter = painterResource(id = R.drawable.marvel_logo),
            contentDescription = "marvel logo",
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.57f),
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center
        )
        Text(
            text = stringResource(id = onboardingItem.text),
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(0.57f)
                .padding(bottom = SpacingL),
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun Indicator(
    modifier: Modifier = Modifier,
    count: Int,
    active: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until count) {
            Box(
                modifier = Modifier
                    .padding(horizontal = SpacingXS)
                    .size(SpacingS)
                    .clip(CircleShape)
                    .background(
                        if (i == active) MaterialTheme.colorScheme.primary else
                            MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
                    )
            )
        }
    }
}