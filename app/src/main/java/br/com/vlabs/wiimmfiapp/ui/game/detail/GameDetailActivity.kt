package br.com.vlabs.wiimmfiapp.ui.game.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.ui.game.detail.adapter.OnlineUserAdapter
import br.com.vlabs.wiimmfiapp.ui.game.model.toImageResource
import kotlinx.android.synthetic.main.activity_game_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GameDetailActivity : AppCompatActivity() {

    private val args: GameDetailActivityArgs by navArgs()

    private val viewModel: GameDetailViewModel by viewModel { parametersOf(args) }

    private val onlineUserAdapter = OnlineUserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_game_detail)

        setupToolbar()

        setupRecyclerView()

        viewModel.loadOnlineUsers()

        observeLiveData()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)

        supportActionBar?.let { actionBar ->
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.setDisplayShowTitleEnabled(false)
        }

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setupRecyclerView() {
        with(rvOnlineUsers) {
            setHasFixedSize(true)
            adapter = onlineUserAdapter
        }
    }

    private fun observeLiveData() {
        viewModel.loading.observe(this, { show ->
            pbLoading.visibility = if (show) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        viewModel.gameConsole.observe(this, {
            tvGameConsole.text = getString(R.string.console_label, it.name)
            ivGameType.setImageResource(it.toImageResource())
        })

        viewModel.gameName.observe(this, {
            tvGameName.text = it
        })

        viewModel.gameRemark.observe(this, {
            if (it.isEmpty()) {
                tvGameRemark.visibility = View.GONE
            } else {
                tvGameRemark.text = it
                tvGameRemark.visibility = View.VISIBLE
            }
        })

        viewModel.gameVariants.observe(this, {
            tvGameVariants.text = getString(R.string.variants_label, it)
        })

        viewModel.gameOnline.observe(this, {
            tvGameOnline.text = getString(R.string.online_label, it)
        })

        viewModel.onlineUsers.observe(this, {
            onlineUserAdapter.updateDataSet(it)
        })
    }
}