package com.aycap.pokedexappmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.aycap.pokedexappmvvm.R
import com.aycap.pokedexappmvvm.data.entity.Pokemon
import com.aycap.pokedexappmvvm.databinding.FragmentPokedexBinding
import com.aycap.pokedexappmvvm.ui.adapter.PokemonAdapter
import com.aycap.pokedexappmvvm.ui.viewmodel.PokedexViewModel

class PokedexFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var design:FragmentPokedexBinding
    private lateinit var viewModel:PokedexViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_pokedex,container,false)
        design.pokedexFragment = this
        design.pokedexToolbarTitle = "Pokedex"
        (activity as AppCompatActivity).setSupportActionBar(design.toolbarPokedex) // Action bar özelliği verme.

        design.rv.setHasFixedSize(true)
        //design.rv.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

       viewModel.pokemonList.observe(viewLifecycleOwner)
       {
           val adapter = PokemonAdapter(requireContext(),it)
           design.pokemonAdapter = adapter

       }

        requireActivity().addMenuProvider(object : MenuProvider{ // Arama özelliğini aktif etme.
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)
                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@PokedexFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : PokedexViewModel by viewModels()
        viewModel = tempViewModel
    }
    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }


}