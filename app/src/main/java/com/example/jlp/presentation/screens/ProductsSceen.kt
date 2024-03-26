package com.example.jlp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jlp.Destination
import com.example.jlp.domain.Dishwasher
import com.example.jlp.framework.connectivity.ConnectivityObservable
import com.example.jlp.presentation.components.BodyLargeText
import com.example.jlp.presentation.components.BodySmallText
import com.example.jlp.presentation.components.BodyText
import com.example.jlp.presentation.viewmodel.DishwasherViewModel
import com.example.jlp.utils.ProductImage
import com.example.jlp.utils.Resource
import com.example.jlp.utils.getFullImageUrl

@Composable
fun ProductsScreen(
    navController: NavHostController,
    dishwasherViewModel: DishwasherViewModel
) {
    val result by dishwasherViewModel.dishwashers.collectAsState()
    val networkAvailable =
        dishwasherViewModel.networkAvailable.observe()
            .collectAsState(ConnectivityObservable.Status.Available)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (networkAvailable.value == ConnectivityObservable.Status.Unavailable) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red),
                horizontalArrangement = Arrangement.Center
            ) {
                BodyLargeText(
                    text = "Network unavailable",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        when (result) {
            is Resource.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.semantics { contentDescription = "Loading Progress" }
                )
            }

            is Resource.Success -> {
                ShowDishwashersGrid(
                    result = result as Resource.Success<List<Dishwasher>>,
                    navController = navController
                )
            }

            is Resource.Error -> {
                BodyText(
                    text = "Error: ${(result as Resource.Error).message}",
                )
            }

            else -> {}
        }
    }
}

@Composable
fun ShowDishwashersGrid(
    result: Resource.Success<List<Dishwasher>>,
    navController: NavHostController
) {
    result.data?.let { dishwashers ->
        LazyVerticalGrid(
            modifier = Modifier.semantics { contentDescription = "Product List" },
            columns = GridCells.Adaptive(minSize = 128.dp),
            contentPadding = PaddingValues(8.dp),
        ) {
            items(dishwashers) { dishwasher ->
                DishwasherItem(dishwasher, navController)
            }
        }
    }
}

@Composable
fun DishwasherItem(product: Dishwasher?, navController: NavHostController) {
    val imageUrl = product?.image
    val title = product?.title
    val price = product?.price
    val productId = product?.productId
    val brand = product?.brand

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.LightGray)
            .background(Color.White)
            .padding(16.dp)
            .wrapContentHeight()
            .clickable {
                if (productId != null)
                    navController.navigate(Destination.DetailsScreen.createRoute(productId))
            }
            .semantics {
                role = Role.Button
                contentDescription = "Product $brand,"
            }
    ) {
        ProductImage(
            url = getFullImageUrl(imageUrl ?: ""),
            modifier = Modifier
                .padding(4.dp)
                .height(120.dp)
                .fillMaxWidth()
                .aspectRatio(1f),
            contentDescription = "$title",
            contentScale = ContentScale.Crop
        )
        BodySmallText(
            text = title ?: "",
            fontSize = 12,
            modifier = Modifier.padding(top = 8.dp)
        )
        BodySmallText(
            text = "£${price?.now ?: ""}",
            fontSize = 12,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}