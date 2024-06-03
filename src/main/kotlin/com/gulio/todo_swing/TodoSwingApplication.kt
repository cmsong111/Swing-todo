package com.gulio.todo_swing

import com.gulio.todo_swing.view.LoadingPage
import com.gulio.todo_swing.view.MainPage
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
