package com.example.miniapp

import androidx.recyclerview.widget.RecyclerView
import com.example.miniapp.databinding.NumbersLayoutBinding

class NumbersViewHolder(private val binding:NumbersLayoutBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(numbers:Numbers){binding.txtNumbers.setText(numbers.span)}
}