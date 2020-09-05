package br.com.vlabs.wiimmfiapp.game.stats.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.vlabs.domain.entity.Console
import br.com.vlabs.domain.entity.Game
import br.com.vlabs.wiimmfiapp.R
import kotlinx.android.synthetic.main.item_game_stat.view.*

class GameViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(game: Game) {
        val context = view.context

        view.tvGameName.text = game.name
        view.tvGameVariants.text = context.getString(R.string.variants_label, game.variants)
        view.tvGameOnline.text = context.getString(R.string.online_label, game.online)

        if (game.remark.isEmpty()) {
            view.tvGameRemark.visibility = View.GONE
        } else {
            view.tvGameRemark.text = game.remark
            view.tvGameRemark.visibility = View.VISIBLE
        }

        view.tvGameType.text = context.getString(R.string.type_label, game.console.name)

        val rscImage = when(game.console) {
            is Console.NDS -> R.drawable.nds
            is Console.WII -> R.drawable.wii
            is Console.WIIWARE -> R.drawable.wiiware
            else -> 0
        }

        view.ivGameType.setImageResource(rscImage)
    }
}