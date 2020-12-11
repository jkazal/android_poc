package com.example.d3p3android.data.remote

import javax.inject.Inject

class StarWarsDataSource @Inject constructor(
        private val starWarsService: IStarWarsService
): BaseDataSource() {

    suspend fun getAllPeople() = getResult { starWarsService.getAllPeople() }
    suspend fun getPeopleById(id: Int) = getResult { starWarsService.getPeopleById(id) }
}