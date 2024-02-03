package com.example.recyclerviewnew.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewnew.databinding.ItemRvBinding
import com.example.recyclerviewnew.models.User
import com.squareup.picasso.Picasso

class RvAdapter(private val list:List<User>, val rvClick: RvClick) : RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(private var itemRv: ItemRvBinding):RecyclerView.ViewHolder(itemRv.root){
        fun onBind(user:User){
            itemRv.name.text = user.text
            Picasso.get().load(user.imageLink).into(itemRv.image)
            itemRv.root.setOnClickListener {
               rvClick.itemClick(user.text)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
       return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    interface RvClick{
        fun itemClick(text:String)
    }
}