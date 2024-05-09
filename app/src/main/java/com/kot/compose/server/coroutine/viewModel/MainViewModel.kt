package com.kot.compose.server.coroutine.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kot.compose.server.coroutine.repository.ArticleRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
  private val articleRepository = ArticleRepository()
  val articlesLiveData = MutableLiveData<String>()

  fun getArticle() {
    viewModelScope.launch {
      val article = articleRepository.getArticle()
      println(article)
    }
  }
}
