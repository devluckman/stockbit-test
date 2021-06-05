package com.man.stockbittest

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.man.data.module.dataModule
import com.man.domain.module.domainModule
import com.man.stockbittest.module.appModule
import com.man.stockbittest.module.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */
class BaseApplication : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            modules(appModule)
            modules(dataModule)
            modules(domainModule)
            modules(viewModel)
        }
    }
}