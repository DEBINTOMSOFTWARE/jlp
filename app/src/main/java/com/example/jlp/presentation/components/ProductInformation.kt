package com.example.jlp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            Text(
                text = "Product Information", style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Project code: $code", style = TextStyle(
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = title, style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Divider()
        } else {
            Text(
                text = "£${price?.now}", style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (specialOffer.isNotEmpty())
                Column {
                    Text(
                        text = specialOffer, style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Red
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            if (guarantee.isNotEmpty())
                Column {
                    Text(
                        text = guarantee, style = TextStyle(
                            fontSize = 16.sp,
                        )
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                }
            Text(
                text = "Product Information", style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = title, style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Project code: $code", style = TextStyle(
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Divider()
        }

    }
}