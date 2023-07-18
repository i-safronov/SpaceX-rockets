package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_launches

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.safronov.spacex_rockets.core.extension.logE
import com.safronov.spacex_rockets.databinding.FragmentRocketLaunchesBinding
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_launches.rcv.RcvRocketLaunches
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentRocketLaunches : Fragment() {

    private var _binding: FragmentRocketLaunchesBinding? = null
    private val binding get() = _binding!!
    private var currentRocketId: String? = null
    private var currentRocketName: String? = null
    private val rcvRocketLaunches = RcvRocketLaunches()

    private val fragmentRocketLaunchesViewModel by viewModel<FragmentRocketLaunchesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRocketLaunchesBinding.inflate(inflater, container, false)
        try {
            showUserDataIsLoading()
            initRcv()
            initCurrentRocketInfo()
            fragmentRocketLaunchesViewModel.loadRocketLaunches(currentRocketId.toString(), noLaunches = {
                //TODO write code to show user that no launches!
            })
            bindView()
        } catch (e: Exception) {
            logE("${this.javaClass.name}, ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
        return binding.root
    }

    private fun initRcv() {
        binding.rcvRocketLaunches.layoutManager = LinearLayoutManager(requireContext())
        binding.rcvRocketLaunches.adapter = rcvRocketLaunches
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
            rocketLaunchesListener()
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

    private fun rocketLaunchesListener() {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            fragmentRocketLaunchesViewModel.rocketLaunches.collect {
                if (it != null) {
                    if (it.isNotEmpty()) {
                        rcvRocketLaunches.submitList(it)
                        showUserDataLoaded()
                    }
                }
            }
        }
    }

    private fun showUserDataIsLoading() {
        binding.rcvRocketLaunches.visibility = View.INVISIBLE
        binding.progress.visibility = View.VISIBLE
    }

    private fun showUserDataLoaded() {
        binding.rcvRocketLaunches.visibility = View.VISIBLE
        binding.progress.visibility = View.INVISIBLE
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