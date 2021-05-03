package io.github.haniyehkhaksar.weatherapp.utils

import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer

class LoggingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val messageBuilder = StringBuilder()
        val requestUrl = request.url.toString()
        messageBuilder.appendLine("${request.method} $requestUrl")
        val requestBuffer = Buffer()
        request.newBuilder().build().body?.writeTo(requestBuffer)
        val requestBody = requestBuffer.readUtf8()
        if (requestBody.isNotEmpty()) {
            messageBuilder.appendLine("Request Body: $requestBody")
        }
        return try {
            chain.proceed(request)
        } catch (e: Exception) {
            throw e
        }
    }

}