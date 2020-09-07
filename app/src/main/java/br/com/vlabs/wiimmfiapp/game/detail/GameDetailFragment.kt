package br.com.vlabs.wiimmfiapp.game.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.vlabs.wiimmfiapp.R
import br.com.vlabs.wiimmfiapp.common.getActionBar
import br.com.vlabs.wiimmfiapp.common.setToolbar
import br.com.vlabs.wiimmfiapp.model.toImageResource
import kotlinx.android.synthetic.main.fragment_game_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GameDetailFragment : Fragment() {

    private val args: GameDetailFragmentArgs by navArgs()

    private val viewModel: GameDetailViewModel by viewModel { parametersOf(args) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_game_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()

        viewModel.loadOnlineUsers()

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
        viewModel.gameConsole.observe(viewLifecycleOwner, {
            tvGameConsole.text = getString(R.string.console_label, it.name)
            ivGameType.setImageResource(it.toImageResource())
        })

        viewModel.gameName.observe(viewLifecycleOwner, {
            tvGameName.text = it
        })

        viewModel.gameRemark.observe(viewLifecycleOwner, {
            if (it.isEmpty()) {
                tvGameRemark.visibility = View.GONE
            } else {
                tvGameRemark.text = it
                tvGameRemark.visibility = View.VISIBLE
            }
        })

        viewModel.gameVariants.observe(viewLifecycleOwner, {
            tvGameVariants.text = getString(R.string.variants_label, it)
        })

        viewModel.gameOnline.observe(viewLifecycleOwner, {
            tvGameOnline.text = getString(R.string.online_label, it)
        })
    }
}