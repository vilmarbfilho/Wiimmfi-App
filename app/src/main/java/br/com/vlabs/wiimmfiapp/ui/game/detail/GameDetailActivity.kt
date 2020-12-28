package br.com.vlabs.wiimmfiapp.ui.game.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.common.viewbinding.viewBinding
import br.com.vlabs.wiimmfiapp.databinding.ActivityGameDetailBinding
import br.com.vlabs.wiimmfiapp.ui.game.detail.adapter.OnlineUserAdapter
import br.com.vlabs.wiimmfiapp.ui.game.model.toImageResource
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GameDetailActivity : AppCompatActivity() {

    private val binding: ActivityGameDetailBinding by viewBinding()

    private val args: GameDetailActivityArgs by navArgs()

    private val viewModel: GameDetailViewModel by viewModel { parametersOf(args) }

    private val onlineUserAdapter = OnlineUserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupToolbar()

        setupRecyclerView()

        viewModel.loadOnlineUsers()

        observeLiveData()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)

        supportActionBar?.let { actionBar ->
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.setDisplayShowTitleEnabled(false)
        }

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setupRecyclerView() {
        with(binding.rvOnlineUsers) {
            setHasFixedSize(true)
            adapter = onlineUserAdapter
        }
    }

    private fun observeLiveData() {
        viewModel.loading.observe(this, { show ->
            binding.pbLoading.visibility = if (show) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        viewModel.gameConsole.observe(this, {
            binding.tvGameConsole.text = getString(R.string.console_label, it.name)
            binding.ivGameType.setImageResource(it.toImageResource())
        })

        viewModel.gameName.observe(this, {
            binding.tvGameName.text = it
        })

        viewModel.gameRemark.observe(this, {
            if (it.isEmpty()) {
                binding.tvGameRemark.visibility = View.GONE
            } else {
                binding.tvGameRemark.text = it
                binding.tvGameRemark.visibility = View.VISIBLE
            }
        })

        viewModel.gameVariants.observe(this, {
            binding.tvGameVariants.text = getString(R.string.variants_label, it)
        })

        viewModel.gameOnline.observe(this, {
            binding.tvGameOnline.text = getString(R.string.online_label, it)
        })

        viewModel.onlineUsers.observe(this, {
            onlineUserAdapter.updateDataSet(it)
        })
    }
}