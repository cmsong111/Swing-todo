package todo_swing

import todo_swing.common.fragment.LoadingPage
import todo_swing.common.fragment.MainPage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class TodoSwingApplication

fun main(args: Array<String>) {
    val loadingPage = LoadingPage()
    runApplication<TodoSwingApplication>(*args)
    loadingPage.dispose()

    MainPage()
}
