package todo_swing.common.github

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Github API로부터 받아온 커밋 정보
 */
data class Commit(

    @JsonProperty("sha") var sha: String? = null,
    @JsonProperty("url") var url: String? = null

) {
    override fun toString(): String {
        return "Commit(sha=$sha, url=$url)"
    }
}
