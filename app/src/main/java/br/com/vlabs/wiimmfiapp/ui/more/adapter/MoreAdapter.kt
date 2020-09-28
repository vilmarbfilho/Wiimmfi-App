package br.com.vlabs.wiimmfiapp.ui.more.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.ui.more.model.MoreItem

class MoreAdapter(
    private val onClickItem: (MoreItem) -> Unit
) : RecyclerView.Adapter<MoreViewHolder>() {

    private val dataSet = mutableListOf<MoreItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoreViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_more, parent, false))


    override fun onBindViewHolder(holder: MoreViewHolder, position: Int) {
        holder.bind(dataSet[position]) {
            onClickItem(it)
        }
    }

    override fun getItemCount() = dataSet.size

    fun updateDataSet(data: List<MoreItem>) {
        dataSet.clear()
        dataSet.addAll(data)
        notifyDataSetChanged()
    }

}