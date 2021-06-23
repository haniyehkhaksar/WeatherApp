package io.github.haniyehkhaksar.weatherapp.ui.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.WeatherDomainModel
import io.github.haniyehkhaksar.weatherapp.domain.usecase.CurrentWeatherUseCase
import io.github.haniyehkhaksar.weatherapp.domain.usecase.FutureWeatherUseCase
import io.github.haniyehkhaksar.weatherapp.utils.NonNullLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val currentWeatherUseCase: CurrentWeatherUseCase,
    private val futureWeatherUseCase: FutureWeatherUseCase
) : ViewModel() {

    val isLoading: NonNullLiveData<Boolean> = NonNullLiveData(false)

    val current: NonNullLiveData<WeatherDomainModel> = NonNullLiveData(
        WeatherDomainModel(
            "",
            0.0, 0.0, 0.0, ""
        )
    )

    val future: NonNullLiveData<List<WeatherDomainModel>> = NonNullLiveData(listOf())

    val weatherAdapter = WeatherAdapter(future.value.toMutableList())

    fun getCurrentWeather(place: String) {
        //TODO show loading on screen
        isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            currentWeatherUseCase.execute(place).also { result ->
                when (result) {
                    is CurrentWeatherUseCase.Result.Success -> {
                        current.postValue(result.data)
                    }

                    is CurrentWeatherUseCase.Result.Error -> {
                        current.postValue(WeatherDomainModel(place, 0.0, 0.0, 0.0, ""))
                        //TODO show error message on screen and make other views gone
                    }
                }
                withContext(Dispatchers.Main) {
                    isLoading.value = false
                }
            }
        }
    }

    fun getFutureWeather(place: String) {
        //TODO show loading on screen
        isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            futureWeatherUseCase.execute(place, 3).also { result ->
                when (result) {
                    is FutureWeatherUseCase.Result.Success -> {
                        future.postValue(result.data)
                    }

                    is FutureWeatherUseCase.Result.Error -> {
                        future.postValue(listOf())
                        //TODO show error message on screen and make other views gone
                    }
                }
                withContext(Dispatchers.Main) {
                    isLoading.value = false
                    weatherAdapter.updateData(future.value.toMutableList())
                }
            }
        }
    }

}