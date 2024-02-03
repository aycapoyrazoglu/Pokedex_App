package com.aycap.pokedexappmvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aycap.pokedexappmvvm.data.entity.Pokemon
import com.aycap.pokedexappmvvm.data.repo.PokemonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(var prepo:PokemonDaoRepository) : ViewModel() {

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