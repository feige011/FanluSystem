package com.sunnyweather.fsystem.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val URL = "http://47.104.191.146:8080/fanlu/"
    private val retrofit =
        Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
            .build()
    fun <T> create(serviceClass:Class<T>):T= retrofit.create(serviceClass)

    inline fun <reified T>create():T= create(T::class.java)
}