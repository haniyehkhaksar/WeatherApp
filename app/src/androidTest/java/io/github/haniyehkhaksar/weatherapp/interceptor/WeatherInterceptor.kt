package io.github.haniyehkhaksar.weatherapp.interceptor

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class WeatherInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.toString()

        val responseBuilder = Response.Builder().request(request)
            .protocol(Protocol.HTTP_1_0)
            .addHeader("content-type", "application/json")
            .message("mocked response for $url")

        return when {

            url.contains("data/2.5/weather") -> {
                val response: String =
                    "{\"coord\":{\"lon\":-114.0853,\"lat\":51.0501},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":285.15,\"feels_like\":285.15,\"temp_min\":283.15,\"temp_max\":303.15,\"pressure\":1019,\"humidity\":75},\"visibility\":10000,\"wind\":{\"speed\":2.06,\"deg\":270},\"clouds\":{\"all\":75},\"dt\":1620010148,\"sys\":{\"type\":1,\"id\":989,\"country\":\"CA\",\"sunrise\":1619957213,\"sunset\":1620010771},\"timezone\":-21600,\"id\":5913490,\"name\":\"Calgary\",\"cod\":200}"
                responseBuilder.code(200)
                    .body(response.toResponseBody("application/json".toMediaTypeOrNull()))
                    .build()
            }

            url.contains("data/2.5/forecast") -> {
                val response: String =
                    "{\"cod\":\"200\",\"message\":0,\"cnt\":3,\"list\":[{\"dt\":1620010800,\"main\":{\"temp\":277.46,\"feels_like\":277.46,\"temp_min\":277.46,\"temp_max\":279.99,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":898,\"humidity\":75,\"temp_kf\":-2.53},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":75},\"wind\":{\"speed\":0.65,\"deg\":2,\"gust\":2.23},\"visibility\":10000,\"pop\":0.33,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-05-03 03:00:00\"},{\"dt\":1620021600,\"main\":{\"temp\":277.6,\"feels_like\":277.6,\"temp_min\":277.6,\"temp_max\":277.87,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":898,\"humidity\":74,\"temp_kf\":-0.27},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":83},\"wind\":{\"speed\":0.65,\"deg\":219,\"gust\":1.16},\"visibility\":10000,\"pop\":0.28,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-05-03 06:00:00\"},{\"dt\":1620032400,\"main\":{\"temp\":276.81,\"feels_like\":276.81,\"temp_min\":276.49,\"temp_max\":276.81,\"pressure\":1020,\"sea_level\":1020,\"grnd_level\":898,\"humidity\":80,\"temp_kf\":0.32},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":86},\"wind\":{\"speed\":1.01,\"deg\":181,\"gust\":1.56},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-05-03 09:00:00\"}],\"city\":{\"id\":5913490,\"name\":\"Calgary\",\"coord\":{\"lat\":51.0501,\"lon\":-114.0853},\"country\":\"CA\",\"population\":1019942,\"timezone\":-21600,\"sunrise\":1619957213,\"sunset\":1620010771}}"
                responseBuilder.code(200)
                    .body(response.toResponseBody("application/json".toMediaTypeOrNull()))
                    .build()
            }

            else -> {
                chain.proceed(request)
            }
        }
    }
}
