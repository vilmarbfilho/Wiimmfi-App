package br.com.vlabs.wiimmfiapp.game.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.common.getActionBar
import br.com.vlabs.wiimmfiapp.common.setToolbar
import kotlinx.android.synthetic.main.fragment_game_stats.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameDetailFragment : Fragment() {

    private val viewModel: GameDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_game_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()

        observeLiveData()
    }

    private fun setupToolbar() {
        setToolbar(toolbar)

        getActionBar()?.let { actionBar ->
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.setDisplayShowTitleEnabled(false)
        }

        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun observeLiveData() {

    }
}