package todo_swing.common.api.github

import com.fasterxml.jackson.annotation.JsonProperty


/**
 * GithubTagResponse
 *
 * Github API에서 Tag 정보를 받아오기 위한 데이터 클래스입니다.
 */
data class GithubTagResponse(
    @JsonProperty("name") var name: String? = null,
    @JsonProperty("zipball_url") var zipballUrl: String? = null,
    @JsonProperty("tarball_url") var tarballUrl: String? = null,
    @JsonProperty("commit") var commit: Commit? = Commit(),
    @JsonProperty("node_id") var nodeId: String? = null
) {
    override fun toString(): String {
        return "GithubTagResponse(name=$name, zipballUrl=$zipballUrl, tarballUrl=$tarballUrl, commit=$commit, nodeId=$nodeId)"
    }
}
