package com.example.myfoodeat.ui.drinks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodeat.R
import com.example.myfoodeat.adapter.ItemAdapter
import com.example.myfoodeat.data.loadJson
import com.example.myfoodeat.databinding.FragmentDrinksBinding
import com.example.myfoodeat.model.MenuModel
import com.example.myfoodeat.singleton.OrderSingleton
import com.google.gson.Gson

class DrinksFragment : Fragment() {

    private lateinit var drinksViewModel: DrinksViewModel
    private var _binding: FragmentDrinksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        drinksViewModel =
            ViewModelProvider(this)[DrinksViewModel::class.java]

        _binding = FragmentDrinksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuString = context?.let { loadJson(resources) }
        val menu = if (menuString?.isEmpty() == true) null else
            Gson().fromJson(menuString, MenuModel::class.java)
        val drinksMenu = menu?.menu?.filter { item -> item.type == "drink" }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        fun onListItemClick(position: Int) {
            if (menu != null) {
                drinksMenu?.get(position)?.let { it.selected = true }
                drinksMenu?.get(position)?.let { OrderSingleton.addToOrder(it) }
                Toast.makeText(
                    context, drinksMenu?.get(position)?.description + " added to your order",
                    Toast.LENGTH_SHORT
                ).show()
                findNavController().navigate(R.id.action_nav_drinks_to_fragment_order)
            }
        }

        val menuItemAdapter = drinksMenu?.let {
            ItemAdapter(
                this, resources, it
            ) { position -> onListItemClick(position) }
        }
        recyclerView.adapter = menuItemAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}