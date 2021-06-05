package com.man.data.module

import com.man.data.repository.RepositoryImpl
import com.man.domain.repository.Repository
import org.koin.dsl.module


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */

val repositoryModule = module {

    single<Repository> { RepositoryImpl(get()) }

}