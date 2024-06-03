package com.gulio.todo_swing.view.widget


import com.gulio.todo_swing.configuration.ApplicationContextProvider
import com.gulio.todo_swing.repository.TodoRepository
import com.gulio.todo_swing.view.RefreshController
import com.gulio.todo_swing.view.TodoForm
import java.awt.Component
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JMenuItem
import javax.swing.JPopupMenu

/**
 * CustomPopupMenu 클래스
 */
class CustomPopupMenu(
    private val controller: RefreshController
) : JPopupMenu(), MouseListener {

    private val repository: TodoRepository = ApplicationContextProvider.getBean("todoRepository") as TodoRepository


    private val logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)

    private val done = JMenuItem("done")
    private val edit = JMenuItem("edit")
    private val delete = JMenuItem("delete")

    private var idx: Long = 0

    init {
        add(done)
        add(edit)
        add(delete)

        done.addMouseListener(this)
        edit.addMouseListener(this)
        delete.addMouseListener(this)
    }

    fun show(invoker: Component?, x: Int, y: Int, idx: Long) {
        super.show(invoker, x, y)
        this.idx = idx
    }

    private fun checkPopupMenu(e: MouseEvent?) {
        if (e == null) return
        when (e.source) {
            done -> {
                logger.info("done")
                val todo = repository.findById(idx).get()
                todo.status = true
                repository.save(todo)
                controller.refresh()
            }

            edit -> {
                logger.info("edit")
                TodoForm(controller, idx)
            }

            delete -> {
                logger.info("delete")
                repository.deleteById(idx)
                controller.refresh()
            }
        }

    }

    override fun mouseClicked(e: MouseEvent?) {
        checkPopupMenu(e)
    }

    override fun mousePressed(e: MouseEvent?) {
        return
    }

    override fun mouseReleased(e: MouseEvent?) {
        checkPopupMenu(e)
    }

    override fun mouseEntered(e: MouseEvent?) {
        return
    }

    override fun mouseExited(e: MouseEvent?) {
        return
    }
}
