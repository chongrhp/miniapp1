package com.example.miniapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miniapp.databinding.FragmentVocabBinding

class VocabFragment : Fragment() {
    private lateinit var binding : FragmentVocabBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentVocabBinding.inflate(layoutInflater, container, false)

        // Inflate the layout for this fragment


        binding.vocabRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.vocabRecyclerView.adapter = VocabularyAdapter(vocabulary)
        return binding.root

    }
}