package com.example.wordsfactory.dictionary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsfactory.R

class DictionaryItem(
    val meaning: String
)

class DictionaryItemAdapter(private val dictionaryMeaningItems: List<DictionaryItem>) :
    RecyclerView.Adapter<DictionaryItemAdapter.DictionaryMeaningItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryMeaningItemViewHolder {
        return DictionaryMeaningItemViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.dictionary_item_container,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: DictionaryMeaningItemViewHolder, position: Int) {
        holder.bind(dictionaryMeaningItems[position])
    }

    override fun getItemCount(): Int {
        return dictionaryMeaningItems.size
    }

    inner class DictionaryMeaningItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textMeaning = view.findViewById<TextView>(R.id.textMeaning)

        fun bind(dictionaryMeaningItem: DictionaryItem) {
            textMeaning.text = dictionaryMeaningItem.meaning
        }
    }
}