package io.github.haniyehkhaksar.weatherapp.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.junit.rules.ExternalResource
import kotlin.coroutines.CoroutineContext

/**
 * A rule that acts as a [CoroutineScope].
 *
 * The scope will be cancelled after every test method.
 *
 * See [CoroutineScopedViewModel] for more information on how [CoroutineScope] works.
 */
class CoroutineScopeTestRule : ExternalResource(), CoroutineScope {
    val job = Job()

    override val coroutineContext: CoroutineContext get() = job + Dispatchers.Default

    override fun after() {
        super.after()
        job.cancel()
    }

    suspend fun waitForAllChildCoroutines() = job.children.forEach { it.join() }
}
