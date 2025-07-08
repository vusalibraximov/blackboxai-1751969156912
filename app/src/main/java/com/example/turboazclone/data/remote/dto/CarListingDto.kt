package com.example.turboazclone.data.remote.dto

data class CarListingDto(
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
    val images: List<String>,
    val sellerContact: SellerContactDto
)

data class SellerContactDto(
    val phone: String,
    val whatsapp: String?
)
