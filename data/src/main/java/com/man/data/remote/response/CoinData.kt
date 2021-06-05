package com.man.data.remote.response

import com.squareup.moshi.Json

data class CoinData(

	@Json(name = "DISPLAY")
	val display: DisplayModel? = null,

	@Json(name = "RAW")
	val rAW: RAW? = null,

	@Json(name = "CoinInfo")
	val coinInfo: CoinInfo? = null
)