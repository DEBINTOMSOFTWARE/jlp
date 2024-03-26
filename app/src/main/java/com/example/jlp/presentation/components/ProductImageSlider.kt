package com.example.jlp.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import com.example.jlp.utils.ProductImage
import com.example.jlp.utils.getFullImageUrl

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(images: List<String>?) {

    val selectedPages = remember{ mutableStateListOf<Boolean>().apply {
        if (images != null)
           addAll(List( images.size) {false })
    } }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
    ) {
        val pagerState = rememberPagerState(pageCount = {
            images?.size ?: 0
        })
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 32.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .semantics {
                    contentDescription = "Horizontal Pager"
                }
        ) { page ->
           images?.let {
               ProductImage(
                   url = getFullImageUrl(it[page]),
                   contentScale = ContentScale.Crop,
                   contentDescription = "Image ${page + 1} of  ${images.size}",
                   modifier = Modifier
                       .fillMaxWidth()
                       .clickable {
                           selectedPages[page] = !selectedPages[page]
                       }
                       .semantics {
                           contentDescription = "Image ${page + 1} of ${it.size}"
                           stateDescription =
                               if (selectedPages[page]) "Selected" else "Not Selected"
                       }
               )
           }
        }
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalPagerIndicators(pagerState = pagerState)
    }
}
