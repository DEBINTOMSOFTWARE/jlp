package com.example.jlp.data.repository

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.jlp.data.api.ApiService
import com.example.jlp.data.model.Product
import com.example.jlp.domain.Dishwasher
import com.example.jlp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DishwasherRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    DishwasherRepository {

        val products =MutableStateFlow<List<Dishwasher>>(emptyList())
        val productDetails = mutableStateOf<Dishwasher?>(null)

    override fun getDishwashers(): Flow<Resource<List<Dishwasher>>> = flow {
        emit(Resource.Loading)
        try {
            val response = apiService.getDishwashers()
            val dishwashers = response.products?.map { product ->
                product.toDishwasher()
            }
            if (dishwashers != null) {
                products.value = dishwashers
            }
            emit(Resource.Success(dishwashers))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach Server. Check your internet connection."))
        }

    }

    override fun getSingleDishwasher(productId: String?) {
         productId?.let {
             productDetails.value = products.value.firstOrNull {dishwasher ->
                 dishwasher.productId == productId
             }
         }
    }

    override fun getSingleDishwasherDetails(): MutableState<Dishwasher?> {
        return productDetails
    }

    private fun Product.toDishwasher(): Dishwasher {
        return Dishwasher(
            alternativeImageUrls = this.alternativeImageUrls,
            brand = this.brand,
            code = this.code,
            displaySpecialOffer = this.displaySpecialOffer,
            dynamicAttributes = this.dynamicAttributes,
            image = this.image,
            price = this.price,
            productId = this.productId,
            title = this.title,
            type = this.type,
        )
    }
}