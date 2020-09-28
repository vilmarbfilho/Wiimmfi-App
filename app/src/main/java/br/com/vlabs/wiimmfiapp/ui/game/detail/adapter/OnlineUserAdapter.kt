package br.com.vlabs.wiimmfiapp.ui.game.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.ui.game.model.OnlineUserModel

class OnlineUserAdapter: RecyclerView.Adapter<OnlineUserViewHolder>()  {

    private val dataSet = mutableListOf<OnlineUserModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        OnlineUserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_online_user, parent, false))

    override fun onBindViewHolder(holder: OnlineUserViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    fun updateDataSet(data: List<OnlineUserModel>) {
        dataSet.clear()
        dataSet.addAll(data)
        notifyDataSetChanged()
    }
}