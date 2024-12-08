package com.challenge_hw.data.service

import com.challenge_hw.data.api.ApiClient
import com.challenge_hw.data.models.RateResponse
import io.reactivex.rxjava3.core.Single

class CurrencyApi {
    private val currencyService = ApiClient.currencyService

    fun getRates(): Single<RateResponse> {
        return currencyService.getRates()
    }
}

