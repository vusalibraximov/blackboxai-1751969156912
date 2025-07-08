package com.example.turboazclone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car_listings")
data class CarListingEntity(
    @PrimaryKey val id: String,
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
