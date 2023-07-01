package com.danntrp.fixtures.fixtures.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.danntrp.fixtures.R
import com.danntrp.fixtures.databinding.FragmentFixturesBinding
import com.danntrp.fixtures.fixtures.core.Resource
import com.danntrp.fixtures.fixtures.ui.stateholder.FixtureViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FixturesFragment : Fragment(R.layout.fragment_fixtures) {

    private var _binding: FragmentFixturesBinding? = null
    private val binding get() = _binding!!
    private val fixtureViewModel: FixtureViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFixturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fixturesAdapter = FixturesAdapter()

        binding.fixturesRecycler.apply {
            adapter = fixturesAdapter
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(MarginItemDecorator(resources.getDimensionPixelSize(R.dimen.recycler_view_items_margin)))
        }

        fixtureViewModel.fixtures.observe(viewLifecycleOwner) {
            if (it is Resource.Success) fixturesAdapter.differ.submitList(it.data)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}