package com.example.jlp.data.api

import com.example.jlp.data.model.DishwasherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("jlp-jobs/jlp-android-test/-/raw/main/mockData/data.json?ref_type=heads")
    suspend fun getDishwashers() : DishwasherResponse
}