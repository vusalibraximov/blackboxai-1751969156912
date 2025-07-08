package com.example.turboazclone.data.remote

import com.example.turboazclone.data.remote.dto.CarListingDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("listings")
    suspend fun getCarListings(
        @Query("popular") popular: Boolean? = null,
        @Query("new") new: Boolean? = null,
        @Query("brand") brand: String? = null,
        @Query("model") model: String? = null,
        @Query("year") year: Int? = null,
        @Query("price_min") priceMin: Int? = null,
        @Query("price_max") priceMax: Int? = null,
        @Query("fuel_type") fuelType: String? = null
    ): List<CarListingDto>
}
