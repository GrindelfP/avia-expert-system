package to.grindelf.expertsystem.controllers

import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import to.grindelf.expertsystem.domain.KnowledgeModel
import to.grindelf.expertsystem.solver.SolverUtility

/**
 * Controller for main window.
 */
class MainController {

    /**
     * Injects VBox from main view.
     */
    @FXML
    lateinit var vbox: VBox

    /**
     * Instantiates knowledge model.
     */
    private val knowledgeModel: KnowledgeModel = KnowledgeModel()

    /**
     * Initializes controller.
     */
    fun initialize() {
        val groupedEntries = knowledgeModel.entries.groupBy { it.objectName }

        groupedEntries.forEach { (objectName, entries) ->
            val label = Label(objectName)
            val comboBox = ComboBox<String>()
            comboBox.items.addAll(entries.filter { it.objectName == objectName }.map { it.property })
            comboBox.selectionModel.selectFirst()
            vbox.children.addAll(label, comboBox)
        }
    }

    /**
     * Defines controller's behavior when submit button is clicked.
     */
    @FXML
    fun handleSubmitButtonAction() {
        val selectedItems = vbox.children.filterIsInstance<ComboBox<*>>().map { comboBox ->
            comboBox.selectionModel.selectedItem as String
        }
        val selectedItemsIds = knowledgeModel.getPropertiesIds(selectedItems)
        val result = SolverUtility.solve(selectedItemsIds)
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = "Result"
        alert.headerText = null
        alert.contentText = result.value
        alert.showAndWait()
    }

    /**
     * Turns list of named properties into list of respective property ID's.
     */
    private fun KnowledgeModel.getPropertiesIds(properties: List<String>): List<String> {
        val propertiesIds: MutableList<String> = mutableListOf()
        properties.forEach { property ->
            entries.forEach { entry ->
                if (entry.property == property) {
                    propertiesIds.add(entry.propertyId)
                }
            }
        }

        return propertiesIds
    }
}