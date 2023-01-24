package com.nipunapps.moviedb.first_time_display.presentation.components

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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.nipunapps.moviedb.R
import com.nipunapps.moviedb.first_time_display.domain.model.OnboardingItem
import com.nipunapps.moviedb.ui.theme.SpacingM
import com.nipunapps.moviedb.ui.theme.SpacingS
import com.nipunapps.moviedb.ui.theme.SpacingXL
import com.nipunapps.moviedb.ui.theme.SpacingXS

@Composable
fun SingleOnboarding(
    onboardingItem: OnboardingItem
) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = onboardingItem.image,
            contentDescription = onboardingItem.text,
            modifier = Modifier
                .fillMaxSize()
                .zIndex(-1f),
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center,
            alpha = 0.8f
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
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.background.copy(alpha = 0.0f),
                            MaterialTheme.colorScheme.background.copy(alpha = 0.6f),
                            MaterialTheme.colorScheme.background.copy(alpha = 0.7f),
                            MaterialTheme.colorScheme.background.copy(alpha = 0.8f),
                            MaterialTheme.colorScheme.background,
                        )
                    )
                )
                .padding(vertical = SpacingM),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = onboardingItem.text,
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = SpacingXL),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
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
                            MaterialTheme.colorScheme.onBackground
                    )
            )
        }
    }
}