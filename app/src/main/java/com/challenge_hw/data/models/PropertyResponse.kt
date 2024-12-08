package com.challenge_hw.data.models

data class PropertyResponse(
    val properties: List<Property>
)

data class Property(
    val id: Int,
    val name: String,
    val starRating: Int,
    val isFeatured: Boolean,
    val type: String,
    val address1: String,
    val freeCancellationAvailable: Boolean,
    val freeCancellation: FreeCancellation,
    val lowestPricePerNight: Price,
    val location: Location,
    val overview: String,
)

data class Price(
    val value: String,
    val currency: String
)

data class FreeCancellation(
    val label: String,
    val description: String
)

data class Location(
    val city: City,
    val region: String?
)

data class City(
    val id: Int,
    val name: String,
    val idCountry: Int,
    val country: String
)
