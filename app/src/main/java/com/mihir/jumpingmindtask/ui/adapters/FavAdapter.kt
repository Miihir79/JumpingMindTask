package com.mihir.jumpingmindtask.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mihir.jumpingmindtask.databinding.ItemBeerBinding
import com.mihir.jumpingmindtask.model.BeerDataItem

class FavAdapter(private var onItemClicked: ((clickPosition: BeerDataItem) -> Unit)): RecyclerView.Adapter<FavAdapter.ViewHolder>()   {

    private var chat = ArrayList<BeerDataItem>()

    inner class ViewHolder(private val binding: ItemBeerBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BeerDataItem) = binding.apply {
            beerItem = item
            root.setOnClickListener {
                onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ItemBeerBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount() = chat.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chat[position])
    }

    fun setData(data:ArrayList<BeerDataItem>){
        chat = data
        notifyDataSetChanged()
    }

}