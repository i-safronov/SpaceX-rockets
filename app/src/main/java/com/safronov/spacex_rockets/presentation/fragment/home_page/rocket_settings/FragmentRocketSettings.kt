package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import com.safronov.spacex_rockets.R
import com.safronov.spacex_rockets.core.extension.logE
import com.safronov.spacex_rockets.core.extension.toastS
import com.safronov.spacex_rockets.databinding.FragmentRocketDetailsBinding
import com.safronov.spacex_rockets.databinding.FragmentRocketSettingsBinding

class FragmentRocketSettings : Fragment() {

    private var _binding: FragmentRocketSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRocketSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            tvCancelListener()
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object{}.javaClass.enclosingMethod?.name}")
        }
    }

    private fun tvCancelListener() {
        binding.tvCancel.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentRocketSettings()
    }

}