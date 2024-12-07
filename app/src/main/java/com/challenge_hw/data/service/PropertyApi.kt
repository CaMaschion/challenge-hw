package com.challenge_hw.data.service

import com.challenge_hw.data.api.ApiClient
import com.challenge_hw.data.models.PropertyResponse
import io.reactivex.rxjava3.core.Single

class PropertyApi {
    private val propertyService = ApiClient.propertyService

    fun getProperties(): Single<PropertyResponse> {
        return propertyService.getProperties()
    }
}