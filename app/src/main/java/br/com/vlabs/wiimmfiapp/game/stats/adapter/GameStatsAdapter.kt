package br.com.vlabs.wiimmfiapp.game.stats.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.vlabs.domain.entity.Game
import br.com.vlabs.wiimmfiapp.R

class GameStatsAdapter: RecyclerView.Adapter<GameViewHolder>() {

    private val dataSet = mutableListOf<Game>()

    private var clickListener: ((Game) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_game_stat, parent, false))

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(dataSet[position]) {
            clickListener?.invoke(it)
        }
    }

    override fun getItemCount() = dataSet.size

    fun updateDataSet(data: List<Game>) {
        dataSet.clear()
        dataSet.addAll(data)
        notifyDataSetChanged()
    }

    fun onGameClicked(listener: (Game) -> Unit) {
        clickListener = listener
    }
}