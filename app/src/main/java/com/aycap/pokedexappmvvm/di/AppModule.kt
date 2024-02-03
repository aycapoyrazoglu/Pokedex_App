package com.aycap.pokedexappmvvm.di

import com.aycap.pokedexappmvvm.data.repo.PokemonDaoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePokemonDaoRepository() : PokemonDaoRepository {
        return PokemonDaoRepository()
    }
}