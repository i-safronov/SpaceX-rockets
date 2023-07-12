package com.safronov.spacex_rockets.presentation.fragment.home_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.safronov.spacex_rockets.databinding.FragmentHomePageBinding
import com.safronov.spacex_rockets.presentation.fragment.home_page.view_model.FragmentHomePageViewModel
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
        return binding.root
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