package todo_swing.common.github

import org.springframework.stereotype.Component
import todo_swing.common.api.Retrofit2Builder
import java.awt.Desktop
import java.net.URL

/**
 * 프로그램이 시작 될 때 버전을 체크하는 클래스
 */
@Component
class VersionCheck {

    init {
        Retrofit2Builder.githubAPI.getTags().execute().body()?.let {
            val latestVersion = it.first().name
            val currentVersion = this::class.java.`package`.implementationVersion

            if (latestVersion != currentVersion) {
                println("최신 버전이 아닙니다. 업데이트가 필요합니다.")
            }
        }
    }
}
