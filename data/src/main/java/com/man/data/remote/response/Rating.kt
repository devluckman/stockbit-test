package com.man.data.remote.response

import com.squareup.moshi.Json

data class Rating(

	@Json(name = "Weiss")
	val weiss: Weiss
)