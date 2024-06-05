package todo_swing.todo.view

import todo_swing.configuration.ApplicationContextProvider
import todo_swing.todo.repository.TodoRepository
import todo_swing.common.fragment.RefreshController
import org.slf4j.LoggerFactory
import todo_swing.common.fragment.CustomPopupMenu
import java.awt.GridLayout
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.text.SimpleDateFormat
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

/**
 * TodoChart 클래스
 *
 * @author Namju kim
 */
class TodoChart() : JPanel(), RefreshController {
    // Spring Bean
    private val repository: TodoRepository = ApplicationContextProvider.getBean("todoRepository") as TodoRepository

    private val logger = LoggerFactory.getLogger(this.javaClass)

    private val scrollPane = JScrollPane()

    private val popupMenu = CustomPopupMenu(this@TodoChart)

    private val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("yyyy년 MM월 dd일 HH시mm분")

    // table model
    private val tableModel: DefaultTableModel = object : DefaultTableModel(
        arrayOf("Idx", "title", "content", "is Done", "createdDate", "updatedDate"), 0
    ) {
        override fun isCellEditable(row: Int, column: Int): Boolean {
            return false
        }

        // get column class
        // 3번째 컬럼은 checkbox 이므로 Boolean 타입으로 지정
        override fun getColumnClass(columnIndex: Int): Class<*> {
            return when (columnIndex) {
                0 -> java.lang.Long::class.java
                1 -> String::class.java
                2 -> String::class.java
                3 -> Boolean::class.java
                4 -> String::class.java
                5 -> String::class.java
                else -> throw IllegalArgumentException("Invalid column index")
            }
        }

    }

    // table
    private val jTable: JTable = JTable(tableModel)

    init {
        layout = GridLayout(1, 1)
        jTable.rowSelectionAllowed = true
        jTable.rowHeight = 30
        jTable.getColumn("Idx").width = 5

        for (todo in repository.findAll()) {
            logger.info(todo.toString())
            tableModel.addRow(
                arrayOf(
                    todo.id,
                    todo.title,
                    todo.description,
                    todo.status,
                    simpleDateFormat.format(todo.createdAt),
                    simpleDateFormat.format(todo.updatedAt),
                )
            )
        }
        jTable.model = tableModel
        jTable.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent) {

                val row = jTable.rowAtPoint(e.point)
                val idx = jTable.getValueAt(row, 0) as Long

                if (e.clickCount == 2) {
                    logger.info("idx: $idx")
                    TodoForm(this@TodoChart, idx)
                } else if (e.button == 3) {
                    logger.info("right click :$idx")
                    popupMenu.show(this@TodoChart, e.x, e.y, idx)
                }
            }
        })
        scrollPane.setViewportView(jTable)
        add(scrollPane)
    }

    override fun refresh() {
        logger.info("refresh todo chart")
        tableModel.dataVector.removeAllElements()
        for (todo in repository.findAll()) {
            logger.info(todo.toString())
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
    }
}
