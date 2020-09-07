package br.com.vlabs.wiimmfiapp.game.detail.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.vlabs.wiimmfiapp.model.OnlineUserModel
import kotlinx.android.synthetic.main.item_online_user.view.*

class OnlineUserViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(onlineUserModel: OnlineUserModel) {
        view.tvFriendCode.text = onlineUserModel.friendCode
        view.tvStatus.text = onlineUserModel.status
        view.tvName.text = onlineUserModel.name1
    }
}