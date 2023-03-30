package com.example.android3dz1mvvm.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android3dz1mvvm.databinding.ItemFirstBinding
import com.example.android3dz1mvvm.model.FirstModel
import kotlin.reflect.KFunction0

class FirstAdapter(
    private var listBook: MutableList<FirstModel>,
    val onItemClick: (firstModel: FirstModel) -> Unit
) : RecyclerView.Adapter<FirstAdapter.AdapterViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setupObserves(listBook: MutableList<FirstModel>) {
        this.listBook = listBook
        notifyDataSetChanged()
    }

    inner class AdapterViewHolder(var binding: ItemFirstBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemClick(listBook[adapterPosition])
            }
        }

        fun onBind(firstModel: FirstModel) {
            binding.txtName.text = firstModel.name
            Glide.with(binding.imageViewItemFirst.context).load(firstModel.image)
                .into(binding.imageViewItemFirst)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(
            ItemFirstBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.onBind(listBook[position])
    }

    override fun getItemCount(): Int = listBook.size
}