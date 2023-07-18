package com.example.miniapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miniapp.databinding.VocabularyLayoutBinding

class VocabularyAdapter(private val vocabulary:List<Vocabulary>):RecyclerView.Adapter<VocabularyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VocabularyLayoutBinding.inflate(inflater, parent, false)
        return VocabularyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return vocabulary.size
    }

    override fun onBindViewHolder(holder: VocabularyViewHolder, position: Int) {
        holder.bind(vocabulary[position])
        holder.itemView.setOnClickListener {
            val myIntent = Intent(holder.itemView.context, DetailedActivity::class.java)
            myIntent.putExtra("spanish",vocabulary[position].span)
            myIntent.putExtra("english",vocabulary[position].eng)
            myIntent.putExtra("menus","vocabulary")
            holder.itemView.context.startActivity(myIntent)
        }
    }

}