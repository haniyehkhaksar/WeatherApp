package io.github.haniyehkhaksar.weatherapp

import io.github.haniyehkhaksar.weatherapp.ui.SharedViewModel
import io.github.haniyehkhaksar.weatherapp.ui.main.MainActivity
import io.github.haniyehkhaksar.weatherapp.utils.CoroutineTestRule
import io.github.haniyehkhaksar.weatherapp.utils.InstantExecutorExtension
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExperimentalCoroutinesApi
@ExtendWith(InstantExecutorExtension::class)
class SharedViewModelTest {

    private val mainActivity: MainActivity = mockk(relaxed = true)

    private lateinit var sharedViewModel: SharedViewModel

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @BeforeEach
    fun init() {
        sharedViewModel = SharedViewModel()
    }

    @AfterEach
    fun cleanup() {
        unmockkAll()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should set value for city`() {
        mainActivity.setCityValue("Calgary")
        assertThat(sharedViewModel.city.value).isEqualTo("Calgary")
    }

}