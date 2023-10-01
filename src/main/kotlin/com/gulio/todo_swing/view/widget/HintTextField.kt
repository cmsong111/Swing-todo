import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import javax.swing.JTextField

class HintTextField(private val hint: String) : JTextField(hint), FocusListener {

    private var showingHint: Boolean = true

    init {
        addFocusListener(this)
    }

    override fun focusGained(e: FocusEvent) {
        if (text.isEmpty()) {
            text = ""
            showingHint = false
        }
    }

    override fun focusLost(e: FocusEvent) {
        if (text.isEmpty()) {
            text = hint
            showingHint = true
        }
    }

    override fun getText(): String {
        return if (showingHint) "" else super.getText()
    }
}
