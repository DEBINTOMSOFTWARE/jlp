package com.example.jlp.data.model

data class PromoMessages(
    val bundleHeadline: String,
    val customPromotionalMessage: String,
    val customSpecialOffer: CustomSpecialOffer,
    val offer: String,
    val priceMatched: String,
    val reducedToClear: Boolean
)