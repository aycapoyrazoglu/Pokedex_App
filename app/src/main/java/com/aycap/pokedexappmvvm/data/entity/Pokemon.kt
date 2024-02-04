package com.aycap.pokedexappmvvm.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable
@Entity(tableName = "Pokemon")
data class Pokemon(@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name = "pokemon_id") @NotNull var pokemon_id:Int,
                   @ColumnInfo(name = "pokemon_name") @NotNull var pokemon_name:String,
                   @ColumnInfo(name="pokemon_evolve") @NotNull var pokemon_evolve:String,
                   @ColumnInfo(name="pokemon_type1") @NotNull var pokemon_type1:String,
                   @ColumnInfo(name="pokemon_type2") @NotNull var pokemon_type2:String,
                   @ColumnInfo(name="pokemon_picture_name") @NotNull var pokemon_picture_name:String) : Serializable {
}