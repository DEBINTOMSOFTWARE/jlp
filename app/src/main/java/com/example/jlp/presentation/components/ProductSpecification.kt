package com.example.jlp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.jlp.domain.Dishwasher

@Composable
fun ProductSpecification(dishwasher: Dishwasher?) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        ) {
        CustomRow(startText = "Product Specification", fontSize = 16.sp)
        CustomRow(
            startText = "Adjustable racking Information",
            endText = dishwasher?.dynamicAttributes?.adjustableracking
        )
        CustomRow(
            startText = "Child lock Door & control lock Delay Start",
            endText = dishwasher?.dynamicAttributes?.childlock
        )
        CustomRow(
            startText = "Delay Wash",
            endText = dishwasher?.dynamicAttributes?.timerdelay
        )
        CustomRow(
            startText = "Delicate Wash",
            endText = dishwasher?.dynamicAttributes?.delicatewash
        )
        CustomRow(
            startText = "Dimensions",
            endText = dishwasher?.dynamicAttributes?.dimensions
        )
        CustomRow(
            startText = "Drying performance",
            endText = dishwasher?.dynamicAttributes?.dryingperformance
        )
        CustomRow(
            startText = "Drying system",
            endText = dishwasher?.dynamicAttributes?.dryingsystem
        )
    }
}