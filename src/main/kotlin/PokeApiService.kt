import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


// Interface para definir la API de PokeAPI
interface PokeApiService {
    @GET("type/{type}")
    suspend fun getPokemonsByType(@Path("type") type: String): PokemonTypeResponse
}