package com.melihilhan.marveluniverseapp.di

import com.melihilhan.marveluniverseapp.data.repository.MarvelRepositoryImpl
import com.melihilhan.marveluniverseapp.data.source.MarvelApi
import com.melihilhan.marveluniverseapp.domain.repository.MarvelRepository
import com.melihilhan.marveluniverseapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providelMarvelApi(): MarvelApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarvelApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMarvelRepository(api: MarvelApi): MarvelRepository {
        return MarvelRepositoryImpl(api)
    }

}