package br.com.vlabs.wiimmfiapp.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.common.setToolbar
import br.com.vlabs.wiimmfiapp.ui.more.adapter.MoreAdapter
import kotlinx.android.synthetic.main.fragment_more.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MoreFragment : Fragment() {

    private val navController by lazy { findNavController() }

    //private val viewModel: MoreViewModel by viewModel { parametersOf(navController) }
    private val viewModel: MoreViewModel by viewModel()

    private val moreAdapter = MoreAdapter {
        viewModel.onMoreItemClicked(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_more, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar(toolbarMore, getString(R.string.toolbar_label))

        setupRecyclerView()

        observeLiveData()
    }

    private fun setupRecyclerView() {
        with(rvMore) {
            setHasFixedSize(true)
            adapter = moreAdapter
        }
    }

    private fun observeLiveData() {
        viewModel.moreItems.observe(viewLifecycleOwner, {
            moreAdapter.updateDataSet(it)
        })
    }
}