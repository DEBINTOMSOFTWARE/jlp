package com.example.jlp.data.model

data class Product(
    val alternativeImageUrls: List<String>?,
    val brand: String?,
    val code: String?,
    val displaySpecialOffer: String?,
    val dynamicAttributes: DynamicAttributes?,
    val image: String?,
    val price: Price?,
    val productId: String?,
    val title: String?,
    val type: String?
)


