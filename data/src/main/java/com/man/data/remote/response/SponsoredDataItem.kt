package com.man.data.remote.response

import com.squareup.moshi.Json

data class SponsoredDataItem(

	@Json(name = "CoinInfo")
	val coinInfo: CoinInfo
)