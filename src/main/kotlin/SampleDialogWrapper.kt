import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.layout.panel
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField


class SampleDialogWrapper : DialogWrapper(true) {
    override fun createCenterPanel(): JComponent? {
        val userField = JTextField()
        val passwordField = JTextField()

        return panel {
            noteRow("Specify text to replace.")
            row("Search:") { userField() }
            row("Replace:") { passwordField() }
        }
    }

    init {
        init()
        title = "Test DialogWrapper"
    }
}
