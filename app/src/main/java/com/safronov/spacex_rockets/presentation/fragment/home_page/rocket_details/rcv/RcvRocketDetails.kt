package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details.rcv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.safronov.spacex_rockets.databinding.RcvRocketDetailBinding
import com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details.model.RocketDetails

class RcvRocketDetails() : ListAdapter<RocketDetails, RcvRocketDetails.RocketDetailsViewHolder>(
    RocketDetailsDiffUtil()
) {

    class RocketDetailsViewHolder(
        val binding: RcvRocketDetailBinding
    ) : RecyclerView.ViewHolder(binding.root)

    class RocketDetailsDiffUtil() : DiffUtil.ItemCallback<RocketDetails>() {
        override fun areItemsTheSame(oldItem: RocketDetails, newItem: RocketDetails): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: RocketDetails, newItem: RocketDetails): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketDetailsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RcvRocketDetailBinding.inflate(inflater, parent, false)
        return RocketDetailsViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: RocketDetailsViewHolder, position: Int) {
        if (holder.adapterPosition != RecyclerView.NO_POSITION) {
            holder.binding.tvTitle.text = currentList[holder.adapterPosition].title
            holder.binding.tvSubTitle.text = currentList[holder.adapterPosition].subTitle
        }
    }

}