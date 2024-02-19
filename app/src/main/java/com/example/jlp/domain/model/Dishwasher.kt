package com.example.jlp.domain.model

import com.example.jlp.data.model.ColorSwatche
import com.example.jlp.data.model.DynamicAttributes
import com.example.jlp.data.model.Messaging
import com.example.jlp.data.model.Price
import com.example.jlp.data.model.PromoMessages
import com.example.jlp.data.model.QuickAddToBasket

data class Dishwasher(
    val ageRestriction: Int,
    val alternativeImageUrls: List<String>,
    val availabilityMessage: String,
    val averageRating: Double,
    val brand: String,
    val categoryQuickViewEnabled: Boolean,
    val code: String,
    val colorSwatchSelected: Int,
    val colorSwatches: List<ColorSwatche>,
    val colorWheelMessage: String,
    val compare: Boolean,
    val defaultSkuId: String,
    val directorate: String,
    val displaySpecialOffer: String,
    val dynamicAttributes: DynamicAttributes,
    val emailMeWhenAvailable: Boolean,
    val fabric: String,
    val fabricByLength: Boolean,
    val features: List<Any>,
    val futureRelease: Boolean,
    val htmlTitle: String,
    val image: String,
    val isBundle: Boolean,
    val isInStoreOnly: Boolean,
    val isMadeToMeasure: Boolean,
    val isProductSet: Boolean,
    val messaging: List<Messaging>,
    val multiSku: Boolean,
    val nonPromoMessage: String,
    val outOfStock: Boolean,
    val permanentOos: Boolean,
    val price: Price,
    val productId: String,
    val promoMessages: PromoMessages,
    val promotionalFeatures: List<Any>,
    val quickAddToBasket: QuickAddToBasket,
    val reviews: Int,
    val swatchAvailable: Boolean,
    val swatchCategoryType: String,
    val title: String,
    val type: String
)
