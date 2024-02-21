package com.example.jlp.domain.usecases

import com.example.jlp.data.model.Price
import com.example.jlp.data.repository.DishwasherRepository
import com.example.jlp.domain.Dishwasher
import com.example.jlp.utils.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class GetDishwasherUseCaseTest {

    private val dishwasherRepository: DishwasherRepository = mockk()

    private lateinit var getDishwashersUseCase: GetDishwashersUseCase

    @Before
    fun setUp() {
        getDishwashersUseCase = GetDishwashersUseCaseImpl(dishwasherRepository)
    }

    @Test
    fun getDishwashers_fetches_data_from_repository() = runTest {

        val mockDishwashersFlow: Flow<Resource<List<Dishwasher>>> = flow {
            emit(Resource.Success(listOf(
                Dishwasher(
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
            ))))
        }
        coEvery {
            dishwasherRepository.getDishwashers()
        } returns mockDishwashersFlow

        val resultFlow = getDishwashersUseCase.getDishwashers()

        var resultList: List<Dishwasher>? = null
        resultFlow.collect { result ->
            if (result is Resource.Success) {
                resultList = result.data
            }
        }
        assertEquals(1, resultList?.size)
        assertEquals("123456", resultList?.first()?.productId)
        assertEquals("Bosch Dishwasher", resultList?.first()?.title)
        assertEquals("Bosch", resultList?.first()?.brand)
        assertEquals("imageURLA", resultList?.first()?.image)
        assertEquals("typeA", resultList?.first()?.type)
    }
}