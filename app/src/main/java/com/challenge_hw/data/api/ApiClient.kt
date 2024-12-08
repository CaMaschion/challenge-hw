package com.challenge_hw.data.api

import com.challenge_hw.data.service.CurrencyService
import com.challenge_hw.data.service.PropertyService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL =
        "https://gist.githubusercontent.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()
    }

    val propertyService: PropertyService by lazy {
        retrofit.create(PropertyService::class.java)
    }

    val currencyService: CurrencyService by lazy {
        retrofit.create(CurrencyService::class.java)
    }
}

