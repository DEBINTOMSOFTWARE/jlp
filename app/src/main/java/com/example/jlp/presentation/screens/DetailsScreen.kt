package com.example.jlp.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.navigation.NavHostController
import com.example.jlp.Destination
import com.example.jlp.domain.Dishwasher
import com.example.jlp.presentation.viewmodel.DishwasherViewModel

@Composable
fun DetailsScreen(
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

    DishwasherDetails(modifier = Modifier.semantics { contentDescription = "Details Screen" },
        dishwasher = dishwasher, isTablet = isTablet, navController)
}

@Composable
fun DishwasherDetails(
    modifier: Modifier,
    dishwasher: Dishwasher?,
    isTablet: Boolean,
    navController: NavHostController
) {
    if (isTablet) {
        TabletDishwasherDetailsScreen(
            modifier = modifier,
            dishwasher = dishwasher,
            navController = navController,
            isTablet = true
        )
    } else {
        PhoneDishwasherDetailsScreen(
            modifier = modifier,
            dishwasher = dishwasher,
            navController = navController,
            isTablet = false
        )
    }
}








