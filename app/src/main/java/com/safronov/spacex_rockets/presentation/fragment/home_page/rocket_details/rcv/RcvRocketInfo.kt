package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details.rcv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.safronov.spacex_rockets.databinding.RcvItemRocketInfoBinding
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details.model.RocketInfo

class RcvRocketInfo(): ListAdapter<RocketInfo, RcvRocketInfo.RocketInfoViewHolder>(
    RocketInfoDiffUtil()
) {

    class RocketInfoViewHolder(
        val binding: RcvItemRocketInfoBinding
    ): RecyclerView.ViewHolder(binding.root)

    class RocketInfoDiffUtil(): DiffUtil.ItemCallback<RocketInfo>() {
        override fun areItemsTheSame(oldItem: RocketInfo, newItem: RocketInfo): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: RocketInfo, newItem: RocketInfo): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketInfoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RcvItemRocketInfoBinding.inflate(inflater, parent, false)
        return RocketInfoViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: RocketInfoViewHolder, position: Int) {
        if (holder.adapterPosition != RecyclerView.NO_POSITION) {
            holder.binding.title.text = currentList[holder.adapterPosition].title
            holder.binding.subTitle.text = currentList[holder.adapterPosition].subTitle
        }
    }

}