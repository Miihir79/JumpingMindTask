package com.mihir.jumpingmindtask.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.mihir.jumpingmindtask.DATA
import com.mihir.jumpingmindtask.HAS_SEEN_DETAILS_PROMPT
import com.mihir.jumpingmindtask.R
import com.mihir.jumpingmindtask.databinding.FragmentBeerDetailsBinding
import com.mihir.jumpingmindtask.model.BeerDataItem
import com.mihir.jumpingmindtask.ui.showToast
import com.mihir.jumpingmindtask.viewmodel.FavViewModel
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetSequence
import uk.co.samuelwall.materialtaptargetprompt.extras.focals.CirclePromptFocal

class BeerDetails : Fragment() {

    private val binding : FragmentBeerDetailsBinding by lazy { FragmentBeerDetailsBinding.inflate(layoutInflater) }

    private val viewModel : FavViewModel by lazy { ViewModelProvider(this)[FavViewModel::class.java] }
    private val prefManager by lazy { PreferenceManager.getDefaultSharedPreferences(requireContext())}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundleData = arguments?.getParcelable<BeerDataItem>(DATA)
        binding.beerItem = bundleData

        binding.imgLike.setOnClickListener {
            if (bundleData != null) {
                viewModel.addFav(bundleData)
                showToast("Saved!")
            }
        }

        binding.imageViewBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!prefManager.getBoolean(HAS_SEEN_DETAILS_PROMPT,false)) {
            MaterialTapTargetSequence().apply {
                addPrompt(
                    MaterialTapTargetPrompt.Builder(this@BeerDetails)
                    .setTarget(binding.imgViewbeer)
                    .setPrimaryText("Details of the Beer")
                    .setPromptFocal(CirclePromptFocal())
                    .setBackgroundColour(ContextCompat.getColor(requireContext(), R.color.teal_200))
                    .setSecondaryText("This is Where you will find details about the beers and will be able to like them")
                    .setPromptStateChangeListener { _, state ->
                        if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                            prefManager.edit().apply {
                                putBoolean(HAS_SEEN_DETAILS_PROMPT, true)
                                    .apply()
                            }
                        }
                    }
                )
                    .addPrompt(
                        MaterialTapTargetPrompt.Builder(this@BeerDetails)
                            .setTarget(binding.imgLike)
                            .setPrimaryText("Like the Beer")
                            .setPromptFocal(CirclePromptFocal())
                            .setBackgroundColour(ContextCompat.getColor(requireContext(), R.color.teal_200))
                            .setSecondaryText("Like what you see? By clicking this button You save the beer for future tasting!")
                    )
                    .show()

            }
        }
    }

}