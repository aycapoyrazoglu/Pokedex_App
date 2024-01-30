package com.aycap.pokedexappmvvm.ui.fragment

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.aycap.pokedexappmvvm.R
import com.aycap.pokedexappmvvm.databinding.FragmentPokemonDetailBinding


class PokemonDetailFragment : Fragment() {

    private lateinit var design:FragmentPokemonDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = FragmentPokemonDetailBinding.inflate(inflater,container,false)
        design.toolbarPokemonDetail.title = "Pokemon Detail"
        val bundle:PokemonDetailFragmentArgs by navArgs() // gelen verinin alındığı yer.
        val pokemon = bundle.pokemon

        design.imageViewPokemonPictureDetail.setImageResource(requireContext().resources.getIdentifier(pokemon.pokemon_picture_name,"drawable",requireContext().packageName))
        design.textViewPokemonNameDetail.setText(pokemon.pokemon_name)
        design.textViewPokemonType.setText(pokemon.pokemon_type1)
        design.textViewPokemonType2.setText(pokemon.pokemon_type2)
        design.textViewPokemonEvolve.setText(pokemon.pokemon_evolve)
        return design.root
    }

}