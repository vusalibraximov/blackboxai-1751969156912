package com.example.turboazclone.ui.screens.home

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
class HomeViewModel @Inject constructor(
    private val carRepository: CarRepository
) : ViewModel() {

    private val _carListings = MutableStateFlow<List<CarListing>>(emptyList())
    val carListings: StateFlow<List<CarListing>> = _carListings

    fun loadListings() {
        viewModelScope.launch {
            val listings = carRepository.getCarListings()
            _carListings.value = listings
        }
    }
}
