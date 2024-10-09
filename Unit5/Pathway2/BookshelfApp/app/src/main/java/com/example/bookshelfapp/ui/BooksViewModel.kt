package com.example.bookshelfapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelfapp.BookshelfApplication
import com.lalosapps.bookshelfapp.data.repository.BooksRepository
import com.lalosapps.bookshelfapp.ui.BooksUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BooksViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    private val _booksUiState = MutableStateFlow<BooksUiState>(BooksUiState.Loading)
    val booksUiState = _booksUiState.asStateFlow()

    init {
        getBooksImages()
    }

    fun getBooksImages(query: String = "miami") {
        if (query.isEmpty()) return
        viewModelScope.launch {
            _booksUiState.value = BooksUiState.Loading
            val result = booksRepository.getBooksImages(query)
            _booksUiState.value = result?.let {
                BooksUiState.Success(it)
            } ?: BooksUiState.Error
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookshelfApplication)
                val booksRepository = application.container.booksRepository
                BooksViewModel(booksRepository = booksRepository)
            }
        }
    }
}