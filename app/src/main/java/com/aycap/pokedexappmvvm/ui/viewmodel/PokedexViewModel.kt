package com.aycap.pokedexappmvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aycap.pokedexappmvvm.data.entity.Pokemon
import com.aycap.pokedexappmvvm.data.repo.PokemonDaoRepository

class PokedexViewModel : ViewModel() {
    val prepo = PokemonDaoRepository()
    var pokemonList = MutableLiveData<List<Pokemon>>()
    init {
        allPokemonShow()
        pokemonList = prepo.allPokemonTake()
    }

    fun search(searchWord:String){
        prepo.searchPokemon(searchWord)
    }

    fun allPokemonShow()
    {
        prepo.getAllPokemon()
    }

}