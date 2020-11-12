package br.com.vlabs.wiimmfiapp.ui.more

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.vlabs.wiimmfiapp.router.MoreRouter
import br.com.vlabs.wiimmfiapp.ui.more.model.MoreItem
import br.com.vlabs.wiimmfiapp.ui.more.model.MoreItem.DONATE

class MoreViewModel(
    private val moreRouter: MoreRouter
) : ViewModel() {

    val moreItems: MutableLiveData<List<MoreItem>> = MutableLiveData(
        listOf(
            DONATE
        )
    )

    fun onMoreItemClicked(item: MoreItem) {
        when(item) {
            DONATE -> showDonatePage()
        }
    }

    private fun showDonatePage() {
        moreRouter.openDonate()
    }
}