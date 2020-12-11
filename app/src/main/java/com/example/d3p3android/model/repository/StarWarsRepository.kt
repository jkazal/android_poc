package com.example.d3p3android.data.repository

import com.example.d3p3android.data.entity.StarWarsCharacter
import com.example.d3p3android.data.remote.StarWarsDataSource
import com.example.d3p3android.utils.performGetOperation
import javax.inject.Inject

class StarWarsRepository @Inject constructor(
        private val remoteDataSource: StarWarsDataSource
) {

    fun getPeopleById(id: Int) = performGetOperation<StarWarsCharacter, StarWarsCharacter>(
            networkCall = { remoteDataSource.getPeopleById(id) }
    )

    fun getAllPeople() = performGetOperation<List<StarWarsCharacter>, List<StarWarsCharacter>>(
            networkCall = { remoteDataSource.getAllPeople() }
    )
}