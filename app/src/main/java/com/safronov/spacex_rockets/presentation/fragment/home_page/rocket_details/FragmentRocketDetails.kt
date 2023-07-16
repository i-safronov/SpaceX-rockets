package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.safronov.domain.model.rocket.Rocket
import com.safronov.spacex_rockets.R
import com.safronov.spacex_rockets.core.extension.logE
import com.safronov.spacex_rockets.databinding.FragmentRocketDetailsBinding
import com.safronov.spacex_rockets.databinding.RcvRocketDetailBinding
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details.model.RocketDetails
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details.rcv.RcvRocketDetails
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_settings.FragmentRocketSettings
import com.squareup.picasso.Picasso

class FragmentRocketDetails : Fragment() {

    private var _binding: FragmentRocketDetailsBinding? = null
    private val binding get() = _binding!!
    private var currentRocket: Rocket? = null
    private val rcvRocketDetails = RcvRocketDetails()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRocketDetailsBinding.inflate(inflater, container, false)
        try {
            currentRocket = getArgsAsRocket()
            initRcv()
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
        return binding.root
    }

    private fun initRcv() {
        binding.rcvRocketDetails.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rcvRocketDetails.adapter = rcvRocketDetails
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
            rcvRocketDetails.submitList(getListOfRocketDetailsFromRocket(rocket = rocket))
        }
    }

    private fun getListOfRocketDetailsFromRocket(rocket: Rocket): List<RocketDetails> {
        //TODO Write code to get rocket instances depending on the choice of rocket units
        val height = rocket.height.feet
        val diameter = rocket.diameter.feet
        val mass = rocket.mass.lb
        val payload = rocket.payload_weights.get(0).lb
        val rcD1 = RocketDetails(
            title = height.toString(),
            subTitle = "Высота, ft"
        )
        val rcD2 = RocketDetails(
            title = diameter.toString(),
            subTitle = "Диаметр, ft"
        )
        val rcD3 = RocketDetails(
            title = mass.toString(),
            subTitle = "Масса, lb"
        )
        val rcD4 = RocketDetails(
            title = payload.toString(),
            subTitle = "Нагрузка, ft"
        )
        return listOf(rcD1, rcD2, rcD3, rcD4)
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