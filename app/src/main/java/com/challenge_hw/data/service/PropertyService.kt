package com.challenge_hw.data.service

import com.challenge_hw.data.models.PropertyResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PropertyService {

    @GET("ollerandreshw/e02c83a2c973c625bbc250e1d93a2040/raw/55b40d1b4e96fd8cde73aebb8d229a45dff28f2d/properties.json")
    fun getProperties(): Single<PropertyResponse>
}
