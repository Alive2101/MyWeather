package com.pavel.myweather.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pavel.myweather.R
import com.pavel.myweather.controller.NetworkController
import com.pavel.myweather.databinding.FragmentSearchBinding
import com.pavel.myweather.model.FindCity
import com.pavel.myweather.ui.search.adapter.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var binding: FragmentSearchBinding? = null
    private val viewModel: SearchViewModel by viewModels()

    @Inject
    lateinit var networkController: NetworkController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listCity.observe(viewLifecycleOwner) {
            setList(it)
        }
        viewModel.isNetworkConnected.observe(viewLifecycleOwner) {
            Log.e("network", it.toString())
            if (it) {
                binding?.findButton?.visibility = View.VISIBLE
                binding?.internetTextView?.visibility = View.GONE
            } else {
                binding?.findButton?.visibility = View.GONE
                binding?.internetTextView?.visibility = View.VISIBLE
            }
        }
        binding?.run {
            findButton.setOnClickListener {
                if (searchEditText.text?.isEmpty() == true) {
                    Toast.makeText(requireContext(), R.string.write_city, Toast.LENGTH_SHORT).show()
                } else if (searchEditText.length() > 2) {
                    viewModel.getCity(searchEditText.text.toString())
                } else {
                    Toast.makeText(
                        requireContext(),
                        R.string.enter,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun setList(list: List<FindCity>?) {
        val args = Bundle()
        binding?.recyclerView?.run {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = SearchAdapter { city ->
                    args.putString("city", city)
                    findNavController().navigate(
                        R.id.action_search_to_weatherForDayByCityFragment,
                        args
                    )
                }
            }
            (adapter as? SearchAdapter)?.submitList(list)
        }
    }
}