package com.example.miniapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miniapp.databinding.FragmentNumbersBinding

class NumbersFragment : Fragment() {
    private lateinit var binding : FragmentNumbersBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentNumbersBinding.inflate(layoutInflater,container, false)
        // Inflate the layout for this fragment

        binding.numberRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.numberRecyclerView.adapter = NumbersAdapter(numbers)
        return binding.root
    }
}