package com.example.turboazclone.data.repository

import com.example.turboazclone.data.local.dao.CarListingDao
import com.example.turboazclone.data.local.entity.CarListingEntity
import com.example.turboazclone.data.remote.ApiService
import com.example.turboazclone.data.remote.dto.CarListingDto
import com.example.turboazclone.domain.model.CarListing
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CarRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val carListingDao: CarListingDao
) : CarRepository {

    override suspend fun getCarListings(
        popular: Boolean?,
        new: Boolean?,
        brand: String?,
        model: String?,
        year: Int?,
        priceMin: Int?,
        priceMax: Int?,
        fuelType: String?
    ): List<CarListing> = withContext(Dispatchers.IO) {
        try {
            val remoteListings = apiService.getCarListings(
                popular, new, brand, model, year, priceMin, priceMax, fuelType
            )
            val entities = remoteListings.map { it.toEntity() }
            carListingDao.clearAll()
            carListingDao.insertAll(entities)
            entities.map { it.toDomain() }
        } catch (e: Exception) {
            // On error, fallback to local cache
            carListingDao.getAllListings().map { it.toDomain() }
        }
    }

    private fun CarListingDto.toEntity(): CarListingEntity {
        return CarListingEntity(
            id = id,
            brand = brand,
            model = model,
            year = year,
            color = color,
            mileage = mileage,
            engineVolume = engineVolume,
            transmission = transmission,
            fuelType = fuelType,
            condition = condition,
            price = price,
            images = images
        )
    }

    private fun CarListingEntity.toDomain(): CarListing {
        return CarListing(
            id = id,
            brand = brand,
            model = model,
            year = year,
            color = color,
            mileage = mileage,
            engineVolume = engineVolume,
            transmission = transmission,
            fuelType = fuelType,
            condition = condition,
            price = price,
            images = images
        )
    }
}
