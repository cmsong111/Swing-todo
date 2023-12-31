package com.gulio.todo_swing.view.widget

import com.gulio.todo_swing.view.RefreshController
import com.gulio.todo_swing.view.TodoForm
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem
import kotlin.system.exitProcess


class CustomMenu(private var controller: RefreshController) : JMenuBar(), ActionListener {

    private val logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)

    private val todo = JMenu("Todo")
    private val newTodo = JMenuItem("New Todo")
    private val refresh = JMenuItem("Refresh")

    private val windows = JMenu("Windows")
    private val maximize = JMenuItem("Maximize")
    private val exit = JMenuItem("Exit")

    init {
        add(todo)
        add(windows)

        todo.add(newTodo)
        todo.add(refresh)

        windows.add(maximize)
        windows.add(exit)

        newTodo.addActionListener(this)
        refresh.addActionListener(this)
        maximize.addActionListener(this)
        exit.addActionListener(this)
    }

    override fun actionPerformed(e: ActionEvent?) {
        if (e != null) {
            when (e.source) {
                newTodo -> TodoForm(controller)
                refresh -> controller.refresh()
                maximize -> logger.info("maximize")
                exit -> exitProcess(0)
            }
        }
    }
}
