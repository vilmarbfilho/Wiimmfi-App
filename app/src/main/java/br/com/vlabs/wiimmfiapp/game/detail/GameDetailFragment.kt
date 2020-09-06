package br.com.vlabs.wiimmfiapp.game.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.vlabs.wiimmfiapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameDetailFragment : Fragment() {

    private val viewModel: GameDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_game_detail, container, false)

}