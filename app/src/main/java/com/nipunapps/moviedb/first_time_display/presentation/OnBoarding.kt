package com.nipunapps.moviedb.first_time_display.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.nipunapps.moviedb.core.components.FullHeightButtonFilled
import com.nipunapps.moviedb.first_time_display.presentation.components.Indicator
import com.nipunapps.moviedb.first_time_display.presentation.components.SingleOnboarding
import com.nipunapps.moviedb.first_time_display.presentation.components.onboardingItems
import com.nipunapps.moviedb.ui.theme.ColorBackground
import com.nipunapps.moviedb.ui.theme.SpacingXL
import com.nipunapps.moviedb.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    navController: NavController
) {
    val pagerState = rememberPagerState(
        initialPage = 0
    )
    val pageHeight = 0.75f
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent, ColorBackground.copy(alpha = 0.5f)
                    )
                )
            ),
    ) {
        HorizontalPager(
            pageCount = onboardingItems.size, state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(pageHeight)
        ) { page ->
            SingleOnboarding(onboardingItem = onboardingItems[page])
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(1 - pageHeight)
                .padding(SpacingXL)
        ) {
            Indicator(
                count = onboardingItems.size,
                active = pagerState.currentPage,
                modifier = Modifier
                    .align(Alignment.TopCenter)
            )
            FullHeightButtonFilled(
                text = if (pagerState.currentPage == onboardingItems.size - 1) R.string.continuee
                else R.string.next,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            ) {
                if(pagerState.currentPage != onboardingItems.size-1){
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage+1)
                    }
                }
            }
        }
    }
}