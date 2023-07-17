package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_launches.rcv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.safronov.domain.model.rocket_launch.RocketLaunch
import com.safronov.spacex_rockets.databinding.RcvItemRocketLaunchBinding

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
            holder.binding.tvDate.text = currentList[holder.adapterPosition].date_local
        }
    }

}