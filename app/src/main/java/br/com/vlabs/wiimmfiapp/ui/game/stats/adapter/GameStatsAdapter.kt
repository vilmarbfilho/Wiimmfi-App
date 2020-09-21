package br.com.vlabs.wiimmfiapp.ui.game.stats.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.ui.game.model.GameModel

class GameStatsAdapter(
    private val onClickItem: (GameModel) -> Unit
) : RecyclerView.Adapter<GameViewHolder>() {

    private val dataSet = mutableListOf<GameModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_game_stat, parent, false))

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(dataSet[position]) {
            onClickItem(it)
        }
    }

    override fun getItemCount() = dataSet.size

    fun updateDataSet(data: List<GameModel>) {
        dataSet.clear()
        dataSet.addAll(data)
        notifyDataSetChanged()
    }
}