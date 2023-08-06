import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Clase modelo para representar un Pokémon
data class Pokemon(
    val name: String,
    val type: String
)



// Data class para la respuesta de la API
data class PokemonTypeResponse(
    val pokemon: List<PokemonTypeEntry>
)

// Data class que representa un Pokémon dentro de la respuesta
data class PokemonTypeEntry(
    val pokemon: PokemonInfo
)

// Data class que contiene la información del Pokémon
data class PokemonInfo(
    val name: String,
    val url: String
)

fun main() {
    // Inicializar Retrofit para realizar llamadas a la API
    val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(PokeApiService::class.java)

    runBlocking {
        // Lista de elementos (tipos) de Pokémon que queremos obtener
        val elements = arrayOf("fire", "water")

        // Lista de trabajos (coroutines) para cada tipo de Pokémon
        val jobs = elements.map { element ->
            // Lanzar una coroutine para obtener los Pokémon del elemento
            async(Dispatchers.IO) {
                val response = apiService.getPokemonsByType(element)
                response.pokemon.map { it.pokemon } // Mapear la lista de Pokémon desde la respuesta
            }
        }

        // Esperar a que todos los trabajos (coroutines) finalicen
        val pokemonsList = jobs.awaitAll()

        // Imprimir los resultados
        for ((index, pokemons) in pokemonsList.withIndex()) {
            println("Pokémon del elemento '${elements[index]}':")
            for (pokemon in pokemons) {
                println("Name: ${pokemon.name}, Type: ${elements[index]}")
            }
            println()
        }
    }
}
