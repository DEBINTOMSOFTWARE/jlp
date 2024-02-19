package com.example.jlp.data.repository

import com.example.jlp.data.api.ApiService
import com.example.jlp.data.model.DishwasherResponse
import com.example.jlp.data.model.Product
import com.example.jlp.domain.model.Dishwasher
import com.example.jlp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DishwasherRepositoryImpl(private val apiService: ApiService)  : DishwasherRepository {
    override fun getDishwashers(): Flow<Resource<DishwasherResponse>> = flow {
           emit(Resource.Success(DishwasherResponse(listOf(Product(
               brand = "Bosch",
               image = "",
               productId = "123456",
               title = "Bosch Dishwasher",
               type = "Front Loaded"
           )))))
    }
}