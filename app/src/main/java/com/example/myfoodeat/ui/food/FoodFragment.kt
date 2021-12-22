package com.example.myfoodeat.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodeat.R
import com.example.myfoodeat.adapter.ItemAdapter
import com.example.myfoodeat.data.loadJson
import com.example.myfoodeat.databinding.FragmentFoodBinding
import com.example.myfoodeat.model.MenuModel
import com.example.myfoodeat.singleton.OrderSingleton
import com.google.gson.Gson

class FoodFragment : Fragment() {
    private lateinit var foodViewModel: FoodViewModel
    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        foodViewModel =
            ViewModelProvider(this)[FoodViewModel::class.java]
        _binding = FragmentFoodBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuString = context?.let { loadJson(resources) }
        val menu = if (menuString?.isEmpty() == true) null else
            Gson().fromJson(menuString, MenuModel::class.java)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        fun onListItemClick(position: Int) {
            if (menu != null) {
                val ingredients = menu.menu.food[position].ingredients
                OrderSingleton.setIngredients(ingredients)
                findNavController().navigate(R.id.action_nav_food_to_nav_customize)
            }
        }

        val menuItemAdapter = menu?.let {
            ItemAdapter(
                this, "food", resources, it
            ) { position -> onListItemClick(position) }
        }

        recyclerView.adapter = menuItemAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}