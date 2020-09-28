package br.com.vlabs.wiimmfiapp.ui.more

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.vlabs.wiimmfiapp.ui.more.model.MoreItem

class MoreViewModel : ViewModel() {

    val moreItems: MutableLiveData<List<MoreItem>> = MutableLiveData(
        listOf(
            MoreItem.DONATE
        )
    )

    fun onMoreItemClicked(item: MoreItem) {

    }
}