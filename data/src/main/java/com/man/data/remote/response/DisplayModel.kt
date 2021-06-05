package com.man.data.remote.response

import com.squareup.moshi.Json

data class DisplayModel(

	@Json(name = "USD")
	val uSD: USD? = null
)