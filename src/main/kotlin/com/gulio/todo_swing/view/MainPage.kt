package com.gulio.todo_swing.view

import com.gulio.todo_swing.configuration.ApplicationContextProvider
import com.gulio.todo_swing.entity.Todo
import com.gulio.todo_swing.repository.TodoRepository
import javax.swing.JFrame
import javax.swing.JLabel


class MainPage : JFrame() {

    private val repository: TodoRepository = ApplicationContextProvider.getBean("todoRepository") as TodoRepository

    var todo: Todo = repository.findById(1).get()

    var label = JLabel(todo.toString())


    init {
        title = "Todo Swing"
        setSize(1000, 300)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        val panel = javax.swing.JPanel()
        panel.add(label)

        contentPane = panel

        isVisible = true
    }


}
