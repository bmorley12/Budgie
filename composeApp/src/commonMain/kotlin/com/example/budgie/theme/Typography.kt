package com.example.budgie.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import budgie.composeapp.generated.resources.BonaNovaSC_Bold
import budgie.composeapp.generated.resources.BonaNovaSC_Regular
import budgie.composeapp.generated.resources.DynaPuff_Bold
import budgie.composeapp.generated.resources.DynaPuff_Medium
import budgie.composeapp.generated.resources.DynaPuff_Regular
import budgie.composeapp.generated.resources.DynaPuff_SemiBold
import budgie.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font


@Composable
fun appTypography(): Typography {
    // Define a font family for BonaNova SC
    val bonaNovaSC = FontFamily(
        Font(Res.font.BonaNovaSC_Bold, FontWeight.Bold),
        Font(Res.font.BonaNovaSC_Regular, FontWeight.Normal),
    )

    // Define a font family for DynaPuff
    val dynaPuff = FontFamily(
        Font(Res.font.DynaPuff_Bold, FontWeight.Bold),
        Font(Res.font.DynaPuff_Regular, FontWeight.Normal),
        Font(Res.font.DynaPuff_Medium, FontWeight.Medium),
        Font(Res.font.DynaPuff_SemiBold, FontWeight.SemiBold),
    )

    return Typography(
        headlineLarge = TextStyle(
            fontFamily = dynaPuff,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = bonaNovaSC,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        displaySmall = TextStyle(
            fontFamily = dynaPuff,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
    )
}