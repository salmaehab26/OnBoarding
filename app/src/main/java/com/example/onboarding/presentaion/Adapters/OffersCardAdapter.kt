package com.example.onboarding.presentaion.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onboarding.databinding.ResturantViewBinding
import com.example.onboarding.presentaion.Data.OffersCardModel

class OffersCardAdapter (
    private val items: List<OffersCardModel>,

    ) : RecyclerView.Adapter<OffersCardAdapter.ViewHolder>() {

        class ViewHolder(val binding: ResturantViewBinding) : RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ResturantViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]

            holder.binding.tvTitle.text=item.title
            holder.binding.image.setImageResource(item.imageRes)

        }

        override fun getItemCount(): Int = items.size


}