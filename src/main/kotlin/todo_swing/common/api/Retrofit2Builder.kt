package todo_swing.common.api

import retrofit2.converter.jackson.JacksonConverterFactory


/**
 * Retrofit2 빌더 클래스
 */
object Retrofit2Builder {

    private const val BASE_URL = "https://api.github.com/"

    private val retrofit = retrofit2.Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    /**
     * Github API 인터페이스 구현체
     */
    val githubAPI: GithubAPI = retrofit.create(GithubAPI::class.java)
}
