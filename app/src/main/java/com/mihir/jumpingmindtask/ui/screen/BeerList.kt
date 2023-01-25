package com.mihir.jumpingmindtask.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.GridLayoutManager
import com.mihir.jumpingmindtask.DATA
import com.mihir.jumpingmindtask.HAS_SEEN_LIST_PROMPT
import com.mihir.jumpingmindtask.R
import com.mihir.jumpingmindtask.databinding.FragmentBeerListBinding
import com.mihir.jumpingmindtask.ui.adapters.BeerAdapter
import com.mihir.jumpingmindtask.viewmodel.ViewModel
import kotlinx.coroutines.flow.collectLatest
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetSequence
import uk.co.samuelwall.materialtaptargetprompt.extras.focals.CirclePromptFocal

class BeerList : Fragment() {

    private val binding : FragmentBeerListBinding by lazy { FragmentBeerListBinding.inflate(layoutInflater) }

    private val viewModel by lazy { ViewModelProvider(this)[ViewModel::class.java] }

    private lateinit var adapter : BeerAdapter
    private val prefManager by lazy { PreferenceManager.getDefaultSharedPreferences(requireContext())}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BeerAdapter {
            val args = bundleOf(DATA to it)
            findNavController().navigate(
                R.id.action_beerList_to_beerDetails,
                args
            )
        }
        setObservables()
        binding.rvBeer.adapter = adapter
        binding.rvBeer.layoutManager = GridLayoutManager(requireContext(),2)

        binding.imageViewLiked.setOnClickListener {
            findNavController().navigate(
                R.id.action_beerList_to_favBeer
            )
        }
        if (!prefManager.getBoolean(HAS_SEEN_LIST_PROMPT,false)){
            MaterialTapTargetSequence().apply {
                addPrompt(
                    MaterialTapTargetPrompt.Builder(this@BeerList)
                        .setTarget(binding.imageViewLiked)
                        .setPrimaryText("Liked Beers")
                        .setPromptFocal(CirclePromptFocal())
                        .setBackgroundColour(ContextCompat.getColor(requireContext(),R.color.teal_200))
                        .setSecondaryText("Clicking on this displays your liked Beers")
                        .setPromptStateChangeListener { _, state ->
                            if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                                prefManager.edit().apply {
                                    putBoolean(HAS_SEEN_LIST_PROMPT,true)
                                        .apply()
                                }
                            }
                        }
                )
            }.show()
        }
    }

    private fun setObservables() {
        lifecycleScope.launchWhenCreated {
            viewModel.beerData.collectLatest {
                adapter.submitData(it)
            }
        }
    }

}