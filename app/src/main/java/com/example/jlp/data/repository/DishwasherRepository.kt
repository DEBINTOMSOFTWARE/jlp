package com.example.jlp.data.repository

import com.example.jlp.domain.Dishwasher
import com.example.jlp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DishwasherRepository {
    fun getDishwashers(): Flow<Resource<List<Dishwasher>>>
}