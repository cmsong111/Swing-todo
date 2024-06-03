package todo_swing.common.api

import retrofit2.converter.jackson.JacksonConverterFactory


object Retrofit2Builder {

    private const val BASE_URL = "https://api.github.com/"

    private val retrofit = retrofit2.Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(JacksonConverterFactory.create())
        .build()


    val githubAPI: GithubAPI = retrofit.create(GithubAPI::class.java)


}
