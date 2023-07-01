package com.danntrp.fixtures.fixtures.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.danntrp.fixtures.R
import com.danntrp.fixtures.databinding.FixtureItemBinding
import com.danntrp.fixtures.fixtures.domain.model.Fixture

class FixturesAdapter : RecyclerView.Adapter<FixturesAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: FixtureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(fixture: Fixture) {
            binding.apply {
                textHomeTeamName.text = fixture.homeTeamName
                Glide.with(this.root).load(fixture.homeTeamBadge).into(imageHomeTeam)
                textMatchScore.text = String.format(
                    this.root.resources.getString(R.string.score),
                    fixture.homeTeamScore,
                    fixture.awayTeamScore
                )
                Glide.with(this.root).load(fixture.awayTeamBadge).into(imageAwayTeam)
                textAwayTeamName.text = fixture.awayTeamName
                textDate.text = fixture.matchDate
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Fixture>() {
        override fun areItemsTheSame(oldItem: Fixture, newItem: Fixture) =
            oldItem.matchId == newItem.matchId

        override fun areContentsTheSame(oldItem: Fixture, newItem: Fixture) = oldItem == newItem
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FixtureItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fixture = differ.currentList[position]
        holder.bind(fixture)
    }
}