package com.example.jlp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jlp.domain.Dishwasher
import com.example.jlp.presentation.components.ImageSlider
import com.example.jlp.presentation.components.ProductInformation
import com.example.jlp.presentation.components.ProductSpecification

@Composable
fun PhoneDishwasherDetailsScreen(dishwasher: Dishwasher?, navController: NavHostController) {
    val scaffoldState = rememberScaffoldState();
    val scrollState = rememberScrollState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(title = { Text(text = dishwasher?.brand ?: "") },
                backgroundColor = Color.Gray,
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
                .padding(
                    vertical = paddingValues.calculateTopPadding(),
                    horizontal = paddingValues.calculateBottomPadding()
                )
                .background(Color.Gray)
                .padding(all = 16.dp)

        ) {
            ImageSlider(images = dishwasher?.alternativeImageUrls)
            Spacer(
                modifier = Modifier
                    .height(8.dp)
            )
            ProductInformation(dishwasher = dishwasher)
            ProductSpecification(dishwasher = dishwasher)
        }
    }
}