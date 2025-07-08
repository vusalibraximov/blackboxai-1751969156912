package com.example.turboazclone.domain.model

data class CarListing(
    val id: String,
    val brand: String,
    val model: String,
    val year: Int,
    val color: String,
    val mileage: Int,
    val engineVolume: Double,
    val transmission: String,
    val fuelType: String,
    val condition: String,
    val price: Int,
    val images: List<String>
)
