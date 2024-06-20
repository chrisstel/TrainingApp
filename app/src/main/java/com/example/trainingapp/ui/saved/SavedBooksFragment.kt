package com.example.trainingapp.ui.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingapp.databinding.FragmentSavedBooksBinding
import com.example.trainingapp.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SavedBooksFragment : Fragment() {

    private var _binding: FragmentSavedBooksBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSavedBooksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllBooks()
        setupRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        val savedBooksAdapter = SavedBooksAdapter()

        viewModel.bookList.observe(viewLifecycleOwner) {
            savedBooksAdapter.differ.submitList(it)
        }

        binding.recyclerViewSavedBooks.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = savedBooksAdapter
        }
    }
}