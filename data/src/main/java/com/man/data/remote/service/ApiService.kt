package com.man.data.remote.service

import com.man.data.remote.enpoint.Endpoint.TOP_TIER
import com.man.data.remote.response.TopTierResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */
interface ApiService {

    @GET(TOP_TIER)
    suspend fun getTopTierList(
        @Query("limit") limit: Int? = 10,
        @Query("page") page: Int,
        @Query("tsym") tysm: String? = "USD"
    ): Response<TopTierResponse>

}