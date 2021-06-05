package com.man.data.remote.response

import com.squareup.moshi.Json

data class CoinInfo(

    @Json(name = "Name")
    val name: String,

    @Json(name = "FullName")
    val fullName: String,

    @Json(name = "Id")
    val id: String,

    )