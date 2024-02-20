package com.example.jlp.domain.usecases

import com.example.jlp.data.repository.DishwasherRepository
import com.example.jlp.domain.Dishwasher
import com.example.jlp.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDishwashersUseCaseImpl @Inject constructor(private val dishwasherRepository: DishwasherRepository) :
    GetDishwashersUseCase {
    override fun getDishwashers(): Flow<Resource<List<Dishwasher>>> {
        return dishwasherRepository.getDishwashers()
    }
}