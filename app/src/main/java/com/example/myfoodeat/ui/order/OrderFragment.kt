package com.example.myfoodeat.ui.order

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodeat.R
import com.example.myfoodeat.adapter.OrderAdapter
import com.example.myfoodeat.databinding.FragmentOrderBinding
import com.example.myfoodeat.singleton.OrderSingleton
import kotlinx.android.synthetic.main.fragment_order.*
import kotlinx.coroutines.*

class OrderFragment : Fragment() {

    private lateinit var orderViewModel: OrderViewModel
    private var _binding: FragmentOrderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        orderViewModel = ViewModelProvider(this)[OrderViewModel::class.java]
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_order)
        val order = OrderSingleton.order
        val orderItemAdapter = OrderAdapter(this, resources, order)
        val dialog = context?.let { Dialog(it) }
        val loadingImage = (R.layout.loading)
        val cookingTimeMillis: Int = (order.cookingTime * 200)

      fun loading() {
          this.lifecycleScope.launch(context = Dispatchers.Main) {
              dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
              dialog?.setContentView(loadingImage)
              dialog?.show()
              delay(cookingTimeMillis.toLong())
              dialog?.dismiss()
          }
      }

        binding.placeOrderButton.setOnClickListener {
            loading()
            findNavController().navigate(R.id.action_fragment_order_to_fragment_prepared_order)
        }

        order_total.text = context?.getString(R.string.order_total, order.total.toString())
        recyclerView.adapter = orderItemAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
