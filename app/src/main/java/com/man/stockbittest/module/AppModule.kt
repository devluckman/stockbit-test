package com.man.stockbittest.module

import com.man.data.remote.utils.ApiConfig
import com.man.stockbittest.BuildConfig
import org.koin.dsl.module


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */
val appModule = module {

    single {
        ApiConfig(
            buildVersion = BuildConfig.VERSION_NAME,
            buildNumber = BuildConfig.VERSION_CODE,
            buildDebug = BuildConfig.DEBUG,
            baseUrl = BuildConfig.BASE_URL
        )
    }


}