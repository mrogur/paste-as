import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.ui.layout.panel
import java.awt.Dimension
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import javax.swing.JPanel
import javax.swing.JTextField

class PasteAsAction : AnAction() {

    override fun update(e: AnActionEvent) {
        val project: Project? = e.project
        e.presentation.isEnabledAndVisible = project != null
    }

    override fun actionPerformed(e: AnActionEvent) {
        val transferable = Toolkit.getDefaultToolkit().systemClipboard.getContents(null)
        val data = transferable.getTransferData(DataFlavor.stringFlavor)
        /*Messages.showDialog(
            e.project,
            data.toString(),
            "Hello",
            arrayOf("OK", "Cancel"),
            1,
            Messages.getInformationIcon()
        )*/

        val sampleDialogWrapper = SampleDialogWrapper()
//        sampleDialogWrapper.show();
        val userField = JTextField()
        val passwordField = JTextField()

        val panel = panel {
            noteRow("Specify text to replace.")
            row("Search:") { userField() }
            row("Replace:") { passwordField() }
        }



        val createComponentPopupBuilder =
            JBPopupFactory.getInstance().createComponentPopupBuilder(panel, userField)

        val popup = createComponentPopupBuilder.createPopup()
        popup.setMinimumSize(Dimension(500, 200))
//        popup.showCenteredInCurrentWindow(e.project!!)
        e.getData(PlatformDataKeys.EDITOR)?.let {
            popup.showInBestPositionFor(it)
        }


    }
}


