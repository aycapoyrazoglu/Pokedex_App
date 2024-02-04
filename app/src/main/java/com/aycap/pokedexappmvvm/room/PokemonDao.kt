package com.aycap.pokedexappmvvm.room

import androidx.room.Dao
import androidx.room.Query
import com.aycap.pokedexappmvvm.data.entity.Pokemon

@Dao
interface PokemonDao {
    @Query("SELECT * FROM Pokemon")
    suspend fun allPokemons() : List<Pokemon>
}