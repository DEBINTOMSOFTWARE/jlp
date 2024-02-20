package com.example.jlp.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.jlp.domain.Dishwasher
import com.example.jlp.domain.usecases.GetDishwashersUseCase
import com.example.jlp.utils.Resource
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class DishwasherViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    private lateinit var getDishwashersUseCase: GetDishwashersUseCase
    private lateinit var viewModel: DishwasherViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher) // Set the main dispatcher to the test dispatcher
        getDishwashersUseCase = mockk()

    }

    @Test
    fun initial_state_is_Resource_Loading() = runTest {
        coEvery { getDishwashersUseCase.getDishwashers() } returns flowOf(Resource.Loading)

        viewModel = DishwasherViewModel(getDishwashersUseCase)
        viewModel.getDishwashers()

        val initialState = viewModel.dishwashers.value
        assertTrue(initialState is Resource.Loading, "Expected initial state to be Resource.Loading")
    }

    @Test
    fun getDishwashers_success_updates_dishwashers_StateFlow() = runTest {
        val mockDishwashers = listOf(
            Dishwasher(
                brand = "Bosch",
                image = "imageURLA",
                productId = "123456",
                title = "Bosch Dishwasher",
                type = "typeA"
            )
        )
        coEvery { getDishwashersUseCase.getDishwashers() } returns flowOf(Resource.Success(mockDishwashers))

        viewModel = DishwasherViewModel(getDishwashersUseCase)
        viewModel.getDishwashers()

        val state = viewModel.dishwashers.value
        assertEquals(Resource.Success(mockDishwashers), state)
        assertTrue(state is Resource.Success, "Expected Resource.Success but found $state")
        assertEquals(mockDishwashers, (state).data, "Data does not match expected value")
    }

    @Test
    fun getDishwashers_error_updates_dishwashers_StateFlow() = runTest {
        val errorMessage = "Error fetching data"
        coEvery { getDishwashersUseCase.getDishwashers() } returns flowOf(Resource.Error(errorMessage))

        viewModel = DishwasherViewModel(getDishwashersUseCase)
        viewModel.getDishwashers()

        val state = viewModel.dishwashers.value
        assertEquals(Resource.Error(errorMessage), state)
        assertTrue(state is Resource.Error, "Expected Resource.Error but found $state")
        assertEquals(errorMessage, (state).message, "Error message does not match expected value")
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
    }
}