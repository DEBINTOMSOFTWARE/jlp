package com.example.jlp.presentation.screens

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jlp.domain.Dishwasher
import com.example.jlp.presentation.components.BodyExtraLargeText
import com.example.jlp.presentation.components.CustomRow
import com.example.jlp.presentation.components.ImageSlider
import com.example.jlp.presentation.components.ProductInformation
import com.example.jlp.presentation.components.ProductSpecification

@Composable
fun TabletDishwasherDetailsScreen(
    modifier: Modifier,
    dishwasher: Dishwasher?,
    navController: NavHostController,
    isTablet: Boolean
) {
    val title = dishwasher?.title ?: ""
    val price = dishwasher?.price
    val specialOffer = dishwasher?.displaySpecialOffer ?: ""
    val guarantee = dishwasher?.dynamicAttributes?.guarantee ?: ""

    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(modifier = modifier.semantics { contentDescription = "AppBar" },
                title = { BodyExtraLargeText(text = title) },
                backgroundColor = MaterialTheme.colorScheme.primary,
                navigationIcon = {
                    IconButton(
                        onClick = { navController.navigateUp() },
                        modifier = Modifier.semantics {
                            role = Role.Button
                            contentDescription = "Go back"
                        }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.surface
                        )
                    }
                })
        }
    ) { paddingValues ->

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues.calculateTopPadding())
        ) {
            val screenWidth = maxWidth
            val leftColumnWidth = screenWidth * 0.7f
            val rightColumnWidth = screenWidth * 0.3f

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .width(leftColumnWidth)
                        .verticalScroll(rememberScrollState())
                        .padding(end = 8.dp)
                ) {
                    ImageSlider(images = dishwasher?.alternativeImageUrls)
                    ProductInformation(dishwasher = dishwasher, isTablet = isTablet)
                    ReadMore()
                    ProductSpecification(dishwasher = dishwasher)

                }

                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )
                Column(
                    modifier = Modifier
                        .width(rightColumnWidth)
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = "£${price?.now}", style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.surface

                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    if (specialOffer.isNotEmpty())
                        Column {
                            Text(
                                text = specialOffer, style = TextStyle(
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    if (guarantee.isNotEmpty())
                        Column {
                            Text(
                                text = guarantee, style = TextStyle(
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.surface
                                )
                            )
                            Spacer(modifier = Modifier.height(30.dp))
                        }
                }
            }
        }
    }
}

@Composable
fun ReadMore() {
    CustomRow(
        startText = "Read More",
        endContent = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.surface
            )
        },
        fontSize = 20
    )
}