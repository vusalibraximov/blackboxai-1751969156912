package com.example.turboazclone.ui.screens.listingdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turboazclone.data.repository.CarRepository
import com.example.turboazclone.domain.model.CarListing
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListingDetailsViewModel @Inject constructor(
    private val carRepository: CarRepository
) : ViewModel() {

    private val _carDetails = MutableStateFlow<CarListing?>(null)
    val carDetails: StateFlow<CarListing?> = _carDetails

    fun loadCarDetails(carId: String) {
        viewModelScope.launch {
            val listings = carRepository.getCarListings()
            _carDetails.value = listings.find { it.id == carId }
        }
    }
}
