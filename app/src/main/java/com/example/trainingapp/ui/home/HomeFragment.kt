package com.example.trainingapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.trainingapp.databinding.FragmentHomeBinding
import com.example.trainingapp.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupClickListeners() {
        binding.btnSaveBook.setOnClickListener {
            if (binding.ETBookAuthor.text.isNotEmpty() && binding.ETBookTitle.text.isNotEmpty()) {
                val bookAuthor = binding.ETBookAuthor.text.toString()
                val bookTitle = binding.ETBookTitle.text.toString()

                viewModel.saveBook(bookAuthor, bookTitle)

                binding.ETBookAuthor.text.clear()
                binding.ETBookTitle.text.clear()
            }
        }
    }
}