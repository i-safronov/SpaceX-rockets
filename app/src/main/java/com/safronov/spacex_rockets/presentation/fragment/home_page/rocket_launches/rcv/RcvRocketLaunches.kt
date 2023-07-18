package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_launches.rcv

import android.location.Geocoder.GeocodeListener
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.safronov.domain.model.rocket_launch.RocketLaunch
import com.safronov.spacex_rockets.R
import com.safronov.spacex_rockets.databinding.RcvItemRocketLaunchBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class RcvRocketLaunches() :
    ListAdapter<RocketLaunch, RcvRocketLaunches.RocketLaunchesViewHolder>(RcvRocketLaunches.RocketLaunchesDiffUtil()) {

    class RocketLaunchesViewHolder(
        val binding: RcvItemRocketLaunchBinding
    ) : RecyclerView.ViewHolder(binding.root)

    class RocketLaunchesDiffUtil() : DiffUtil.ItemCallback<RocketLaunch>() {
        override fun areItemsTheSame(oldItem: RocketLaunch, newItem: RocketLaunch): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RocketLaunch, newItem: RocketLaunch): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketLaunchesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RcvItemRocketLaunchBinding.inflate(inflater, parent, false)
        return RocketLaunchesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RocketLaunchesViewHolder, position: Int) {
        if (holder.adapterPosition != RecyclerView.NO_POSITION) {
            holder.binding.tvMissionName.text = currentList[holder.adapterPosition].name
            //TODO parse [date_local] into normal view for user
            holder.binding.tvDate.text =
                convertTimeToString(currentList[holder.adapterPosition].date_local)
            if (currentList[holder.adapterPosition].success) {
                Glide.with(holder.itemView.context).load(R.drawable.rocket_success)
                    .into(holder.binding.rocketIsSuccess)
            } else {
                Glide.with(holder.itemView.context).load(R.drawable.rocket_failure)
                    .into(holder.binding.rocketIsSuccess)
            }
        }
    }

    fun convertTimeToString(time: String): String {
        val result = java.lang.StringBuilder()
        for (i in time.indices) {
            if (time[i] == 'T') {
                break
            }
            result.append(time[i])
        }
        return result.toString()
    }

}