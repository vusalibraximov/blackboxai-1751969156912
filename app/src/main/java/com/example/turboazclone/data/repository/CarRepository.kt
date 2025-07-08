package com.example.turboazclone.data.repository

import com.example.turboazclone.domain.model.CarListing

interface CarRepository {
    suspend fun getCarListings(
        popular: Boolean? = null,
        new: Boolean? = null,
        brand: String? = null,
        model: String? = null,
        year: Int? = null,
        priceMin: Int? = null,
        priceMax: Int? = null,
        fuelType: String? = null
    ): List<CarListing>
}
