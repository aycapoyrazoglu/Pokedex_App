package com.aycap.pokedexappmvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.aycap.pokedexappmvvm.data.entity.Pokemon

class PokemonDaoRepository {

    var pokemonList:MutableLiveData<List<Pokemon>>
    init {
        pokemonList = MutableLiveData()
    }

    fun allPokemonTake() : MutableLiveData<List<Pokemon>>
    {
        return pokemonList
    }
    fun searchPokemon(searchWord:String){
        Log.e("Pokemon Search",searchWord)
    }

    fun getAllPokemon()
    {
        val list = ArrayList<Pokemon>()
        val p1 = Pokemon(1,"Bulbasaur","Ivysaur","Grass","Poison","bulbasaur")
        val p2 = Pokemon(2,"Ivysaur","Venusaur","Grass","Poison","ivysaur")
        val p3 = Pokemon(3,"Venusaur","","Grass","Poiison","venusaur")
        list.add(p1)
        list.add(p2)
        list.add(p3)
        pokemonList.value = list
    }
}