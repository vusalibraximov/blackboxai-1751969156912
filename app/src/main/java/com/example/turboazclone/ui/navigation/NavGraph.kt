package com.example.turboazclone.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.turboazclone.ui.screens.auth.AuthScreen
import com.example.turboazclone.ui.screens.home.HomeScreen
import com.example.turboazclone.ui.screens.listingdetails.ListingDetailsScreen
import com.example.turboazclone.ui.screens.addlisting.AddListingScreen
import com.example.turboazclone.ui.screens.profile.ProfileScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "auth") {
        composable("auth") {
            AuthScreen(
                viewModel = hiltViewModel(),
                onLoginSuccess = {
                    navController.navigate("home") {
                        popUpTo("auth") { inclusive = true }
                    }
                }
            )
        }
        composable("home") {
            HomeScreen(viewModel = hiltViewModel(), onNavigateToDetails = { carId ->
                navController.navigate("details/$carId")
            }, onNavigateToAddListing = {
                navController.navigate("addListing")
            }, onNavigateToProfile = {
                navController.navigate("profile")
            })
        }
        composable("details/{carId}") { backStackEntry ->
            val carId = backStackEntry.arguments?.getString("carId") ?: ""
            ListingDetailsScreen(carId = carId, viewModel = hiltViewModel())
        }
        composable("addListing") {
            AddListingScreen(viewModel = hiltViewModel(), onListingAdded = {
                navController.popBackStack()
            })
        }
        composable("profile") {
            ProfileScreen(viewModel = hiltViewModel(), onLogout = {
                navController.navigate("auth") {
                    popUpTo("home") { inclusive = true }
                }
            })
        }
    }
}
