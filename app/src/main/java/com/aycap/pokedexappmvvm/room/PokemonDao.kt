package com.aycap.pokedexappmvvm.room

import androidx.room.Dao
import androidx.room.Query
import com.aycap.pokedexappmvvm.data.entity.Pokemon

@Dao
interface PokemonDao {
    @Query("SELECT * FROM Pokemon")
    suspend fun allPokemons() : List<Pokemon>
    @Query("SELECT * FROM Pokemon WHERE pokemon_name like '%' || :word || '%'")
    suspend fun searchPeople(word:String) : List<Pokemon>
}