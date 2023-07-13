package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details_view_pager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.safronov.domain.model.rocket.ListOfRockets
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details.FragmentRocketDetails

class RocketDetailsViewPager(
        fragment: Fragment, private val listOfRockets: ListOfRockets
): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return listOfRockets.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = FragmentRocketDetails.newInstance()
        fragment.arguments = Bundle().apply {
            putSerializable(FragmentRocketDetails.ROCKET, listOfRockets[position])
        }
        return fragment
    }

}