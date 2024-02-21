package com.example.jlp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun HeaderText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    fontSize: Int = 18
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
fun BodyText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Gray,
    fontSize: Int = 14
) {
    Text(
        text = text,
        modifier = modifier.padding(start = 4.dp, end = 4.dp, top = 2.dp, bottom = 2.dp),
        color = color,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
        overflow = TextOverflow.Ellipsis,
        maxLines = 3
    )
}