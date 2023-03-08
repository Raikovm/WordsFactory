package com.example.wordsfactory.onboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsfactory.R

data class OnboardItem (val image: Int, val title: String, val description: String)

class OnboardItemsAdapter(private val onboardItems: List<OnboardItem>) : RecyclerView.Adapter<OnboardItemsAdapter.OnboardItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardItemViewHolder {
        return OnboardItemViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.onboard_item_container,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: OnboardItemViewHolder, position: Int) {
        holder.bind(onboardItems[position])
    }

    override fun getItemCount(): Int {
        return onboardItems.size
    }

    inner class OnboardItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageOnboard = view.findViewById<ImageView>(R.id.image)
        private val textTitle = view.findViewById<TextView>(R.id.title)
        private val textDescription = view.findViewById<TextView>(R.id.description)

        fun bind(onboardItem: OnboardItem) {
            imageOnboard.setImageResource(onboardItem.image)
            textTitle.text = onboardItem.title
            textDescription.text = onboardItem.description
        }
    }
}