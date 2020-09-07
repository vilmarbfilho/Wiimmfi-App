package br.com.vlabs.wiimmfiapp.game.stats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.common.setToolbar
import br.com.vlabs.wiimmfiapp.game.stats.adapter.GameStatsAdapter
import kotlinx.android.synthetic.main.error_game_stat.*
import kotlinx.android.synthetic.main.fragment_game_stats.*
import kotlinx.android.synthetic.main.fragment_game_stats.pbLoading
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GameStatsFragment : Fragment() {

    private val navController by lazy { findNavController() }

    private val viewModel: GameStatsViewModel by viewModel { parametersOf(navController) }

    private val gameAdapter = GameStatsAdapter {
        viewModel.onGameClicked(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_game_stats, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar(toolbar, getString(R.string.toolbar_label))

        setupRecyclerView()

        setupListener()

        observeLiveData()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getGamesStats()
    }

    private fun setupRecyclerView() {
        with(rvGameStats) {
            setHasFixedSize(true)
            adapter = gameAdapter
        }
    }

    private fun setupListener() {
        btnTryAgain.setOnClickListener { viewModel.getGamesStats() }
    }

    private fun observeLiveData() {
        viewModel.showError.observe(viewLifecycleOwner, { show ->
            clErrorGenericContainer.visibility = if (show) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        viewModel.loading.observe(viewLifecycleOwner, { show ->
            pbLoading.visibility = if (show) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        viewModel.gameStats.observe(viewLifecycleOwner, {
            gameAdapter.updateDataSet(it)
        })
    }
}