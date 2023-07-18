package com.example.miniapp

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.miniapp.databinding.ActivityMainBinding
import com.example.miniapp.databinding.FragmentNumbersBinding
import com.example.miniapp.databinding.FragmentPhrasesBinding
import com.example.miniapp.databinding.FragmentVocabBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.bottomNavigationView.itemTextColor = ContextCompat.getColorStateList(this, R.color.selector_bottom_navigation_text)
        binding.bottomNavigationView.itemIconTintList = ContextCompat.getColorStateList(this, R.color.selector_bottom_navigation_icon)


        val fragVocal = VocabFragment()
        val fragPhrases = PhrasesFragment()
        val fragNumbers = NumbersFragment()
        var fragment = "vocab"

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragVocal)
            commit()
        }

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId) {
                R.id.mnuVocab -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flFragment, fragVocal)
                        fragment = "vocab"
                        commit()
                    }
                }

                R.id.mnuPhrases -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flFragment, fragPhrases)
                        fragment = "phrases"
                        commit()
                    }
                }

                R.id.mnuNumbers -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flFragment, fragNumbers)
                        fragment = "numbers"
                        commit()
                    }
                }
            }
            true
        }

        binding.appBarTop.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.appBarAbout -> {showDialog()}
                R.id.app_bar_search -> {}
                R.id.appBarLogout ->{
                    val mainIntent = Intent(this, LoginActivity::class.java)
                    startActivity(mainIntent)
                    finish()
                } }
            true
        }

        val searchView = findViewById<SearchView>(R.id.app_bar_search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                //var searchData = mutableListOf<Vocabulary>()

                when(fragment){
                   "vocab" -> recyclerView =  findViewById(R.id.vocabRecyclerView) //recyclerVocab.vocabRecyclerView
                   "phrases" -> recyclerView = findViewById(R.id.phraseRecyclerView) //recyclerPhrases.phraseRecyclerView
                   else -> recyclerView = findViewById(R.id.numberRecyclerView) //recyclerNumber.numberRecyclerView
                }

                if (newText.isNotEmpty()) {
                    when (fragment) {
                        "vocab" -> recyclerView.adapter = VocabularyAdapter(searchVocabulary(newText))
                        "phrases"-> recyclerView.adapter = PhrasesAdapter(searchPhrases(newText))
                        else -> recyclerView.adapter = NumbersAdapter(searchNumber(newText))
                    }

                } else {
                    when (fragment) {
                        "vocab" -> recyclerView.adapter = VocabularyAdapter(vocabulary)
                        "phrases" -> recyclerView.adapter = PhrasesAdapter(phrases)
                        else -> recyclerView.adapter = NumbersAdapter(numbers)
                    }
                }
                return true
            }

            private fun searchVocabulary(query:String):MutableList<Vocabulary> {
                var searchData = mutableListOf<Vocabulary>()
                for(data in vocabulary){
                    if(data.span.contains(query, ignoreCase = true)){
                        searchData.add(data)
                    }
                }
                return searchData
            }

            private fun searchPhrases(query:String):MutableList<Phrases> {
                var searchData = mutableListOf<Phrases>()
                for(data in phrases){
                    if(data.span.contains(query, ignoreCase = true)){
                        searchData.add(data)
                    }
                }
                return searchData
            }

            private fun searchNumber(query:String):MutableList<Numbers> {
                var searchData = mutableListOf<Numbers>()
                for(data in numbers){
                    if(data.span.contains(query, ignoreCase = true)){
                        searchData.add(data)
                    }
                }
                return searchData
            }

        })

    }

    private fun showDialog(){
        val dialogView = LayoutInflater.from(this).inflate(R.layout.about_layout, null)
        val dialogImageView = findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.imageView3)
        val btnClose = dialogView.findViewById<Button>(R.id.btnClose)
        dialogImageView.setImageResource(R.drawable.spain)

        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        val alertDialog = builder.show()

        btnClose.setOnClickListener{alertDialog.dismiss()}
    }
}

