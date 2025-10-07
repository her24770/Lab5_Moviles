package com.example.lab5_moviles.data.remote

import com.example.lab5_moviles.data.model.PokemonDetail
import com.example.lab5_moviles.data.model.PokemonListResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int = 100): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String): PokemonDetail

}