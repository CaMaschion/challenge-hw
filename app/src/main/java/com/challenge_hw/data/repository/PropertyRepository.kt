package com.challenge_hw.data.repository

import com.challenge_hw.data.models.PropertyResponse
import com.challenge_hw.data.service.PropertyApi
import io.reactivex.rxjava3.core.Single

class PropertyRepository(private val propertyApi: PropertyApi) {
    fun getProperties(): Single<PropertyResponse> {
        return propertyApi.getProperties()
    }
}
