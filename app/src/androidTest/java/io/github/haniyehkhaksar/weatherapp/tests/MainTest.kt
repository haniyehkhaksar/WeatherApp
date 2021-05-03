package io.github.haniyehkhaksar.weatherapp.tests

import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.zephyrsleep.tablet.utils.EspressoIdlingResource
import io.github.haniyehkhaksar.weatherapp.R
import io.github.haniyehkhaksar.weatherapp.ui.main.MainActivity
import io.github.haniyehkhaksar.weatherapp.utils.RecyclerViewMatcher
import io.github.haniyehkhaksar.weatherapp.utils.TestApp
import io.github.haniyehkhaksar.weatherapp.utils.TestAppComponent
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@LargeTest
class MainTest {
    private val app: TestApp get() = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as TestApp

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Before
    fun beforeEach() {
        (app.appComponent as TestAppComponent).inject(this)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun afterTest() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun showNewsAfterSearchCity() {
        //click
        onView(withId(R.id.search)).perform(click())
        // Type the text in the search field and submit the query
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText("calgary"),
            pressImeActionButton()
        )

        onView(
            RecyclerViewMatcher(R.id.newsList).atPositionOnView(
                0,
                R.id.tvTitle
            )
        ).check(ViewAssertions.matches(ViewMatchers.withText("Title1")))

        onView(
            RecyclerViewMatcher(R.id.newsList).atPositionOnView(
                0,
                R.id.tvSource
            )
        ).check(ViewAssertions.matches(ViewMatchers.withText("By Source1")))

        onView(
            RecyclerViewMatcher(R.id.newsList).atPositionOnView(
                1,
                R.id.tvTitle
            )
        ).check(ViewAssertions.matches(ViewMatchers.withText("Title2")))

        onView(
            RecyclerViewMatcher(R.id.newsList).atPositionOnView(
                1,
                R.id.tvSource
            )
        ).check(ViewAssertions.matches(ViewMatchers.withText("By Source2")))

        onView(
            RecyclerViewMatcher(R.id.newsList).atPositionOnView(
                2,
                R.id.tvTitle
            )
        ).check(ViewAssertions.matches(ViewMatchers.withText("Title3")))

        onView(
            RecyclerViewMatcher(R.id.newsList).atPositionOnView(
                2,
                R.id.tvSource
            )
        ).check(ViewAssertions.matches(ViewMatchers.withText("By Source3")))

    }

    @Test
    fun showCurrentWeatherAfterSearchCity() {
        //click
        onView(withId(R.id.search)).perform(click())
        // Type the text in the search field and submit the query
        // Type the text in the search field and submit the query
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText("calgary"),
            pressImeActionButton()
        )

        onView(withId(R.id.cityName)).check(ViewAssertions.matches(withText("Calgary")))

        onView(withId(R.id.current_temp)).check(ViewAssertions.matches(withText("Current 12\u2103")))

        onView(withId(R.id.temp_max_min)).check(ViewAssertions.matches(withText("max 30\u2103 / min 10\u2103")))

    }

    @Test
    fun showFutureWeatherAfterSearchCity() {
        //click
        onView(withId(R.id.search)).perform(click())
        // Type the text in the search field and submit the query
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText("calgary"),
            pressImeActionButton()
        )

        onView(
            RecyclerViewMatcher(R.id.futureWeather).atPositionOnView(
                0,
                R.id.tvTempRange
            )
        ).check(ViewAssertions.matches(withText("6\u2103 / 4\u2103")))

        onView(
            RecyclerViewMatcher(R.id.futureWeather).atPositionOnView(
                1,
                R.id.tvTempRange
            )
        ).check(ViewAssertions.matches(ViewMatchers.withText("4\u2103 / 4\u2103")))

        onView(
            RecyclerViewMatcher(R.id.futureWeather).atPositionOnView(
                2,
                R.id.tvTempRange
            )
        ).check(ViewAssertions.matches(ViewMatchers.withText("3\u2103 / 3\u2103")))


    }
}