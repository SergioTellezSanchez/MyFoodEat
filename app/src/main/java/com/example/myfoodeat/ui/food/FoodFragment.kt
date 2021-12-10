package com.example.myfoodeat.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodeat.R
import com.example.myfoodeat.adapter.ItemAdapter
import com.example.myfoodeat.data.loadJson
import com.example.myfoodeat.databinding.FragmentFoodBinding
import com.example.myfoodeat.model.MenuModel
import com.google.gson.Gson

class FoodFragment : Fragment() {

    private lateinit var foodViewModel: FoodViewModel
    private var _binding: FragmentFoodBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        recyclerView.adapter = menu?.let { ItemAdapter(this, it, "food") }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}