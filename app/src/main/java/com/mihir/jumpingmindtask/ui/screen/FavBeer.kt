package com.mihir.jumpingmindtask.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.GridLayoutManager
import com.mihir.jumpingmindtask.DATA
import com.mihir.jumpingmindtask.HAS_SEEN_LIKED_PROMPT
import com.mihir.jumpingmindtask.R
import com.mihir.jumpingmindtask.databinding.FragmentFavBeerBinding
import com.mihir.jumpingmindtask.model.BeerDataItem
import com.mihir.jumpingmindtask.ui.adapters.FavAdapter
import com.mihir.jumpingmindtask.viewmodel.FavViewModel
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetSequence
import uk.co.samuelwall.materialtaptargetprompt.extras.focals.CirclePromptFocal
import uk.co.samuelwall.materialtaptargetprompt.extras.focals.RectanglePromptFocal

class FavBeer : Fragment() {

    private val binding: FragmentFavBeerBinding by lazy { FragmentFavBeerBinding.inflate(layoutInflater) }

    private val viewModel : FavViewModel by lazy { ViewModelProvider(this)[FavViewModel::class.java] }

    private lateinit var adapter : FavAdapter
    private val prefManager by lazy { PreferenceManager.getDefaultSharedPreferences(requireContext())}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservables()
        binding.imageViewBack.setOnClickListener {
            findNavController().popBackStack()
        }

        adapter = FavAdapter {
            val args = bundleOf(DATA to it)
            findNavController().navigate(
                R.id.action_favBeer_to_beerDetails,
                args
            )
        }
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = GridLayoutManager(requireContext(),2)

        if (!prefManager.getBoolean(HAS_SEEN_LIKED_PROMPT,false)) {
            MaterialTapTargetSequence().apply {
                addPrompt(MaterialTapTargetPrompt.Builder(this@FavBeer)
                    .setTarget(binding.textViewHeading)
                    .setPrimaryText("Your Liked Beers")
                    .setPromptFocal(RectanglePromptFocal())
                    .setBackgroundColour(ContextCompat.getColor(requireContext(), R.color.teal_200))
                    .setSecondaryText("This is Where your Liked Beers are displayed")
                    .setPromptStateChangeListener { _, state ->
                        if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                            prefManager.edit().apply {
                                putBoolean(HAS_SEEN_LIKED_PROMPT, true)
                                    .apply()
                            }
                        }
                    }
                ).show()
            }
        }
    }

    private fun setObservables() {
        viewModel.readAllFavBeers.observe(viewLifecycleOwner){ likedBeerList ->
            if (likedBeerList.isEmpty()){
                binding.textViewNoFav.visibility = View.VISIBLE
            }else{
                adapter.setData(likedBeerList as ArrayList<BeerDataItem>)
            }
        }
    }

}