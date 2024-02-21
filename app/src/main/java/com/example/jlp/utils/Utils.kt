package com.example.jlp.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

sealed class Resource<out T> {
    data class Success<out T>(val data: T?) : Resource<T>()
    data class Error(val message: String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}

fun getFullImageUrl(relativeUrl: String): String {
    if (!relativeUrl.startsWith("http://") && !relativeUrl.startsWith("https://")) {
        return "https:$relativeUrl"
    }
    return relativeUrl
}

@Composable
fun ProductImage(
    url: String?,
    modifier: Modifier,
    contentScale: ContentScale = ContentScale.FillWidth
) {
    AsyncImage(
        model = url,
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale)

}

@Composable
fun VerticalDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f),
    thickness: Dp = 1.dp
) {
    Box(
        modifier
            .fillMaxHeight() // Make sure it fills the height available
            .width(thickness) // Set the thickness of the divider
            .background(color = color)
    )
}