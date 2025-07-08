package com.example.turboazclone.ui.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turboazclone.data.repository.CarRepository
import com.example.turboazclone.domain.model.CarListing
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val carRepository: CarRepository,
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    private val _myListings = MutableStateFlow<List<CarListing>>(emptyList())
    val myListings: StateFlow<List<CarListing>> = _myListings

    private val _favorites = MutableStateFlow<List<CarListing>>(emptyList())
    val favorites: StateFlow<List<CarListing>> = _favorites

    fun loadUserData() {
        viewModelScope.launch {
            val userId = firebaseAuth.currentUser?.uid ?: return@launch
            // TODO: Fetch user's listings and favorites from repository or Firebase
            val listings = carRepository.getCarListings() // Placeholder: filter by userId
            _myListings.value = listings
            _favorites.value = emptyList() // Placeholder
        }
    }

    fun logout() {
        firebaseAuth.signOut()
    }
}
