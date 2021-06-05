package com.man.domain.module

import com.man.domain.usecase.UseCase
import com.man.domain.usecase.UseCaseImpl
import org.koin.dsl.module


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */

val domainModule = module {

    single<UseCase> { UseCaseImpl(get()) }

}