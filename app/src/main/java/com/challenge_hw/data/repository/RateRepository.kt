package com.challenge_hw.data.repository

import com.challenge_hw.data.models.RateResponse
import com.challenge_hw.data.service.CurrencyApi
import io.reactivex.rxjava3.core.Single

class RateRepository(private val currencyApi: CurrencyApi) {
    fun getRates(): Single<RateResponse> {
        return currencyApi.getRates()
    }
}
