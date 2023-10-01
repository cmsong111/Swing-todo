package com.gulio.todo_swing.view.widget

import com.gulio.todo_swing.configuration.ApplicationContextProvider
import com.gulio.todo_swing.repository.TodoRepository
import com.gulio.todo_swing.view.RefreshController
import com.gulio.todo_swing.view.TodoForm
import java.awt.Dimension
import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

class TodoChart() : JPanel(), RefreshController {
    // Spring Bean
    private val repository: TodoRepository = ApplicationContextProvider.getBean("todoRepository") as TodoRepository

    private val logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)

    // table model
    private val tableModel = object : DefaultTableModel(
        arrayOf("Idx", "title", "content", "is Done", "createdDate", "updatedDate"), 0
    ) {
        override fun isCellEditable(row: Int, column: Int): Boolean {
            return false
        }
    }

    // table
    private val jTable: JTable = JTable(tableModel)

    init {
        jTable.rowSelectionAllowed = true
        jTable.rowHeight = 30
        jTable.columnModel.getColumn(0).preferredWidth = 15

        for (todo in repository.findAll()) {
            logger.info(todo.toString())
            tableModel.addRow(
                arrayOf(
                    todo.id, todo.title, todo.description, todo.status, todo.createdAt, todo.updatedAt
                )
            )
        }
        jTable.model = tableModel
        jTable.addMouseListener(object : java.awt.event.MouseAdapter() {
            override fun mouseClicked(e: java.awt.event.MouseEvent) {
                if (e.clickCount == 2) {
                    val idx = jTable.getValueAt(jTable.selectedRow, 0) as Long
                    logger.info("idx: $idx")
                    TodoForm(this@TodoChart, idx)
                }
            }
        })

        jTable.preferredSize = Dimension(980, 800)
        add(jTable)
    }

    override fun refresh() {
        logger.info("refresh todo chart")
        tableModel.dataVector.removeAllElements()
        for (todo in repository.findAll()) {
            logger.info(todo.toString())
            tableModel.addRow(
                arrayOf(
                    todo.id, todo.title, todo.description, todo.status, todo.createdAt, todo.updatedAt
                )
            )
        }
    }
}
