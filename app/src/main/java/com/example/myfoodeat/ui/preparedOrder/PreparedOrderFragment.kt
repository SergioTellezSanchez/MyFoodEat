package com.example.myfoodeat.ui.preparedOrder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myfoodeat.databinding.FragmentPreparedOrderBinding

class PreparedOrderFragment : Fragment() {

    private lateinit var preparedOrderViewModel: PreparedOrderViewModel
    private var _binding: FragmentPreparedOrderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        preparedOrderViewModel = ViewModelProvider(this)[PreparedOrderViewModel::class.java]
        _binding = FragmentPreparedOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}