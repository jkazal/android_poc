package com.example.d3p3android.di

import com.example.d3p3android.data.remote.IStarWarsService
import com.example.d3p3android.data.remote.StarWarsDataSource
import com.example.d3p3android.data.repository.StarWarsRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideStarWarsService(retrofit: Retrofit): IStarWarsService = retrofit.create(IStarWarsService::class.java)

    @Singleton
    @Provides
    fun provideStarWarsRemoteDataSource(starWarsService: IStarWarsService) = StarWarsDataSource(starWarsService)

    @Singleton
    @Provides
    fun provideStarWarsRepository(remoteDataSource: StarWarsDataSource) =
            StarWarsRepository(remoteDataSource)
}