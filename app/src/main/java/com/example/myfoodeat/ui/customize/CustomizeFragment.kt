package com.example.myfoodeat.ui.customize

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodeat.BuildConfig
import com.example.myfoodeat.R
import com.example.myfoodeat.adapter.CustomizeAdapter
import com.example.myfoodeat.databinding.FragmentCustomizeBinding
import com.example.myfoodeat.model.IngredientsModel
import com.example.myfoodeat.singleton.OrderSingleton

class CustomizeMenuItemFragment : Fragment() {
    private lateinit var customizeViewModel: CustomizeViewModel
    private var _binding: FragmentCustomizeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        customizeViewModel = ViewModelProvider(this)[CustomizeViewModel::class.java]
        _binding = FragmentCustomizeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_customize)

        val itemSelected = customizeViewModel.itemSelected

        val identifier =
            resources.getIdentifier(itemSelected?.id, "drawable", BuildConfig.APPLICATION_ID)
        binding.customizeFoodImage.setImageResource(identifier)

        binding.customizeButton.setOnClickListener {
            if (itemSelected != null) {
                OrderSingleton.addToOrder(itemSelected)
            }
            findNavController().navigate(R.id.action_nav_customize_food_to_fragment_order)
        }

        val ingredients: ArrayList<IngredientsModel>? = customizeViewModel.ingredients

        val customizeAdapter = ingredients?.let {
            CustomizeAdapter(
                this, resources, it
            )
        }
        recyclerView.adapter = customizeAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}