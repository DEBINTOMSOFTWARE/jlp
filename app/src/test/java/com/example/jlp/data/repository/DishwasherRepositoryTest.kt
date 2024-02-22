package com.example.jlp.data.repository
import androidx.compose.runtime.MutableState
import com.example.jlp.data.api.ApiService
import com.example.jlp.data.model.DishwasherResponse
import com.example.jlp.data.model.Price
import com.example.jlp.data.model.Product
import com.example.jlp.domain.Dishwasher
import com.example.jlp.utils.Resource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.io.IOException
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DishwasherRepositoryTest {

    @MockK
    private lateinit var apiService: ApiService
    @MockK
    private lateinit var dishwashers: MutableState<List<Dishwasher>>
    private lateinit var repository: DishwasherRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
       repository = DishwasherRepositoryImpl(apiService)
    }

    @Test
    fun getDishwashers_emits_Loading_and_then_Success() = runBlocking {
        val mockApi = mockk<ApiService>()
        val mockResponse = DishwasherResponse(products = listOf(Product(
            alternativeImageUrls = null,
            brand = "Bosch",
            code = null,
            displaySpecialOffer = null,
            dynamicAttributes = null,
            image = "imageURLA",
            productId = "123456",
            title = "Bosch Dishwasher",
            type = "typeA",
            price = Price(currency = "GBP", now = "999", then1 = null, then2 = null, uom = null, was = null)
        )))
        coEvery { mockApi.getDishwashers() } returns mockResponse
        val repository = DishwasherRepositoryImpl(mockApi)

        val result = repository.getDishwashers().toList()
        assertTrue { result[0] is Resource.Loading}
        assertTrue { result[1] is Resource.Success }

        val dishwashers = (result[1] as Resource.Success).data ?: emptyList()
        assertEquals(1, dishwashers.size)
        assertEquals("123456", dishwashers[0].productId)
        assertEquals("Bosch Dishwasher", dishwashers[0].title)
        assertEquals("Bosch", dishwashers[0].brand)
        assertEquals("imageURLA", dishwashers[0].image)
        assertEquals("typeA", dishwashers[0].type)
    }

    @Test
    fun getDishwashers_emits_Loading_and_then_Error_on_IOException() = runTest {
        // Mock API to throw IOException
        coEvery { apiService.getDishwashers() } throws IOException()

        val results = repository.getDishwashers().toList()

        // Check Loading is emitted first
        assertTrue { results[0] is Resource.Loading }
        // Check Error is emitted second
        assertTrue { results[1] is Resource.Error }
        assertEquals((results[1] as Resource.Error).message, "Couldn't reach Server. Check your internet connection.")
    }

}