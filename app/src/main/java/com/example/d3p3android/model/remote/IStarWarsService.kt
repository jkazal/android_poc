package com.example.d3p3android.data.remote

import com.example.d3p3android.data.entity.StarWarsCharacter
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Path


interface IStarWarsService {
//    The suspend modifier is brought to us by Kotlin Coroutines, it indicates that the following function
//    will execute in a coroutine (similar to a thread) allowing us to keep the UI thread unblocked while long
//    lasting operations such as getting our data from the internet are being executed.

    @GET("people")
    suspend fun getAllPeople(): Response<List<StarWarsCharacter>>

    @GET("people/{id}")
    suspend fun getPeopleById(@Path("id") id: Int): Response<StarWarsCharacter>
}