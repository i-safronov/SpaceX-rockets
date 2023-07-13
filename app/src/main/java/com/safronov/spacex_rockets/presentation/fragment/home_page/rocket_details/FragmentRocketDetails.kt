package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.safronov.domain.model.rocket.Rocket
import com.safronov.spacex_rockets.R
import com.safronov.spacex_rockets.core.extension.logE
import com.safronov.spacex_rockets.databinding.FragmentRocketDetailsBinding
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_settings.FragmentRocketSettings
import com.squareup.picasso.Picasso

class FragmentRocketDetails : Fragment() {

    private var _binding: FragmentRocketDetailsBinding? = null
    private val binding get() = _binding!!
    private var currentRocket: Rocket? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRocketDetailsBinding.inflate(inflater, container, false)
        try {
            currentRocket = getArgsAsRocket()
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
        return binding.root
    }

    private fun getArgsAsRocket(): Rocket? {
        return requireArguments().getSerializable(ROCKET) as Rocket?
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            bindView()
            imgSettingsListener()
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

    private fun imgSettingsListener() {
        binding.imgSettings.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentHomePage_to_fragmentRocketSettings)
        }
    }

    private fun bindView() {
        currentRocket?.let { rocket ->
            Picasso.get().load(rocket.flickr_images.firstOrNull()).into(binding.rocketImg)
            binding.tvRocketName.text = rocket.name
            binding.rcvRocketDetails
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentRocketDetails()
        const val ROCKET = "Rocket"
    }

}