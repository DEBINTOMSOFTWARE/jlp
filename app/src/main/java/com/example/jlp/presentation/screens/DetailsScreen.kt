package com.example.jlp.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
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

    DishwasherDetails(dishwasher = dishwasher, isTablet = isTablet, navController)
}

@Composable
fun DishwasherDetails(
    dishwasher: Dishwasher?,
    isTablet: Boolean,
    navController: NavHostController
) {
    if (isTablet) {
        TabletDishwasherDetailsScreen(
            dishwasher = dishwasher,
            navController = navController,
            isTablet = true
        )
    } else {
        PhoneDishwasherDetailsScreen(
            dishwasher = dishwasher,
            navController = navController,
            isTablet = false
        )
    }
}








