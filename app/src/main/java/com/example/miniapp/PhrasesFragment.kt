package com.example.miniapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miniapp.databinding.FragmentPhrasesBinding

class PhrasesFragment : Fragment() {
    private lateinit var binding : FragmentPhrasesBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentPhrasesBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment


        binding.phraseRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.phraseRecyclerView.adapter = PhrasesAdapter(phrases)
        return binding.root
    }

}