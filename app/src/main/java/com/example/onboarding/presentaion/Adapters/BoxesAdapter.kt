package com.example.onboarding.presentaion.Adapters

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onboarding.databinding.BoxesItemBinding
import com.example.onboarding.presentaion.Data.BoxesDataModel
import kotlin.math.ceil
import kotlin.math.min

class BoxesAdapter (private val allBoxes: List<BoxesDataModel>) :
    RecyclerView.Adapter<BoxesAdapter.ViewHolder>() {

   class ViewHolder(val binding: BoxesItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =BoxesItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val start = position * 4
        val end = min(start + 4, allBoxes.size)
        val pageBoxes = allBoxes.subList(start, end)

        val boxes = listOf(
            holder.binding.box1 to holder.binding.text1,
            holder.binding.box2 to holder.binding.text2,
            holder.binding.box3 to holder.binding.text3,
            holder.binding.box4 to holder.binding.text4
        )

        boxes.forEach { (box, text) ->
            box.visibility = View.INVISIBLE
            text.visibility = View.INVISIBLE
        }

        boxes.zip(pageBoxes).forEach { (pair, model) ->
            val (box, text) = pair
            box.backgroundTintList = ColorStateList.valueOf(model.Color)
            text.text = model.subtitle
            box.visibility = View.VISIBLE
            text.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int = 3
}