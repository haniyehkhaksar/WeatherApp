package io.github.haniyehkhaksar.weatherapp

import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.NewsDomainModel
import io.github.haniyehkhaksar.weatherapp.domain.usecase.NewsUseCase
import io.github.haniyehkhaksar.weatherapp.ui.news.NewsViewModel
import io.github.haniyehkhaksar.weatherapp.utils.CoroutineTestRule
import io.github.haniyehkhaksar.weatherapp.utils.InstantExecutorExtension
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.io.IOException

@ExperimentalCoroutinesApi
@ExtendWith(InstantExecutorExtension::class)
class NewsViewModelTest {

    private lateinit var newsViewModel: NewsViewModel
    private val newsUseCase: NewsUseCase = mockk(relaxed = true)

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @BeforeEach
    fun init() {
        MockKAnnotations.init(this)
        mockkStatic("retrofit2.KotlinExtensions")
        newsViewModel = NewsViewModel(newsUseCase)
    }

    @AfterEach
    fun cleanup() {
        unmockkAll()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should set new data after calling getNews`() {
        val result = NewsUseCase.Result.Success(
            listOf(
                NewsDomainModel("title1", "source1", "image1", "link1"),
                NewsDomainModel("title2", "source2", "image2", "link2"),
                NewsDomainModel("title3", "source3", "image3", "link3"),
                NewsDomainModel("title4", "source4", "image4", "link4"),
            )
        )
        coEvery { newsUseCase.execute(any(), any(), any()) } returns result
        newsViewModel.getNews("Calgary")
        Thread.sleep(1000)
        assertThat(newsViewModel.news.value!!.size).isEqualTo(4)


    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should set empty data after calling getNews with exception`() {
        val result = NewsUseCase.Result.Error(IOException("message"))
        coEvery { newsUseCase.execute("Calgary", 20, 1) } returns result
        newsViewModel.getNews("Calgary")
        Thread.sleep(1000)
        assertThat(newsViewModel.news.value!!.size).isEqualTo(0)
    }
}