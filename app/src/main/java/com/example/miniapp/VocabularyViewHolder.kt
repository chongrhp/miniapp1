package com.example.miniapp

import androidx.recyclerview.widget.RecyclerView
import com.example.miniapp.databinding.VocabularyLayoutBinding

class VocabularyViewHolder(private val binding: VocabularyLayoutBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(vocabulary:Vocabulary){binding.txtVocabulary.setText(vocabulary.span)}
}