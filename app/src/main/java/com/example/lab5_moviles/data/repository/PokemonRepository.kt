package com.example.lab5_moviles.data.repository

import com.example.lab5_moviles.data.model.PokemonDetail
import com.example.lab5_moviles.data.model.PokemonListItem
import com.example.lab5_moviles.data.remote.RetrofitClient

class PokemonRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getPokemonList(): Result<List<PokemonListItem>> {
        return try {
            val response = apiService.getPokemonList()
            Result.success(response.results)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getPokemonDetail(name: String): Result<PokemonDetail> {
        return try {
            val response = apiService.getPokemonDetail(name)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}