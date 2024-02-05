package com.aycap.pokedexappmvvm.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aycap.pokedexappmvvm.R
import com.aycap.pokedexappmvvm.data.entity.Pokemon
import com.aycap.pokedexappmvvm.databinding.CardDesignBinding
import com.aycap.pokedexappmvvm.ui.fragment.PokedexFragmentDirections
import com.aycap.pokedexappmvvm.util.transition

class PokemonAdapter(var mContext: Context,var pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.CardDesignHolder>() {

    inner class CardDesignHolder (design:CardDesignBinding) : RecyclerView.ViewHolder(design.root){
        var design:CardDesignBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder { // Card Tasarim View Binding Kurulumu
        val layoutInflater = LayoutInflater.from(mContext)
        val binding:CardDesignBinding = DataBindingUtil.inflate(layoutInflater,R.layout.card_design,parent,false)
        return CardDesignHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val pokemon = pokemonList.get(position)
        val d = holder.design
        d.pokemonObj = pokemon
        d.imageViewPokemonPic.setImageResource(
            mContext.resources.getIdentifier(pokemon.pokemon_picture_name,"drawable",mContext.packageName))

        //d.textViewPokemonId.text ="${pokemon.pokemon_id}"
        d.textViewPokemonName.text = pokemon.pokemon_name

        d.pokemonCard.setOnClickListener{
            val transition = PokedexFragmentDirections.pokemonDetailTransition(pokemon = pokemon)
            Navigation.transition(it,transition)
        }

    }
}