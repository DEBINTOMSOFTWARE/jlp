package com.example.jlp.domain

import com.example.jlp.data.model.ColorSwatche
import com.example.jlp.data.model.DynamicAttributes
import com.example.jlp.data.model.Messaging
import com.example.jlp.data.model.Price
import com.example.jlp.data.model.PromoMessages
import com.example.jlp.data.model.QuickAddToBasket

data class Dishwasher(
    val alternativeImageUrls: List<String>?,
    val brand: String?,
    val code: String?,
    val displaySpecialOffer: String?,
    val dynamicAttributes: DynamicAttributes?,
    val image: String?,
    val productId: String?,
    val title: String?,
    val type: String?,
    val price: Price?
)
