package com.example.miniapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miniapp.databinding.NumbersLayoutBinding

class NumbersAdapter(private val numbers:List<Numbers>):RecyclerView.Adapter<NumbersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NumbersLayoutBinding.inflate(inflater, parent, false)
        return NumbersViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    override fun onBindViewHolder(holder: NumbersViewHolder, position: Int) {
        holder.bind(numbers[position])
        holder.itemView.setOnClickListener {
            val myIntent = Intent(holder.itemView.context, DetailedActivity::class.java)
            myIntent.putExtra("spanish",numbers[position].span)
            myIntent.putExtra("english",numbers[position].eng)
            myIntent.putExtra("menus","number")
            holder.itemView.context.startActivity(myIntent)
        }
    }

}