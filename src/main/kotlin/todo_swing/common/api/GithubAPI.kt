package todo_swing.common.api

import retrofit2.Call
import retrofit2.http.GET
import todo_swing.common.github.GithubTagResponse


interface GithubAPI {


    @GET("repos/cmsong111/Swing-todo/tags")
    fun getTags(): Call<List<GithubTagResponse>>
}
