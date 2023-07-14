package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_settings

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.safronov.domain.model.UnitOfMeasurementRocketHeight
import com.safronov.spacex_rockets.core.extension.logE
import com.safronov.spacex_rockets.core.extension.toastS
import com.safronov.spacex_rockets.databinding.FragmentRocketSettingsBinding
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_settings.view_model.FragmentRocketSettingsViewModel
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentRocketSettings : Fragment() {

    private var _binding: FragmentRocketSettingsBinding? = null
    private val binding get() = _binding!!

    private val fragmentRocketSettingsViewModel by viewModel<FragmentRocketSettingsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRocketSettingsBinding.inflate(inflater, container, false)
        try {
            initRadioButtons()
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
        return binding.root
    }

    private fun initRadioButtons() {
        viewLifecycleOwner.lifecycleScope.launch {
            val initButtonsHeight = async {
                initButtonsUnitOfMeasurementRocketHeight()
            }
            initButtonsHeight.await()
        }
    }

    private fun initButtonsUnitOfMeasurementRocketHeight() {
        fragmentRocketSettingsViewModel.getTypeRocketHeightMeasurement {
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                if (it == UnitOfMeasurementRocketHeight.M.toString()) {
                    _binding?.rButtonRocketHeightM?.isChecked = true
                } else if (it == UnitOfMeasurementRocketHeight.FT.toString()) {
                    _binding?.rButtonRocketHeightFt?.isChecked = true
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            unitOfMeasurementRocketHeightRadioButtonsListener()
            tvCancelListener()
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object{}.javaClass.enclosingMethod?.name}")
        }
    }

    private fun unitOfMeasurementRocketHeightRadioButtonsListener() {
        binding.radioGroup1.setOnCheckedChangeListener { radioGroup, id ->
            val button = requireActivity().findViewById<RadioButton>(id)
            if (button.text.toString().trim().toLowerCase() == UnitOfMeasurementRocketHeight.M.toString().toLowerCase()) {
                fragmentRocketSettingsViewModel.saveTypeRocketHeightMeasurement(UnitOfMeasurementRocketHeight.M)
            } else if (button.text.toString().trim().toLowerCase() == UnitOfMeasurementRocketHeight.FT.toString().toLowerCase()) {
                fragmentRocketSettingsViewModel.saveTypeRocketHeightMeasurement(UnitOfMeasurementRocketHeight.FT)
            }
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