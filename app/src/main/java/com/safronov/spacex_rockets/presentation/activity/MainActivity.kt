package com.safronov.spacex_rockets.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.safronov.spacex_rockets.R
import com.safronov.spacex_rockets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}