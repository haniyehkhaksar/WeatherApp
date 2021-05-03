package io.github.haniyehkhaksar.weatherapp.utils

import okhttp3.Request
import okio.Buffer
import okio.IOException

object TestUtils {

    fun bodyToString(request: Request): String {
        return try {
            val copy: Request = request.newBuilder().build()
            val buffer = Buffer()
            if (copy.body == null) return ""
            copy.body?.writeTo(buffer)
            buffer.readUtf8()
        } catch (e: IOException) {
            "did not work"
        }
    }
}
