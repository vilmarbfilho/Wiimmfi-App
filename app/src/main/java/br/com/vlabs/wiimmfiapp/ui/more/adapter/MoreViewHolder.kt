package br.com.vlabs.wiimmfiapp.ui.more.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.vlabs.wiimmfiapp.ui.more.model.MoreItem
import kotlinx.android.synthetic.main.item_more.view.*

class MoreViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(moreItem: MoreItem, onClick: (MoreItem) -> Unit) {
        val context = view.context

        view.cvMoreContainer.setOnClickListener { onClick(moreItem) }

        view.tvMoreName.text = context.getString(moreItem.nameRsc)
    }
}