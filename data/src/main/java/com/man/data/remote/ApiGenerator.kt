package com.man.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */
class ApiGenerator(
    baseURL: String,
    client: OkHttpClient
) {

    private var mRetrofit: Retrofit

    init {
        mRetrofit = provideRetrofit(baseURL, client)
    }

    private fun provideRetrofit(
        baseURL: String,
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()))
            .build()
    }


    fun <T> createService(clazz: Class<T>): T {
        return mRetrofit.create(clazz)
    }

}