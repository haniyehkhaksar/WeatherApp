package io.github.haniyehkhaksar.weatherapp

import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.WeatherDomainModel
import io.github.haniyehkhaksar.weatherapp.domain.usecase.CurrentWeatherUseCase
import io.github.haniyehkhaksar.weatherapp.domain.usecase.FutureWeatherUseCase
import io.github.haniyehkhaksar.weatherapp.ui.weather.WeatherViewModel
import io.github.haniyehkhaksar.weatherapp.utils.InstantExecutorExtension
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExperimentalCoroutinesApi
@ExtendWith(InstantExecutorExtension::class)
class WeatherViewModelTest {

    private lateinit var weatherViewModel: WeatherViewModel
    private val futureWeatherUseCase: FutureWeatherUseCase = mockk(relaxed = true)
    private val currentWeatherUseCase: CurrentWeatherUseCase = mockk(relaxed = true)

    @BeforeEach
    fun init() {
        weatherViewModel = WeatherViewModel(currentWeatherUseCase, futureWeatherUseCase)
    }

    @AfterEach
    fun cleanup() {
        unmockkAll()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should set new data after calling getCurrentWeather`() {
        val result = CurrentWeatherUseCase.Result.Success(
            WeatherDomainModel("city", 10.0, 11.0, 12.0, "icon")
        )
        coEvery { currentWeatherUseCase.execute("Calgary") } returns result
        weatherViewModel.getCurrentWeather("Calgary")
        Thread.sleep(1000)
        assertThat(weatherViewModel.current.value).isEqualTo(result.data)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should set empty data after calling getCurrentWeather with exception`() {
        val result = CurrentWeatherUseCase.Result.Error(Throwable("Exception"))
        coEvery { currentWeatherUseCase.execute("Calgary") } returns result
        weatherViewModel.getCurrentWeather("Calgary")
        Thread.sleep(1000)
        assertThat(weatherViewModel.current.value!!.currentTemp).isEqualTo(0.0)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should set new data after calling getFutureWeather`() {
        val result = FutureWeatherUseCase.Result.Success(
            listOf(
                WeatherDomainModel("city", 12.0, 14.0, 8.0, "icon1"),
                WeatherDomainModel("city", 13.0, 15.0, 9.0, "icon2"),
                WeatherDomainModel("city", 14.0, 16.0, 10.0, "icon3")
            )
        )
        coEvery { futureWeatherUseCase.execute("Calgary", 3) } returns result
        weatherViewModel.getFutureWeather("Calgary")
        Thread.sleep(1000)
        assertThat(weatherViewModel.future.value!!.size).isEqualTo(3)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should set empty data after calling getFutureWeather with exception`() {
        val result = FutureWeatherUseCase.Result.Error(Throwable("Exception"))
        coEvery { futureWeatherUseCase.execute("Calgary", 3) } returns result
        weatherViewModel.getFutureWeather("Calgary")
        Thread.sleep(1000)
        assertThat(weatherViewModel.future.value!!.size).isEqualTo(0)
    }
}