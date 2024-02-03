package com.aycap.pokedexappmvvm.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.aycap.pokedexappmvvm.R

fun Navigation.transition(it:View,id:Int)
{
    findNavController(it).navigate(id)
}

fun Navigation.transition(it:View,id:NavDirections)
{
    findNavController(it).navigate(id)
}