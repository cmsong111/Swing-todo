package com.gulio.todo_swing.view

import com.gulio.todo_swing.configuration.ApplicationContextProvider
import com.gulio.todo_swing.entity.Todo
import com.gulio.todo_swing.repository.TodoRepository
import com.gulio.todo_swing.view.widget.CustomMenu
import java.awt.BorderLayout
import javax.swing.JButton
import javax.swing.JCheckBox
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTable
import javax.swing.table.DefaultTableModel


class MainPage : JFrame() {

    private val logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)

    private val repository: TodoRepository = ApplicationContextProvider.getBean("todoRepository") as TodoRepository
    private val refreshButton : JButton = JButton("Refresh")

    private var todoList: List<Todo> = repository.findAll()

    // table model
    private val tableModel: DefaultTableModel = DefaultTableModel(
        arrayOf("Idx", "title", "content", "is Done", "createdDate", "updatedDate"), 0
    )

    // table
    private val jTable: JTable = JTable(tableModel)

    init {
        title = "Todo Swing"
        setSize(1000, 800)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        this.layout = BorderLayout()


        jTable.rowSelectionAllowed = true
        jTable.rowHeight = 30

        refreshTodoList()

        // 패널 등록
        jMenuBar = CustomMenu(this)

        add(jTable, BorderLayout.CENTER)
        add(refreshButton, BorderLayout.SOUTH)

        refreshButton.addActionListener {
            refreshTodoList()
        }


        isVisible = true
    }

    private fun refreshTodoList() {
        // table 초기화
        tableModel.dataVector.removeAllElements()

        todoList = repository.findAll()
        for (todo in todoList) {
            tableModel.addRow(
                arrayOf(
                    todo.id,
                    todo.title,
                    todo.description,
                    todo.status,
                    todo.createdAt,
                    todo.updatedAt
                )
            )
        }
        jTable.model = tableModel
    }

}
