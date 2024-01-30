package com.aycap.pokedexappmvvm.data.entity

import java.io.Serializable

data class Pokemon(var pokemon_id:Int,
                   var pokemon_name:String,
                   var pokemon_evolve:String,
                   var pokemon_type1:String,
                   var pokemon_type2:String,
                   var pokemon_picture_name:String) : Serializable {
}