package io.github.haniyehkhaksar.weatherapp.interceptor

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class NewsInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.toString()

        val responseBuilder = Response.Builder().request(request)
            .protocol(Protocol.HTTP_1_0)
            .addHeader("content-type", "application/json")
            .message("mocked response for $url")

        return when {
            url.contains("v2/everything") -> {
                val response: String =
                    "{\"status\":\"ok\",\"totalResults\":3806,\"articles\":[{\"source\":{\"id\":null,\"name\":\"Source1\"},\"author\":\"Alanna Smith\",\"title\":\"Title1\",\"description\":\"<ol><li>Owners of Calgary cleaning business charged with human trafficking  Calgary Herald\\r\\n</li><li>Human trafficking charges laid against owners of Calgary cleaning company  CBC.ca\\r\\n</li><li>Calgary couple accused of exploiting temporary foreign workers hir…\",\"url\":\"https://calgaryherald.com/news/local-news/calgary-couple-charged-with-human-trafficking\",\"urlToImage\":\"https://smartcdn.prod.postmedia.digital/calgaryherald/wp-content/uploads/2021/04/8cfe-1-1.jpg\",\"publishedAt\":\"2021-04-13T20:17:44Z\",\"content\":\"Article content\\r\\nA Calgary couple has been charged with human trafficking after being accused of taking advantage of foreign nationals.\\r\\nThe Alberta RCMP federal policing Integrated Border Enforcemen… [+2386 chars]\"},{\"source\":{\"id\":null,\"name\":\"Source2\"},\"author\":\"Licia Corbella\",\"title\":\"Title2\",\"description\":\"<ol><li>Corbella: Nenshi's purple reign over Calgary was mixed but impactful  Calgary Herald\\r\\n</li><li>Nenshi bows out after 3 terms as Calgary mayor  CBC.ca\\r\\n</li><li>Calgary Mayor Naheed Nenshi won't seek re-election in October vote  CTV Toronto\\r\\n</li><li>M…\",\"url\":\"https://calgaryherald.com/news/local-news/corbella-nenshis-purple-reign-over-calgary-was-mixed-but-impactful\",\"urlToImage\":\"https://smartcdn.prod.postmedia.digital/calgaryherald/wp-content/uploads/2021/04/BS_FILE10192010123203AM20101018ELECTION_006_49163200.jpg\",\"publishedAt\":\"2021-04-07T11:05:23Z\",\"content\":\"Licia Corbella\\r\\nNaheed Nenshi poses for pictures with supporters as they watch the election results come in at a local bar in Calgary, Alberta, on Oct. 18, 2010. Photo by Mike Drew/Postmedia\\r\\nArticle… [+8054 chars]\"},{\"source\":{\"id\":null,\"name\":\"Source3\"},\"author\":\"Kevin Martin\",\"title\":\"Title3\",\"description\":\"<ol><li>Calgary killer Matthew de Grood should not have had privileges reduced, appeal court rules  Calgary Herald\\r\\n</li><li>Matthew de Grood granted additional freedoms ahead of potential transition to group home  CTV Toronto\\r\\n</li><li>Appeal Court restores …\",\"url\":\"https://calgaryherald.com/news/crime/calgary-killer-matthew-de-grood-should-not-have-had-privileged-reduced-say-appeal-court\",\"urlToImage\":\"https://smartcdn.prod.postmedia.digital/calgaryherald/wp-content/uploads/2019/10/de-grood99.jpg\",\"publishedAt\":\"2021-04-12T18:00:04Z\",\"content\":\"Article content\\r\\nAlbertas top court has restored privileges granted to killer Matthew de Grood that were rescinded last September by a mental-health board that could see him ultimately transitioned t… [+2612 chars]\"}]}"
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
