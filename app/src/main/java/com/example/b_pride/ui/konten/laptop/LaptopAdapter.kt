package com.example.b_pride.ui.konten.laptop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.b_pride.R
import com.example.b_pride.data.remote.response.Product

class LaptopAdapter (private val list: List<Product>): RecyclerView.Adapter<LaptopAdapter.MyViewHolder>(){
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.name_rv)
        val brand: TextView = view.findViewById(R.id.brand_rv)
        val stok: TextView = view.findViewById(R.id.stok_rv)
        val deskripsi: TextView = view.findViewById(R.id.deskripsi_rv)
        val image: ImageView = view.findViewById(R.id.iv_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.brand.text = list[position].brand
        holder.stok.text = list[position].stock.toString()
        holder.deskripsi.text = list[position].description
        Glide.with(holder.itemView.context).load(list[position].thumbnail).into(holder.image)
    }
}