package com.iacc.manuelroa_20240921.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iacc.manuelroa_20240921.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_conductores)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        homeViewModel.conductores.observe(viewLifecycleOwner) { conductores ->
            val adapter = ConductoresAdapter(conductores)
            recyclerView.adapter = adapter
        }
    }
}
