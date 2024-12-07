package com.challenge_hw.data.service

import com.challenge_hw.data.models.PropertyResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PropertyService {

    @GET("properties.json")
    fun getProperties(): Single<PropertyResponse>
}
