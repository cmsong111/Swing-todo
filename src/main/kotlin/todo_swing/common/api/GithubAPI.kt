package todo_swing.common.api

import retrofit2.Call
import retrofit2.http.GET
import todo_swing.common.api.github.GithubTagResponse


/**
 * Github API 인터페이스
 */
interface GithubAPI {

    /**
     * Github API로부터 태그 정보를 받아오는 메소드
     */
    @GET("repos/cmsong111/Swing-todo/tags")
    fun getTags(): Call<List<GithubTagResponse>>
}
