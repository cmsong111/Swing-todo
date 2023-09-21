package com.gulio.todo_swing.view

import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

class LoadingPage : JFrame() {

    var label = JLabel("Loading...")

    init {
        title = "Loading"
        setSize(300, 300)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        val panel = JPanel()
        panel.add(label)

        contentPane = panel

        isVisible = true
    }

    
}
