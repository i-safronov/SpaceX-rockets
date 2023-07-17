package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_launches

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.safronov.spacex_rockets.core.extension.logE
import com.safronov.spacex_rockets.databinding.FragmentRocketLaunchesBinding

class FragmentRocketLaunches : Fragment() {

    private var _binding: FragmentRocketLaunchesBinding? = null
    private val binding get() = _binding!!
    private var currentRocketId: String? = null
    private var currentRocketName: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRocketLaunchesBinding.inflate(inflater, container, false)
        try {
            initCurrentRocketInfo()
            bindView()
        } catch (e: Exception) {
            logE("${this.javaClass.name}, ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
        return binding.root
    }

    private fun initCurrentRocketInfo() {
        currentRocketId = requireArguments().getString(ROCKET_ID)
        currentRocketName = requireArguments().getString(ROCKET_NAME).toString()
    }

    private fun bindView() {
        binding.tvRocketName.text = currentRocketName.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            btnBackListener()
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

    private fun btnBackListener() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentRocketLaunches()
        const val ROCKET_ID = "Rocket ID"
        const val ROCKET_NAME = "Rocket name"
    }

}