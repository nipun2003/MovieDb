package com.nipunapps.moviedb.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nipunapps.moviedb.R


val InterFamily = FontFamily(
    listOf(
        Font(R.font.inter_extra_bold, FontWeight.ExtraBold),
        Font(R.font.inter_bold, FontWeight.Bold),
        Font(R.font.inter_semibold, FontWeight.SemiBold),
        Font(R.font.inter_medium, FontWeight.Medium),
        Font(R.font.inter_regular, FontWeight.Normal),
        Font(R.font.inter_light, FontWeight.Thin),
    )
)

// Font sizes

val HeadlineLarge = 32.sp
val HeadlineMedium = 28.sp
val HeadlineSmall = 24.sp

val DisplayLarge = 24.sp
val DisplayMedium = 20.sp
val DisplaySmall = 18.sp

val TitleLarge = 22.sp
val TitleMedium = 18.sp
val TitleSmall = 16.sp

val BodyLarge = 16.sp
val BodyMedium = 14.sp
val BodySmall = 12.sp

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontSize = HeadlineLarge,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = InterFamily
    ),

    headlineMedium = TextStyle(
        fontSize = HeadlineMedium,
        fontWeight = FontWeight.Bold,
        fontFamily = InterFamily
    ),

    headlineSmall = TextStyle(
        fontSize = HeadlineSmall,
        fontWeight = FontWeight.SemiBold,
        fontFamily = InterFamily
    ),

    displayLarge = TextStyle(
        fontSize = DisplayLarge,
        fontWeight = FontWeight.Bold,
        fontFamily = InterFamily
    ),
    displayMedium = TextStyle(
        fontSize = DisplayMedium,
        fontWeight = FontWeight.SemiBold,
        fontFamily = InterFamily
    ),
    displaySmall = TextStyle(
        fontSize = DisplaySmall,
        fontWeight = FontWeight.Medium,
        fontFamily = InterFamily
    ),
    titleLarge = TextStyle(
        fontSize = TitleLarge,
        fontWeight = FontWeight.SemiBold,
        fontFamily = InterFamily
    ),
    titleMedium = TextStyle(
        fontSize = TitleMedium,
        fontWeight = FontWeight.SemiBold,
        fontFamily = InterFamily
    ),
    titleSmall = TextStyle(
        fontSize = TitleSmall,
        fontWeight = FontWeight.Medium,
        fontFamily = InterFamily
    ),
    bodyLarge = TextStyle(
        fontSize = BodyLarge,
        fontWeight = FontWeight.Medium,
        fontFamily = InterFamily
    ),
    bodyMedium = TextStyle(
        fontSize = BodyMedium,
        fontWeight = FontWeight.Normal,
        fontFamily = InterFamily
    ),
    bodySmall = TextStyle(
        fontSize = BodySmall,
        fontWeight = FontWeight.Thin,
        fontFamily = InterFamily
    )

)
