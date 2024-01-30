package com.aycap.pokedexappmvvm.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.aycap.pokedexappmvvm.R
import com.aycap.pokedexappmvvm.databinding.FragmentHomepageBinding

class HomepageFragment : Fragment() {

    private lateinit var design:FragmentHomepageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = FragmentHomepageBinding.inflate(inflater, container, false)


        design.buttonLoad.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.pokedexTransition) // Homepage -> PokemonFragment transition.
        }
        return design.root

    }

}