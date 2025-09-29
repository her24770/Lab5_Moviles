# Lab5_Moviles
Pokémon App - Android Studio con Jetpack Compose

## Descripción del Proyecto

Esta aplicación de Android desarrollada en **Kotlin con Jetpack Compose** permite a los usuarios explorar una lista de los primeros 100 Pokémon obtenidos desde la API pública de [PokéAPI](https://pokeapi.co/). La app implementa navegación entre dos pantallas principales y consume datos de una API REST usando Retrofit.

## Vistas

###Listado 
![85e816dc-f0c5-4eef-81f3-f39bd6cd5949](https://github.com/user-attachments/assets/7596183f-a64c-45d4-a223-9654af8fe1a0)

###Imagenes por pokemón
![3b80589f-808c-4dee-9525-9cee7d6a0f80](https://github.com/user-attachments/assets/267d829b-7415-4f12-946e-5606d24a57db)


## Funcionalidades Principales

### Pantalla Principal - Lista de Pokémon
- Muestra una lista scrolleable con los primeros 100 Pokémon
- Cada elemento de la lista incluye:
    - Nombre del Pokémon (capitalizado)
    - Imagen representativa del Pokémon
- Interfaz intuitiva con cards que responden al toque
- Indicador de carga mientras se obtienen los datos

### Pantalla de Detalles - Sprites del Pokémon
- Muestra 4 imágenes diferentes del Pokémon seleccionado:
    - **Front Default**: Vista frontal normal
    - **Back Default**: Vista trasera normal
    - **Front Shiny**: Vista frontal shiny/brillante
    - **Back Shiny**: Vista trasera shiny/brillante
- Botón de navegación para regresar a la lista

## Tecnologías Utilizadas

### Stack Tecnológico
- **Kotlin**: Lenguaje de programación principal
- **Jetpack Compose**: Framework moderno para UI declarativa
- **Retrofit**: Cliente HTTP para consumo de APIs REST
- **Coil**: Librería para carga eficiente de imágenes
- **Navigation Compose**: Sistema de navegación nativo de Compose
- **ViewModel**: Gestión del estado y lógica de negocio
- **Coroutines**: Programación asíncrona para llamadas de red

### Dependencias Principales
```gradle
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'io.coil-kt:coil-compose:2.4.0'
implementation 'androidx.navigation:navigation-compose:2.7.4'
implementation 'androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0'
```
## Estrcutura del Proyecto
La estructura con el funcionamiento para el llamamiento de peticicones al API Rest es el siguiente.
```
app/src/main/java/com/example/lab5_moviles/
├── MainActivity.kt                     # Actividad principal con navegación
├── data/
│   ├── model/
│   │   └── Pokemon.kt                  # Modelos de datos (DTOs)
│   └── remote/
│       └── PokemonApiService.kt        # Servicio Retrofit para API calls
├── ui/
│   ├── screen/
│   │   ├── PokemonListScreen.kt        # Pantalla de lista
│   │   └── PokemonDetailScreen.kt      # Pantalla de detalles
│   ├── viewmodel/
│   │   └── PokemonViewModel.kt         # ViewModel para gestión de estado
│   └── theme/
│       └── Theme.kt                    # Configuración del tema

```


