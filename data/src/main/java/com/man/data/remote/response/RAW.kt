package com.man.data.remote.response

import com.squareup.moshi.Json

data class RAW(

	@Json(name = "USD")
	val usd: USD? = null
)