package com.aycap.pokedexappmvvm.di

import android.content.Context
import androidx.room.Room
import com.aycap.pokedexappmvvm.data.repo.PokemonDaoRepository
import com.aycap.pokedexappmvvm.room.Database
import com.aycap.pokedexappmvvm.room.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePokemonDaoRepository(pdao:PokemonDao) : PokemonDaoRepository {
        return PokemonDaoRepository(pdao)
    }
    @Provides
    @Singleton
    fun providePokemonDao(@ApplicationContext context:Context) : PokemonDao {
        val db = Room.databaseBuilder(context,Database::class.java,"pokedex.sqlite")
            .createFromAsset("pokedex.sqlite").build()
        return db.getPokemonDao()
    }
}