package com.example.jlp.data.repository

import com.example.jlp.data.api.ApiService
import com.example.jlp.data.model.Product
import com.example.jlp.domain.Dishwasher
import com.example.jlp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DishwasherRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    DishwasherRepository {
    override fun getDishwashers(): Flow<Resource<List<Dishwasher>>> = flow {
        emit(Resource.Loading)
        try {
            val response = apiService.getDishwashers()
            val dishwashers = response.products?.map { product ->
                product.toDishwasher()
            }
            emit(Resource.Success(dishwashers))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach Server. Check your internet connection."))
        }

    }

    private fun Product.toDishwasher(): Dishwasher {
        return Dishwasher(
            brand = this.brand,
            image = this.image,
            productId = this.productId,
            title = this.title,
            type = this.type
        )
    }
}