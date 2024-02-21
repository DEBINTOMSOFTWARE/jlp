package com.example.jlp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
            endContent = { Text(text = dishwasher?.dynamicAttributes?.adjustableracking ?: "", textAlign = TextAlign.End)}
        )
        CustomRow(
            startText = "Child lock Door & control lock Delay Start",
            endContent = { Text(text = dishwasher?.dynamicAttributes?.childlock ?: "", textAlign = TextAlign.End)}
        )
        CustomRow(
            startText = "Delay Wash",
            endContent = { Text(text = dishwasher?.dynamicAttributes?.timerdelay ?: "", textAlign = TextAlign.End)}
        )
        CustomRow(
            startText = "Delicate Wash",
            endContent = { Text(text = dishwasher?.dynamicAttributes?.delicatewash ?: "", textAlign = TextAlign.End)}
        )
        CustomRow(
            startText = "Dimensions",
            endContent = { Text(text = dishwasher?.dynamicAttributes?.dimensions ?: "", textAlign = TextAlign.End)}
        )
        CustomRow(
            startText = "Drying performance",
            endContent = { Text(text = dishwasher?.dynamicAttributes?.dryingperformance ?: "", textAlign = TextAlign.End)}
        )
        CustomRow(
            startText = "Drying system",
            endContent = { Text(text = dishwasher?.dynamicAttributes?.dryingsystem ?: "", textAlign = TextAlign.End)}
        )
    }
}