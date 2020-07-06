package com.example.demoroomapp.data.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())

    private var retrofit: Retrofit? = null

    fun <S> createService(serviceClass: Class<S>): S {
        retrofit = builder.build()
        return retrofit!!.create(serviceClass)
    }
}