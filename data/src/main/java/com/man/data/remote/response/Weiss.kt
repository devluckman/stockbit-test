package com.man.data.remote.response

import com.squareup.moshi.Json

data class Weiss(

    @Json(name = "Rating")
    val rating: String,

    @Json(name = "TechnologyAdoptionRating")
    val technologyAdoptionRating: String,

    @Json(name = "MarketPerformanceRating")
    val marketPerformanceRating: String
)