package com.example.android3dz1mvvm.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.navigation.fragment.findNavController
import com.example.android3dz1mvvm.databinding.FragmentFirstBinding
import com.example.android3dz1mvvm.model.FirstModel
import com.example.android3dz1mvvm.ui.adapters.FirstAdapter

@Suppress("CAST_NEVER_SUCCEEDS")
class FirstFragment : Fragment() {

    private var viewModel: FirstViewModel? = null
    private val listBook = mutableListOf<FirstModel>()
    private lateinit var binding: FragmentFirstBinding
    private var firstAdapter = FirstAdapter(listBook, this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FirstViewModel::class.java]
        initialize()
        setupObserve()
        setupListener()
    }

    private fun onItemClick(firstModel: FirstModel) {
        findNavController().navigate(FirstFragmentDirections.actionSecondFragmentToDetailFragment(
            firstModel.image,
            firstModel.name))
    }

    private fun initialize() {
        binding.recViewFirstFragment.adapter = firstAdapter
    }

    private fun setupObserve() {
        viewModel?.getListBook()?.observe(viewLifecycleOwner) { it ->
            firstAdapter.setupObserves(it as ArrayList<FirstModel>)
        }
    }

    private fun setupListener() {
        binding.btnOpen.setOnClickListener {

            binding.btnOpen.isInvisible = true
            binding.recViewFirstFragment.isInvisible = false

        }
    }
}


