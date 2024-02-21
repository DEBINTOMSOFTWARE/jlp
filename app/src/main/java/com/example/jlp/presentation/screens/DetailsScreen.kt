package com.example.jlp.presentation.screens

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jlp.Destination
import com.example.jlp.domain.Dishwasher
import com.example.jlp.presentation.components.CustomRow
import com.example.jlp.presentation.components.ProductSpecification
import com.example.jlp.presentation.viewmodel.DishwasherViewModel
import com.example.jlp.utils.ProductImage
import com.example.jlp.utils.getFullImageUrl

@Composable
fun DetailsScreen(
    productId: String?,
    dishwasherViewModel: DishwasherViewModel,
    navController: NavHostController
) {

    val dishwasher = dishwasherViewModel.dishwasherDetails.value

    if (dishwasher == null) {
        navController.navigate(Destination.ProductsScreen.route) {
            popUpTo(Destination.ProductsScreen.route)
            launchSingleTop = true
        }
    }

    val isTablet = with(LocalConfiguration.current) {
        screenWidthDp >= 600
    }

    DishwasherDetails(dishwasher = dishwasher, isTablet = isTablet, navController)
}

@Composable
fun DishwasherDetails(
    dishwasher: Dishwasher?,
    isTablet: Boolean,
    navController: NavHostController
) {
    if(isTablet) {
             Text(text = "This is tablet screen")
    } else {
        PhoneDishwasherDetailsScreen(dishwasher = dishwasher, navController = navController)
    }

}







