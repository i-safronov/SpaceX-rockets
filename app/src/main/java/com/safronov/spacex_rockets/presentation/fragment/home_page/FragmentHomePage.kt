package com.safronov.spacex_rockets.presentation.fragment.home_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.safronov.spacex_rockets.core.extension.logE
import com.safronov.spacex_rockets.databinding.FragmentHomePageBinding
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details_view_pager.RocketDetailsViewPager
import com.safronov.spacex_rockets.presentation.fragment.home_page.view_model.FragmentHomePageViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentHomePage : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    private val fragmentHomePageViewModel by viewModel<FragmentHomePageViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        try {
            fragmentHomePageViewModel.loadListOfRockets()
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object{}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            listOfRocketListener()
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

    private fun listOfRocketListener() {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            fragmentHomePageViewModel.listOfRocket.collect { listOfRockets ->
                if (listOfRockets != null && listOfRockets.isNotEmpty()) {
                    val rocketDetailsViewPager = RocketDetailsViewPager(fragment = this@FragmentHomePage, listOfRockets = listOfRockets)
                    binding.rocketDetailsViewPager.adapter = rocketDetailsViewPager
                    binding.rocketDetailsViewPagerIndicator.setViewPager(binding.rocketDetailsViewPager)
                    rocketDetailsViewPager.registerAdapterDataObserver(binding.rocketDetailsViewPagerIndicator.adapterDataObserver)
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentHomePage()
    }

}