package com.example.lab5_moviles.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab5_moviles.data.model.PokemonDetail
import com.example.lab5_moviles.data.model.PokemonListItem
import com.example.lab5_moviles.data.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private val repository = PokemonRepository()

    // StateFlow para la lista de Pokémon
    private val _pokemonList = MutableStateFlow<List<PokemonListItem>>(emptyList())
    val pokemonList: StateFlow<List<PokemonListItem>> = _pokemonList.asStateFlow()

    // StateFlow para el detalle del Pokémon
    private val _pokemonDetail = MutableStateFlow<PokemonDetail?>(null)
    val pokemonDetail: StateFlow<PokemonDetail?> = _pokemonDetail.asStateFlow()

    // StateFlow para el estado de carga
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    // StateFlow para manejar errores
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadPokemonList()
    }
    // Función para cargar la lista de Pokémon
    private fun loadPokemonList() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            repository.getPokemonList()
                .onSuccess { pokemonList ->
                    _pokemonList.value = pokemonList
                }
                .onFailure { exception ->
                    _error.value = exception.message ?: "Error al cargar la lista de Pokémon"
                }

            _isLoading.value = false
        }
    }
    // Función para cargar los detalles del Pokémon
    fun loadPokemonDetail(name: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            repository.getPokemonDetail(name)
                .onSuccess { detail ->
                    _pokemonDetail.value = detail
                }
                .onFailure { exception ->
                    _error.value = exception.message ?: "Error al cargar los detalles del Pokémon"
                }

            _isLoading.value = false
        }
    }
}