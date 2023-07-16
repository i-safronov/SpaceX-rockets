package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.safronov.domain.model.UnitOfMeasurementRocketDiameter
import com.safronov.domain.model.UnitOfMeasurementRocketHeight
import com.safronov.domain.model.UnitOfMeasurementRocketMass
import com.safronov.domain.model.UnitOfMeasurementRocketPayload
import com.safronov.domain.model.rocket.Rocket
import com.safronov.spacex_rockets.R
import com.safronov.spacex_rockets.core.extension.logE
import com.safronov.spacex_rockets.databinding.FragmentRocketDetailsBinding
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details.model.RocketDetails
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details.model.RocketInfo
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details.rcv.RcvRocketDetails
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details.rcv.RcvRocketInfo
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details.view_model.FragmentRocketDetailsViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentRocketDetails : Fragment() {

    private var _binding: FragmentRocketDetailsBinding? = null
    private val binding get() = _binding!!
    private var currentRocket: Rocket? = null
    private val rcvRocketDetails = RcvRocketDetails()
    private val rcvRocketInfo = RcvRocketInfo()

    private val fragmentRocketDetailsViewModel by viewModel<FragmentRocketDetailsViewModel>()

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
        binding.rcvRocketInfo.layoutManager = LinearLayoutManager(requireContext())
        binding.rcvRocketInfo.adapter = rcvRocketInfo
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
            getListOfRocketDetailsFromRocket(rocket = rocket, result = {
                rcvRocketDetails.submitList(it)
            })
            bindRocketInfo(rocket = rocket)
        }
    }

    private fun bindRocketInfo(rocket: Rocket) {
        val list: List<RocketInfo> = getListOfRocketInfo(rocket)
        rcvRocketInfo.submitList(list)
    }

    private fun getListOfRocketInfo(rocket: Rocket): List<RocketInfo> {
        val ri1 = RocketInfo(title = rocket.first_flight, subTitle = getString(R.string.first_flight))
        val ri2 = RocketInfo(title = rocket.country, subTitle = getString(R.string.country))
        val ri3 = RocketInfo(title = "${rocket.cost_per_launch}$", subTitle = getString(R.string.cost_per_launch))
        return listOf(ri1, ri2, ri3)
    }

    private fun getListOfRocketDetailsFromRocket(rocket: Rocket, result: (List<RocketDetails>) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            val rcD1 = getRocketDetailsHeight(rocket = rocket)
            val rcD2 = getRocketDetailsDiameter(rocket = rocket)
            val rcD3 = getRocketDetailsMass(rocket = rocket)
            val rcD4 = getRocketDetailsPayload(rocket = rocket)
            result.invoke(listOf(rcD1, rcD2, rcD3, rcD4))
        }
    }

    private suspend fun getRocketDetailsHeight(rocket: Rocket): RocketDetails {
        val height = fragmentRocketDetailsViewModel.getTypeRocketHeightMeasurement()
        var title = ""
        if (height.trim().toLowerCase() == UnitOfMeasurementRocketHeight.M.toString().trim().toLowerCase()) {
            title = rocket.height.meters.toString()
        } else if (height.trim().toLowerCase() == UnitOfMeasurementRocketHeight.FT.toString().trim().toLowerCase()) {
            title = rocket.height.feet.toString()
        }
        return RocketDetails(title = title, subTitle = "${getString(R.string.height)}, ${height.trim().toLowerCase()}")
    }

    private suspend fun getRocketDetailsDiameter(rocket: Rocket): RocketDetails {
        val diameter = fragmentRocketDetailsViewModel.getTypeRocketDiameterMeasurement()
        var title = ""
        if (diameter.trim().toLowerCase() == UnitOfMeasurementRocketDiameter.M.toString().trim().toLowerCase()) {
            title = rocket.diameter.meters.toString()
        } else if (diameter.trim().toLowerCase() == UnitOfMeasurementRocketDiameter.FT.toString().trim().toLowerCase()) {
            title = rocket.diameter.feet.toString()
        }
        return RocketDetails(title = title, subTitle = "${getString(R.string.diameter)}, ${diameter.trim().toLowerCase()}")
    }

    private suspend fun getRocketDetailsMass(rocket: Rocket): RocketDetails {
        val mass = fragmentRocketDetailsViewModel.getTypeRocketMassMeasurement()
        var title = ""
        if (mass.trim().toLowerCase() == UnitOfMeasurementRocketMass.KG.toString().trim().toLowerCase()) {
            title = rocket.mass.kg.toString()
        } else if (mass.trim().toLowerCase() == UnitOfMeasurementRocketMass.LB.toString().trim().toLowerCase()) {
            title = rocket.mass.lb.toString()
        }
        return RocketDetails(title = title, subTitle = "${getString(R.string.mass)}, ${mass.trim().toLowerCase()}")
    }

    private suspend fun getRocketDetailsPayload(rocket: Rocket): RocketDetails {
        val payload = fragmentRocketDetailsViewModel.getTypeRocketPayloadMeasurement()
        var title = ""
        if (payload.trim().toLowerCase() == UnitOfMeasurementRocketPayload.KG.toString().trim().toLowerCase()) {
            title = rocket.payload_weights.first().kg.toString()
        } else if (payload.trim().toLowerCase() == UnitOfMeasurementRocketPayload.LB.toString().trim().toLowerCase()) {
            title = rocket.payload_weights.first().lb.toString()
        }
        return RocketDetails(title = title, subTitle = "${getString(R.string.payload)}, ${payload.trim().toLowerCase()}")
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