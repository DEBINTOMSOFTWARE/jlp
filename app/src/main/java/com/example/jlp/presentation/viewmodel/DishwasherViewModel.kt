package com.example.jlp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jlp.domain.Dishwasher
import com.example.jlp.domain.usecases.GetDishwashersUseCase
import com.example.jlp.framework.connectivity.ConnectivityMonitor
import com.example.jlp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishwasherViewModel @Inject constructor(
    private val getDishwashersUseCase: GetDishwashersUseCase,
    connectivityMonitor: ConnectivityMonitor
) : ViewModel() {

    private val _dishwashers = MutableStateFlow<Resource<List<Dishwasher>>>(Resource.Initial())
    val dishwashers = _dishwashers.asStateFlow()
    val dishwasherDetails = getDishwashersUseCase.getSingleDishwasherDetails()
    val networkAvailable = connectivityMonitor

    init {
        getDishwashers()
    }

    fun getDishwashers() {
        _dishwashers.value = Resource.Loading
        viewModelScope.launch {
            getDishwashersUseCase.getDishwashers().collect { resource ->
                _dishwashers.value = resource
            }
        }
    }

    fun retrieveSingleProduct(productId: String?) {
        getDishwashersUseCase.getSingleDishwasher(productId)
    }
}