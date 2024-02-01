package com.aycap.pokedexappmvvm.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.aycap.pokedexappmvvm.R
import com.aycap.pokedexappmvvm.databinding.FragmentHomepageBinding

class HomepageFragment : Fragment() {

    private lateinit var design:FragmentHomepageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage,container, false)
        design.homepageFragment = this
        return design.root
    }

    fun buttonLoadClick(it:View)
    {
        Navigation.findNavController(it).navigate(R.id.pokedexTransition) // Homepage -> PokemonFragment transition.
    }

}