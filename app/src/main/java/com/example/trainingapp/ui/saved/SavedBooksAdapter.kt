package com.example.trainingapp.ui.saved

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingapp.databinding.ItemBookBinding
import com.example.trainingapp.domain.model.Book

class SavedBooksAdapter : RecyclerView.Adapter<SavedBooksAdapter.SavedBooksViewHolder>() {

    private val diffItemCallback = object : DiffUtil.ItemCallback<Book>() {

        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean = oldItem == newItem
    }
    val differ = AsyncListDiffer(this, diffItemCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedBooksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBookBinding.inflate(inflater, parent, false)

        return SavedBooksViewHolder(binding)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: SavedBooksViewHolder, position: Int) {
        val book = differ.currentList[position]

        holder.bind(book)
    }

    inner class SavedBooksViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            binding.apply {
                textViewBookAuthor.text = book.author
                textViewBookTitle.text = book.title
            }
        }
    }
}
