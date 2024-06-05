package todo_swing.common.fragment

import todo_swing.todo.view.TodoChart
import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.JLabel


/**
 * MainPage 화면 JFrame 클래스
 */
class MainPage : JFrame() {

    private val logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)
    private val todoChart = TodoChart()

    init {
        title = "Todo Swing"
        setSize(1000, 800)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        this.layout = BorderLayout()

        // 패널 등록
        jMenuBar = CustomMenu(todoChart)
        add(todoChart, BorderLayout.CENTER)
        add(JLabel("Made by Namju"), BorderLayout.SOUTH)

        isVisible = true
    }
}
