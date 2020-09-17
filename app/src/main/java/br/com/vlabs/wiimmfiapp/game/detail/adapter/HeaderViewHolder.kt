package br.com.vlabs.wiimmfiapp.game.detail.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.model.GameModel
import br.com.vlabs.wiimmfiapp.model.toImageResource
import kotlinx.android.synthetic.main.item_header_game_detail.view.*

class HeaderViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(headerGameModel: GameModel) {

        val context = view.context

        view.tvGameConsole.text =
            context.getString(R.string.console_label, headerGameModel.console.name)
        view.ivGameType.setImageResource(headerGameModel.console.toImageResource())

        view.tvGameName.text = headerGameModel.name

        if (headerGameModel.remark.isEmpty()) {
            view.tvGameRemark.visibility = View.GONE
        } else {
            view.tvGameRemark.text = headerGameModel.remark
            view.tvGameRemark.visibility = View.VISIBLE
        }

        view.tvGameVariants.text =
            context.getString(R.string.variants_label, headerGameModel.variants)

        view.tvGameOnline.text = context.getString(R.string.online_label, headerGameModel.online)
    }

}