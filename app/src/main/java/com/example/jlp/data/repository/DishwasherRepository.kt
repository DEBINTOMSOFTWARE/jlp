package com.example.jlp.data.repository

import androidx.compose.runtime.MutableState
import com.example.jlp.domain.Dishwasher
import com.example.jlp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DishwasherRepository {
    fun getDishwashers(): Flow<Resource<List<Dishwasher>>>

    fun getSingleDishwasher(productId: String?)

    fun getSingleDishwasherDetails(): MutableState<Dishwasher?>

}