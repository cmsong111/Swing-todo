package todo_swing.todo.view

import todo_swing.configuration.ApplicationContextProvider
import todo_swing.todo.entity.Todo
import todo_swing.todo.repository.TodoRepository
import todo_swing.common.fragment.RefreshController
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class TodoForm(
    private var controller: RefreshController
) : JFrame(), ActionListener {

    private val logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)

    private val repository: TodoRepository = ApplicationContextProvider.getBean("todoRepository") as TodoRepository

    private var titleJTextField: JTextField = JTextField("Title")
    private var descriptionJTextArea: JTextArea = JTextArea("Description")

    private var southPanel: JPanel = JPanel()
    private var summitButton: JButton = JButton("Summit")
    private var cancelButton: JButton = JButton("Cancel")


    private var todo: Todo = Todo()

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

    constructor(frame: RefreshController, idx: Long) : this(frame) {
        todo = repository.findById(idx).get()
        titleJTextField.text = todo.title
        descriptionJTextArea.text = todo.description
        summitButton.actionCommand = "Edit"
    }


    override fun actionPerformed(e: ActionEvent?) {
        if (e != null) {
            when (e.actionCommand) {
                "Summit" -> {
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

                "Edit" -> {
                    logger.info("edit")
                    logger.info("title: ${titleJTextField.text}")
                    logger.info("description: ${descriptionJTextArea.text}")

                    todo.title = titleJTextField.text
                    todo.description = descriptionJTextArea.text

                    repository.save(todo)
                    dispose()
                }

                "Cancel" -> {
                    logger.info("cancel")
                    dispose()
                }
            }
            controller.refresh()
        }
    }
}
