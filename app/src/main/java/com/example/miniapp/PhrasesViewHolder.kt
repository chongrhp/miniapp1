package com.example.miniapp

import androidx.recyclerview.widget.RecyclerView
import com.example.miniapp.databinding.PhrasesLayoutBinding

class PhrasesViewHolder(private val binding:PhrasesLayoutBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(phrases:Phrases){binding.txtPhrases.setText(phrases.span)}
}