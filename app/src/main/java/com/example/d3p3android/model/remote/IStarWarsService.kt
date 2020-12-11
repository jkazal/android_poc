import retrofit2.Call
import retrofit2.http.GET
import java.nio.file.Path
import jdk.nashorn.internal.codegen.CompilerConstants.Call
import jdk.nashorn.internal.runtime.PropertyDescriptor.GET



interface IStarWarsService {
//    The suspend modifier is brought to us by Kotlin Coroutines, it indicates that the following function
//    will execute in a coroutine (similar to a thread) allowing us to keep the UI thread unblocked while long
//    lasting operations such as getting our data from the internet are being executed.

    @GET("people")
    suspend fun getAllPeople(): Response<List<StarWarsCharacter?>>?

    @GET("people/{id}")
    suspend fun getPeopleById(@Path("id") id: Int): Response<StarWarsCharacter?>?
}