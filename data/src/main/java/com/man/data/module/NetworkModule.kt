package com.man.data.module

import com.man.data.remote.ApiGenerator
import com.man.data.remote.service.ApiService
import com.man.data.remote.utils.ApiConfig
import com.man.data.remote.utils.OkHttpClientFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */

val networkModule = module {

    single {
        OkHttpClientFactory.create(get(), androidContext())
    }

    single {
        ApiGenerator(
            get<ApiConfig>().baseUrl,
            get()
        ).createService(ApiService::class.java)
    }

}