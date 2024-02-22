package com.example.jlp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jlp.domain.Dishwasher

@Composable
fun ProductInformation(dishwasher: Dishwasher?, isTablet: Boolean) {
    val price = dishwasher?.price
    val specialOffer = dishwasher?.displaySpecialOffer ?: ""
    val guarantee = dishwasher?.dynamicAttributes?.guarantee ?: ""
    val title = dishwasher?.title ?: ""
    val code = dishwasher?.code

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 16.dp, bottom = 16.dp)
    ) {
        if (isTablet) {
            HeaderLargeText(
                text = "Product Information",
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(8.dp))
            BodyExtraLargeText(text = "Project code: $code")
            Spacer(modifier = Modifier.height(4.dp))
            BodyLargeText(text = title)
            Spacer(modifier = Modifier.height(20.dp))
            Divider()
        } else {
            HeaderLargeText(text = "£${price?.now}")
            Spacer(modifier = Modifier.height(16.dp))
            if (specialOffer.isNotEmpty())
                Column {
                    BodyLargeText(
                        text = specialOffer,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            if (guarantee.isNotEmpty())
                Column {
                    BodyLargeText(text = guarantee)
                    Spacer(modifier = Modifier.height(30.dp))
                }
            HeaderLargeText(
                text = "Product Information",
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(16.dp))
            BodyLargeText(text = title)
            Spacer(modifier = Modifier.height(16.dp))
            BodyExtraLargeText(text = "Project code: $code")
            Spacer(modifier = Modifier.height(16.dp))
            Divider()
        }
    }
}