package com.example.turboazclone.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.turboazclone.data.local.entity.CarListingEntity

@Dao
interface CarListingDao {

    @Query("SELECT * FROM car_listings")
    suspend fun getAllListings(): List<CarListingEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(listings: List<CarListingEntity>)

    @Query("DELETE FROM car_listings")
    suspend fun clearAll()
}
