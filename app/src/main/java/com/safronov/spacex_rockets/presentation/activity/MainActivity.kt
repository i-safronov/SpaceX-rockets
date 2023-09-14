package com.safronov.spacex_rockets.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.safronov.data.repository.RocketSettingsRepositoryIntImpl
import com.safronov.domain.model.UnitOfMeasurementRocketDiameter
import com.safronov.domain.model.UnitOfMeasurementRocketHeight
import com.safronov.domain.model.UnitOfMeasurementRocketMass
import com.safronov.domain.model.UnitOfMeasurementRocketPayload
import com.safronov.domain.repository.RocketSettingsRepositoryInt
import com.safronov.spacex_rockets.R
import com.safronov.spacex_rockets.core.extension.logE
import com.safronov.spacex_rockets.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val rocketSettingsRepositoryInt: RocketSettingsRepositoryInt by inject<RocketSettingsRepositoryIntImpl>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}