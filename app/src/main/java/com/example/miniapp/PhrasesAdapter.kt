package com.example.miniapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miniapp.databinding.PhrasesLayoutBinding

class PhrasesAdapter(private val phrases:List<Phrases>):RecyclerView.Adapter<PhrasesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhrasesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PhrasesLayoutBinding.inflate(inflater,parent,false)
        return PhrasesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return phrases.size
    }

    override fun onBindViewHolder(holder: PhrasesViewHolder, position: Int) {
        holder.bind(phrases[position])
        holder.itemView.setOnClickListener {
            val myIntent = Intent(holder.itemView.context, DetailedActivity::class.java)
            myIntent.putExtra("spanish",phrases[position].span)
            myIntent.putExtra("english",phrases[position].eng)
            myIntent.putExtra("menus","phrase")
            holder.itemView.context.startActivity(myIntent)
        }
    }

}