package com.example.turboazclone.ui.screens.listingdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.turboazclone.domain.model.CarListing
import com.example.turboazclone.ui.screens.listingdetails.ListingDetailsViewModel

@Composable
fun ListingDetailsScreen(
    carId: String,
    viewModel: ListingDetailsViewModel
) {
    val carDetails by viewModel.carDetails.collectAsState()

    LaunchedEffect(carId) {
        viewModel.loadCarDetails(carId)
    }

    carDetails?.let { car ->
        ListingDetailsContent(car)
    } ?: run {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun ListingDetailsContent(car: CarListing) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Image slider placeholder
        if (car.images.isNotEmpty()) {
            Image(
                painter = rememberAsyncImagePainter(car.images[0]),
                contentDescription = "${car.brand} ${car.model}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "${car.brand} ${car.model}", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Year: ${car.year}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Price: ${car.price} AZN", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
        // Expandable sections can be added here for technical details
        Text(text = "Color: ${car.color}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Mileage: ${car.mileage} km", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Engine Volume: ${car.engineVolume} L", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Transmission: ${car.transmission}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Fuel Type: ${car.fuelType}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Condition: ${car.condition}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                // TODO: Implement call action
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Call Seller")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                // TODO: Implement WhatsApp action
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Contact via WhatsApp")
        }
    }
}
