package com.example.turboazclone.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.turboazclone.domain.model.CarListing

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    onLogout: () -> Unit
) {
    val myListings by viewModel.myListings.collectAsState()
    val favorites by viewModel.favorites.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Profile") })
        },
        content = { padding ->
            Column(modifier = Modifier.padding(padding).padding(16.dp)) {
                Text("My Listings", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn {
                    items(myListings) { car ->
                        Text("${car.brand} ${car.model} - ${car.price} AZN")
                        Divider()
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text("Favorites", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn {
                    items(favorites) { car ->
                        Text("${car.brand} ${car.model} - ${car.price} AZN")
                        Divider()
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = onLogout, modifier = Modifier.fillMaxWidth()) {
                    Text("Logout")
                }
            }
        }
    )
}
