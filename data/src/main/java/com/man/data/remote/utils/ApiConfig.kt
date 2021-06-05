package com.man.data.remote.utils


/**
 *
 * Created by Lukmanul Hakim on  03/06/2021
 * devs.lukman@gmail.com
 */
data class ApiConfig(
    val baseUrl: String,
    val buildVersion: String,
    val buildNumber: Int,
    val buildDebug : Boolean,
)