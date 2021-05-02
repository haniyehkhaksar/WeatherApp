package io.github.haniyehkhaksar.weatherapp.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.NewsDomainModel
import io.github.haniyehkhaksar.weatherapp.domain.usecase.NewsUseCase
import io.github.haniyehkhaksar.weatherapp.utils.NonNullLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val newsUseCase: NewsUseCase) : ViewModel() {

    val isLoading: MutableLiveData<Boolean> = NonNullLiveData(false)

    val news: MutableLiveData<List<NewsDomainModel>> = NonNullLiveData(listOf())

    val newsAdapter = NewsAdapter(news.value!!.toMutableList())

    fun getNews(place: String) {
        isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            newsUseCase.execute(place, 20, 1).also { result ->
                when (result) {
                    is NewsUseCase.Result.Success -> {
                        news.postValue(result.data)
                    }

                    is NewsUseCase.Result.Error -> {
                        news.postValue(listOf())
                    }
                }
                withContext(Dispatchers.Main) {
                    isLoading.value = false
                    newsAdapter.updateData(news.value!!.toMutableList())
                }
            }
        }
    }

}