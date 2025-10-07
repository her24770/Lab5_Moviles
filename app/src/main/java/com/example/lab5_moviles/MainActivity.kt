package com.example.lab5_moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab5_moviles.ui.screen.PokemonDetailScreen
import com.example.lab5_moviles.ui.screen.PokemonListScreen
import com.example.lab5_moviles.ui.theme.Lab5_MovilesTheme
import com.example.lab5_moviles.ui.viewmodel.PokemonViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5_MovilesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokemonApp()
                }
            }
        }
    }
}

@Composable
fun PokemonApp() {
    val navController = rememberNavController()
    val viewModel: PokemonViewModel = viewModel()

    // Configuración de navegación
    NavHost(
        navController = navController,
        startDestination = "pokemon_list"
    ) {
        // Definición de pantallas
        composable("pokemon_list") {
            PokemonListScreen(
                viewModel = viewModel,
                onPokemonClick = { pokemonName ->
                    navController.navigate("pokemon_detail/$pokemonName")
                }
            )
        }
        // Otra ruta para el detalle del Pokémon
        composable("pokemon_detail/{pokemonName}") { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString("pokemonName") ?: ""
            PokemonDetailScreen(
                pokemonName = pokemonName,
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}