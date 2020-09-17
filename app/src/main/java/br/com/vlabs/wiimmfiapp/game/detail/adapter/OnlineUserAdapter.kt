package br.com.vlabs.wiimmfiapp.game.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.model.GameModel
import br.com.vlabs.wiimmfiapp.model.OnlineUserModel

class OnlineUserAdapter: RecyclerView.Adapter<ViewHolder>()  {

    private val HEADER_TYPE = 0
    private val ITEM_TYPE = 1

    private val dataSet = mutableListOf<OnlineUserModel>()

    private var headerGameModel: GameModel? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return if (viewType == HEADER_TYPE) {
            HeaderViewHolder(inflater.inflate(R.layout.item_header_game_detail, parent, false))
        } else {
            OnlineUserViewHolder(inflater.inflate(R.layout.item_online_user, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is HeaderViewHolder) {
            headerGameModel?.let { holder.bind(it) }
        } else if (holder is OnlineUserViewHolder && dataSet.isNotEmpty()){
            holder.bind(dataSet[position - 1])
        }
    }

    override fun getItemCount() = dataSet.size + if (headerGameModel != null) 1 else 0

    override fun getItemViewType(position: Int) =
        if (headerGameModel != null && position == 0) {
            HEADER_TYPE
        } else {
            ITEM_TYPE
        }

    fun setHeader(gameModel: GameModel) {
        headerGameModel = gameModel
    }

    fun updateDataSet(data: List<OnlineUserModel>) {
        dataSet.clear()
        dataSet.addAll(data)
        notifyDataSetChanged()
    }

}