package com.example.jlp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.jlp.domain.Dishwasher

@Composable
fun ProductSpecification(dishwasher: Dishwasher?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White).semantics {
                contentDescription = "Product Specification"
            }
    ) {
        CustomRow(
            startText = "Product Specification",
            fontSize = 16
        )
        CustomRow(
            startText = "Adjustable racking Information",
            endContent = {
                BodyText(
                    text = dishwasher?.dynamicAttributes?.adjustableracking ?: "",
                    fontSize = 12
                )
            }
        )
        CustomRow(
            startText = "Child lock Door & control lock Delay Start",
            endContent = {
                BodyText(
                    text = dishwasher?.dynamicAttributes?.childlock ?: "",
                    fontSize = 12
                )
            }
        )
        CustomRow(
            startText = "Delay Wash",
            endContent = {
                BodyText(
                    text = dishwasher?.dynamicAttributes?.timerdelay ?: "",
                    fontSize = 12
                )
            }
        )
        CustomRow(
            startText = "Delicate Wash",
            endContent = {
                BodyText(
                    text = dishwasher?.dynamicAttributes?.delicatewash ?: "",
                    fontSize = 12
                )
            }
        )
        CustomRow(
            startText = "Dimensions",
            endContent = {
                BodyText(
                    text = dishwasher?.dynamicAttributes?.dimensions ?: "",
                    fontSize = 12
                )
            }
        )
        CustomRow(
            startText = "Drying performance",
            endContent = {
                BodyText(
                    text = dishwasher?.dynamicAttributes?.dryingperformance ?: "",
                    fontSize = 12
                )
            }
        )
        CustomRow(
            startText = "Drying system",
            endContent = {
                BodyText(
                    text = dishwasher?.dynamicAttributes?.dryingsystem ?: "",
                    fontSize = 12
                )
            }
        )
    }
}