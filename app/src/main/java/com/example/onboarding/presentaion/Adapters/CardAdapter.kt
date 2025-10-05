package com.example.onboarding.presentaion.Adapters

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onboarding.databinding.ItemCardBinding
import com.example.onboarding.presentaion.Data.CardModel

class CardAdapter(
    private val items: List<CardModel>,

    ) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            cardSubtitle.text = item.subtitle
            cardImage.setImageResource(item.imageRes)

            val gradientDrawable = GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                intArrayOf(item.startColor, item.endColor)
            )
            card.background = gradientDrawable
        }
    }

    override fun getItemCount(): Int = items.size

}