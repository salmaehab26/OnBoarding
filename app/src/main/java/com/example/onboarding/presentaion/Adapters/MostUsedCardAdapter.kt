package com.example.onboarding.presentaion.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onboarding.databinding.MostUseCardBinding
import com.example.onboarding.presentaion.Data.MostUsedCardModel

class MostUsedCardAdapter(
    private val items: List<MostUsedCardModel>,

    ) : RecyclerView.Adapter<MostUsedCardAdapter.ViewHolder>() {

        class ViewHolder(val binding: MostUseCardBinding) : RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = MostUseCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]

            holder.binding.image.setImageResource(item.imageRes)
            holder.binding.title.text=item.title
        }

        override fun getItemCount(): Int = items.size


}