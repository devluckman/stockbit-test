package com.man.data.remote.response

import com.squareup.moshi.Json

data class MetaData(

	@Json(name = "Count")
	val count: Int
)