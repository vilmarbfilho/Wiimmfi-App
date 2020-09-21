package br.com.vlabs.wiimmfiapp.ui.game.stats.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.ui.game.model.GameModel
import br.com.vlabs.wiimmfiapp.ui.game.model.toImageResource
import kotlinx.android.synthetic.main.item_game_stat.view.*

class GameViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(game: GameModel, onClick: (GameModel) -> Unit) {
        val context = view.context

        view.cvContainer.setOnClickListener { onClick(game) }

        view.tvGameName.text = game.name
        view.tvGameVariants.text = context.getString(R.string.variants_label, game.variants)
        view.tvGameOnline.text = context.getString(R.string.online_label, game.online)

        if (game.remark.isEmpty()) {
            view.tvGameRemark.visibility = View.GONE
        } else {
            view.tvGameRemark.text = game.remark
            view.tvGameRemark.visibility = View.VISIBLE
        }

        view.tvGameType.text = game.console.name

        view.ivGameType.setImageResource(game.console.toImageResource())
    }
}