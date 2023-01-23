package com.nipunapps.moviedb.core.components

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.nipunapps.moviedb.core.noRippleClickable
import com.nipunapps.moviedb.ui.theme.BorderL
import com.nipunapps.moviedb.ui.theme.SpacingL
import com.nipunapps.moviedb.ui.theme.SpacingM

@Composable
fun CustomFilledButton(
    modifier: Modifier = Modifier,
    @StringRes
    text: Int,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .noRippleClickable {
                    onClick()
                }
                .padding(horizontal = SpacingL, vertical = SpacingM),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun CustomOutlinedButton(
    modifier: Modifier = Modifier,
    @StringRes
    text: Int,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background,
        border = BorderStroke(
            width = BorderL,
            MaterialTheme.colorScheme.primary
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .noRippleClickable {
                    onClick()
                }
                .padding(horizontal = SpacingL, vertical = SpacingM),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}