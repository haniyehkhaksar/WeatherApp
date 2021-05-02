package io.github.haniyehkhaksar.weatherapp.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.WeatherDomainModel
import io.github.haniyehkhaksar.weatherapp.domain.usecase.CurrentWeatherUseCase
import io.github.haniyehkhaksar.weatherapp.domain.usecase.FutureWeatherUseCase
import io.github.haniyehkhaksar.weatherapp.utils.NonNullLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    private val currentWeatherUseCase: CurrentWeatherUseCase,
    private val futureWeatherUseCase: FutureWeatherUseCase
) : ViewModel() {

    val isLoading: MutableLiveData<Boolean> = NonNullLiveData(false)

    val current: MutableLiveData<WeatherDomainModel> = NonNullLiveData(
        WeatherDomainModel(
            "",
            0.0, 0.0, 0.0, ""
        )
    )

    val future: MutableLiveData<List<WeatherDomainModel>> = NonNullLiveData(listOf())

    val weatherAdapter = WeatherAdapter(future.value!!.toMutableList())

    fun getCurrentWeather(place: String) {
        isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            currentWeatherUseCase.execute(place).also { result ->
                when (result) {
                    is CurrentWeatherUseCase.Result.Success -> {
                        current.postValue(result.data)
                    }

                    is CurrentWeatherUseCase.Result.Error -> {
                        current.postValue(WeatherDomainModel(place, 0.0, 0.0, 0.0, ""))
                    }
                }
                withContext(Dispatchers.Main) {
                    isLoading.value = false
                }
            }
        }
    }

    fun getFutureWeather(place: String) {
        isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            futureWeatherUseCase.execute(place, 3).also { result ->
                when (result) {
                    is FutureWeatherUseCase.Result.Success -> {
                        future.postValue(result.data)
                    }

                    is FutureWeatherUseCase.Result.Error -> {
                        future.postValue(listOf())
                    }
                }
                withContext(Dispatchers.Main) {
                    isLoading.value = false
                    weatherAdapter.updateData(future.value!!.toMutableList())
                }
            }
        }
    }

}