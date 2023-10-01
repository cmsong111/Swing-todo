package com.gulio.todo_swing.view

import com.gulio.todo_swing.configuration.ApplicationContextProvider
import com.gulio.todo_swing.entity.Todo
import com.gulio.todo_swing.repository.TodoRepository
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class CreatePage : JFrame(), ActionListener {

    private val logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)

    private val repository: TodoRepository = ApplicationContextProvider.getBean("todoRepository") as TodoRepository

    private var titleJTextField: JTextField = JTextField()
    private var descriptionJTextArea: JTextArea = JTextArea()

    private var southPanel: JPanel = JPanel()
    private var summitButton: JButton = JButton("Summit")
    private var cancelButton: JButton = JButton("Cancel")

    init {
        title = "Create"
        setSize(300, 300)
        setLocationRelativeTo(null)
        isVisible = true

        layout = BorderLayout()

        titleJTextField.preferredSize = Dimension(100, 50)

        add(titleJTextField, BorderLayout.NORTH)
        add(descriptionJTextArea, BorderLayout.CENTER)

        southPanel.layout = BorderLayout()
        southPanel.add(summitButton, BorderLayout.WEST)
        southPanel.add(cancelButton, BorderLayout.EAST)
        add(southPanel, BorderLayout.SOUTH)


        summitButton.addActionListener(this)
        cancelButton.addActionListener(this)
    }

    override fun actionPerformed(e: ActionEvent?) {
        if (e != null) {
            when (e.source) {
                summitButton -> {
                    logger.info("summit")
                    logger.info("title: ${titleJTextField.text}")
                    logger.info("description: ${descriptionJTextArea.text}")

                    repository.save(
                        Todo(
                            title = titleJTextField.text,
                            description = descriptionJTextArea.text
                        )
                    )
                    dispose()
                }

                cancelButton -> {
                    logger.info("cancel")
                    dispose()
                }
            }
        }
    }
}
