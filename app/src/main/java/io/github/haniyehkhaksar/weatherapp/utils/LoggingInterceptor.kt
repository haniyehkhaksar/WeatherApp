package io.github.haniyehkhaksar.weatherapp.utils

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer
import retrofit2.HttpException

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
        val response = try {
            chain.proceed(request)
        } catch (e: HttpException) {
            val response = e.response()
            if (response != null) {
                messageBuilder.append(createResponseMessage(response.raw()))
            } else {
                messageBuilder.append("HTTP FAILED: $e")
            }
            logApiInfo(messageBuilder.toString())
            throw e
        } catch (e: Exception) {
            messageBuilder.append("HTTP FAILED: $e")
            logApiInfo(messageBuilder.toString())
            throw e
        }
        messageBuilder.append(createResponseMessage(response))
        logApiInfo(messageBuilder.toString())
        return response
    }

    private fun logApiInfo(message: String) {
        Log.d("Hani-api", message)
    }

    private fun createResponseMessage(response: Response): String {
        var responseMessage = "Status: ${response.code} ${response.message}"
        val responseBody = response.peekBody(1024).string()
        if (responseBody.isNotEmpty()) {
            responseMessage += "\nResponse Body: $responseBody"
        }
        return responseMessage
    }
}