package com.example.jlp.data.repository

import com.example.jlp.data.api.ApiService
import com.example.jlp.data.model.ColorSwatche
import com.example.jlp.data.model.DishwasherResponse
import com.example.jlp.data.model.DynamicAttributes
import com.example.jlp.data.model.Messaging
import com.example.jlp.data.model.Price
import com.example.jlp.data.model.Product
import com.example.jlp.data.model.PromoMessages
import com.example.jlp.data.model.QuickAddToBasket
import com.example.jlp.utils.Resource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DishwasherRepositoryTest {

    @MockK
    private lateinit var apiService: ApiService
    private lateinit var repository: DishwasherRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
       repository = DishwasherRepositoryImpl(apiService)
    }

    @Test
    fun fetchDishwashers_returnSuccess() = runBlocking {
        val mockApi = mockk<ApiService>()
        val expectedResponse = DishwasherResponse(listOf(Product(
            brand = "Bosch",
            image = "",
            productId = "123456",
            title = "Bosch Dishwasher",
            type = "Front Loaded"
            )))
        coEvery { mockApi.getDishwashers() } returns expectedResponse
        val repository = DishwasherRepositoryImpl(mockApi)

        val result = repository.getDishwashers().first()
        assert(result is Resource.Success)
        assertEquals(expectedResponse.products?.size, (result as  Resource.Success).data.products?.size)
    }

}