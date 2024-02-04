package com.aycap.pokedexappmvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.aycap.pokedexappmvvm.data.entity.Pokemon
import com.aycap.pokedexappmvvm.room.PokemonDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonDaoRepository(var pdao:PokemonDao) {

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
        val job = CoroutineScope(Dispatchers.Main).launch {
            pokemonList.value = pdao.allPokemons()
        }
//        val list = ArrayList<Pokemon>()
//        val p1 = Pokemon(1,"Bulbasaur","Ivysaur","Grass","Poison","bulbasaur")
//        val p2 = Pokemon(2,"Ivysaur","Venusaur","Grass","Poison","ivysaur")
//        val p3 = Pokemon(3,"Venusaur","","Grass","Poiison","venusaur")
//        list.add(p1)
//        list.add(p2)
//        list.add(p3)
//        pokemonList.value = list
    }
}