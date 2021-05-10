package io.github.haniyehkhaksar.weatherapp.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zephyrsleep.tablet.utils.EspressoIdlingResource
import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.NewsDomainModel
import io.github.haniyehkhaksar.weatherapp.domain.usecase.NewsUseCase
import io.github.haniyehkhaksar.weatherapp.utils.NonNullLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val newsUseCase: NewsUseCase) : ViewModel() {

    val isLoading: NonNullLiveData<Boolean> = NonNullLiveData(false)

    val news: NonNullLiveData<List<NewsDomainModel>> = NonNullLiveData(listOf())

    val newsAdapter = NewsAdapter(news.value.toMutableList())

    fun getNews(place: String) {
        //TODO show loading on screen
        EspressoIdlingResource.increment()
        isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            newsUseCase.execute(place, 20, 1).also { result ->
                when (result) {
                    is NewsUseCase.Result.Success -> {
                        news.postValue(result.data)
                    }

                    is NewsUseCase.Result.Error -> {
                        //TODO show error message on screen and make other views gone
                        news.postValue(listOf())
                    }
                }
                withContext(Dispatchers.Main) {
                    isLoading.value = false
                    newsAdapter.updateData(news.value.toMutableList())
                    EspressoIdlingResource.decrement()
                }
            }
        }
    }

}