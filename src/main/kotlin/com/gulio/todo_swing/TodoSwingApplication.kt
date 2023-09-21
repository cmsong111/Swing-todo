package com.gulio.todo_swing

import com.gulio.todo_swing.view.LoadingPage
import com.gulio.todo_swing.view.MainPage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodoSwingApplication

fun main(args: Array<String>) {
    val loadingPage = LoadingPage()
    runApplication<TodoSwingApplication>(*args)
    loadingPage.dispose()

    MainPage()
}
