package com.pavel.myweather.ui.safeCity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pavel.myweather.R
import com.pavel.myweather.databinding.FragmentSafeCityBinding
import com.pavel.myweather.model.Safe
import com.pavel.myweather.ui.safeCity.adapter.SafeCityAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SafeCityCitiesFragment : Fragment() {

    private var binding: FragmentSafeCityBinding? = null
    private val viewModel: SafeCityCitiesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSafeCityBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listCity.observe(viewLifecycleOwner) {
            setList(it)
        }
        viewModel.loadSafeCity()

    }

    private fun setList(list: List<Safe>) {
        val args = Bundle()
        binding?.cityLikeRecyclerView?.run {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = SafeCityAdapter({ like ->
                    args.putString("city", like)
                    findNavController().navigate(
                        R.id.action_selectedCities_to_weatherForDayByCityFragment, args
                    )
                }, { delete ->
                    viewModel.deleteCity(delete)
                    findNavController().navigate(R.id.action_global_selectedCities)
                })
            }
            (adapter as? SafeCityAdapter)?.submitList(list)
        }

    }
}