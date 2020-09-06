package br.com.vlabs.wiimmfiapp.game.stats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.common.setToolbar
import br.com.vlabs.wiimmfiapp.game.stats.adapter.GameStatsAdapter
import kotlinx.android.synthetic.main.fragment_game_stats.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameStatsFragment : Fragment() {

    private val viewModel: GameStatsViewModel by viewModel()

    private val gameAdapter = GameStatsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_game_stats, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar(toolbar as Toolbar, getString(R.string.toolbar_label))

        setupRecyclerView()

        observeLiveData()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getGamesStats()
    }

    private fun observeLiveData() {
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

    private fun setupRecyclerView() {
        with(rvGameStats) {
            setHasFixedSize(true)
            adapter = gameAdapter
        }
    }
}