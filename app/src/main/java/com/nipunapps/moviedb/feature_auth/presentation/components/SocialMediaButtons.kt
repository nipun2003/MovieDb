package com.nipunapps.moviedb.feature_auth.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.nipunapps.moviedb.R
import com.nipunapps.moviedb.ui.theme.*

@Composable
fun SocialMediaButton(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .background(color = MaterialTheme.colorScheme.onBackground)
                .padding(SpacingXS),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = "facebook",
                modifier = Modifier
                    .size(SpacingXXL)
                    .clip(CircleShape),
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.width(SpacingXS))
            Text(
                text = stringResource(id = R.string.facebook),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.background
            )
        }
        Spacer(modifier = Modifier.width(SpacingM))
        Row(
            modifier = Modifier
                .weight(1f)
                .background(color = MaterialTheme.colorScheme.onBackground)
                .padding(SpacingXS),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "facebook",
                modifier = Modifier.size(SpacingXXL),
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.width(SpacingXS))
            Text(
                text = stringResource(id = R.string.google),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.background
            )
        }
    }
}

@Composable
fun AlternateAuthOption(
    modifier: Modifier = Modifier,
    disabledText: Int,
    clickableText: Int
) {
    val disabledColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
    val clickableColor = MaterialTheme.colorScheme.primary
    val text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontFamily = InterFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = BodyMedium
            )
        ) {
            withStyle(style = SpanStyle(color = disabledColor)) {
                append(stringResource(id = disabledText))
                append(" ")
            }
            withStyle(style = SpanStyle(color = clickableColor)) {
                append(stringResource(id = clickableText))
            }
        }
    }
    Text(
        text = text,
        modifier = modifier
    )
}