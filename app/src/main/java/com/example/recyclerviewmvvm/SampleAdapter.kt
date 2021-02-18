package com.example.recyclerviewmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmvvm.databinding.ListItemSampleBinding

class SampleAdapter(val viewModel: SampleViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    sealed class AdapterItem {
        data class SampleItem(val data: String)
    }

    class SampleItemViewHolder(val binding: ListItemSampleBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SampleItemViewHolder(DataBindingUtil.inflate(inflater, R.layout.list_item_sample, parent, false))

    }

    override fun getItemCount(): Int {
        return viewModel.adapterItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val adapterItem = viewModel.adapterItems.getOrNull(position)
        if (holder !is SampleItemViewHolder || adapterItem !is AdapterItem.SampleItem) return

        holder.binding.title.text = adapterItem.data
        holder.binding.detail.text = "詳細詳細詳細詳細詳細詳細詳細詳細"
    }
}
