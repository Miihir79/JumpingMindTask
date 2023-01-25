package com.mihir.jumpingmindtask.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mihir.jumpingmindtask.databinding.ItemBeerBinding
import com.mihir.jumpingmindtask.model.BeerDataItem

class BeerAdapter(private var onItemClicked: ((clickPosition: BeerDataItem) -> Unit)): PagingDataAdapter<BeerDataItem, BeerAdapter.ViewHolder>(
    BeerDiffUtilsCallBacks()
) {

    inner class ViewHolder(private val itemBinding: ItemBeerBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item: BeerDataItem){
            with(itemBinding){
                beerItem = item
                root.setOnClickListener {
                    onItemClicked(item)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =  ItemBeerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    class BeerDiffUtilsCallBacks : DiffUtil.ItemCallback<BeerDataItem>() {
        override fun areItemsTheSame(oldItem: BeerDataItem, newItem: BeerDataItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BeerDataItem, newItem: BeerDataItem): Boolean {
            return oldItem == newItem
        }

    }

}