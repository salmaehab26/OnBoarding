package com.example.onboarding.presentaion.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onboarding.databinding.NewsCardBinding
import com.example.onboarding.presentaion.Data.NewsCardModel

class NewsCardAdapter(
    private val items: List<NewsCardModel>,

    ) : RecyclerView.Adapter<NewsCardAdapter.ViewHolder>() {

    class ViewHolder(val binding: NewsCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NewsCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

holder.binding.cardImage.setImageResource(item.imageRes)
        holder.binding.bottomText.text=item.title
              }

    override fun getItemCount(): Int = items.size

}