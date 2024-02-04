package com.aycap.pokedexappmvvm.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aycap.pokedexappmvvm.data.entity.Pokemon

@Database(entities = [Pokemon::class], version = 1)
abstract class Database : RoomDatabase(){
    abstract fun getPokemonDao() : PokemonDao
}