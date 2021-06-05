package com.man.core.extentions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */

fun <T> LifecycleOwner.observeData(observable : LiveData<T>, observer : (T) -> Unit){
    observable.observe(this, {
        observer(it)
    })
}