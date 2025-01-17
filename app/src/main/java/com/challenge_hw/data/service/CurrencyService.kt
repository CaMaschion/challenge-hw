package com.challenge_hw.data.service

import com.challenge_hw.data.models.RateResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CurrencyService {

    @GET("PedroTrabulo-Hostelworld/16e87e40ca7b9650aa8e1b936f23e14e/raw/15efd901b57c2b66bf0201ee7aa9aa2edc6df779/rates.json")
    fun getRates(): Single<RateResponse>
}