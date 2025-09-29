package com.example.lab5_moviles.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab5_moviles.data.model.PokemonDetail
import com.example.lab5_moviles.data.model.PokemonListItem
import com.example.lab5_moviles.data.remote.PokemonApiService
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private val apiService = PokemonApiService.create()

    var pokemonList = mutableStateOf<List<PokemonListItem>>(emptyList())
        private set

    var pokemonDetail = mutableStateOf<PokemonDetail?>(null)
        private set

    var isLoading = mutableStateOf(false)
        private set

    init {
        loadPokemonList()
    }

    private fun loadPokemonList() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val response = apiService.getPokemonList()
                pokemonList.value = response.results
            } catch (e: Exception) {
                // Handle error
            } finally {
                isLoading.value = false
            }
        }
    }

    fun loadPokemonDetail(name: String) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                pokemonDetail.value = apiService.getPokemonDetail(name)
            } catch (e: Exception) {
                // Handle error
            } finally {
                isLoading.value = false
            }
        }
    }
}