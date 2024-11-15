package com.example.mycityapp.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlacesViewModel : ViewModel() {
    private val _places = MutableLiveData<List<Place>>()
    val places: LiveData<List<Place>> get() = _places

    init {
        loadPlaces() // Load initial data
    }

    private fun loadPlaces() {
        _places.value = listOf(
            Place(1, "Central Park", "A large public park in NYC.", "Park", "url_to_image"),
            Place(2, "Joe's Coffee", "Cozy coffee shop with great pastries.", "Coffee Shop", "url_to_image"),
            // Add more places here
        )
    }

    fun getPlacesByCategory(category: String): List<Place> {
        return _places.value?.filter { it.category == category } ?: listOf()
    }
}
