package com.example.mybookshelfapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    private val viewModel: BookViewModel by viewModels { BookViewModelFactory(BookRepository()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchInput = findViewById<EditText>(R.id.search_input)
        val searchButton = findViewById<Button>(R.id.search_button)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launchWhenStarted {
            viewModel.books.collect { books ->
                recyclerView.adapter = BookAdapter(books)
            }
        }

        searchButton.setOnClickListener {
            val query = searchInput.text.toString()
            viewModel.searchBooks(query)
        }
    }
}