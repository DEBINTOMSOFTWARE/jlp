package com.example.jlp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jlp.presentation.screens.DetailsScreen
import com.example.jlp.presentation.screens.ProductsScreen
import com.example.jlp.presentation.viewmodel.DishwasherViewModel
import com.example.jlp.ui.theme.JlpTheme
import dagger.hilt.android.AndroidEntryPoint

sealed class Destination(val route: String) {
    data object ProductsScreen : Destination("productsScreen")
    data object DetailsScreen : Destination("detailScreen/{productId}") {
        fun createRoute(productId: String?) = "detailScreen/$productId"
    }
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val dishwasherViewModel by viewModels<DishwasherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JlpTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    val navController = rememberNavController()
                    AppNavigation(
                        navController,
                        dishwasherViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    dishwasherViewModel: DishwasherViewModel
) {

    NavHost(navController = navController, startDestination = Destination.ProductsScreen.route) {
        composable(Destination.ProductsScreen.route) {
            ProductsScreen(navController = navController, dishwasherViewModel)
        }
        composable(Destination.DetailsScreen.route) { navBackStackEntry ->
            val productId = navBackStackEntry.arguments?.getString("productId")
            if (productId == null) {
                Toast.makeText(
                    LocalContext.current,
                    "Product id required",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                dishwasherViewModel.retrieveSingleProduct(productId)
                DetailsScreen(
                    dishwasherViewModel = dishwasherViewModel,
                    navController = navController
                )
            }
        }
    }

}