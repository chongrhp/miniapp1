package com.example.miniapp

import android.widget.SearchView
import androidx.databinding.BaseObservable

class MyViewModel : BaseObservable() {

    val onQueryTextListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean {
            // Perform desired actions when the search query is submitted
            return false
        }

        override fun onQueryTextChange(newText: String): Boolean {
            // Perform desired actions when the search query text changes
            return false
        }
    }

}