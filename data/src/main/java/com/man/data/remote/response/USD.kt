package com.man.data.remote.response

import com.squareup.moshi.Json

data class USD(

    @Json(name = "CHANGEPCTHOUR")
    val changepcthour: String,

    @Json(name = "CHANGEHOUR")
    val changehour: String,

    @Json(name = "PRICE")
    val price: String,
)