package com.example.turboazclone.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.turboazclone.data.local.dao.CarListingDao
import com.example.turboazclone.data.local.entity.CarListingEntity

@Database(
    entities = [CarListingEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carListingDao(): CarListingDao
}
