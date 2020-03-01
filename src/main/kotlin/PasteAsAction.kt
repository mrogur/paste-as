import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.ui.layout.panel
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
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
        sampleDialogWrapper.show();

    }
}

