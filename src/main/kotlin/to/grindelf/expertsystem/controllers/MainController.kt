package to.grindelf.expertsystem.controllers

import javafx.fxml.FXML
import javafx.scene.control.Label

class MainController {

    companion object {

    }

    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private fun onHelloButtonClick() {
        welcomeText.text = "Welcome to JavaFX Application!"
    }
}