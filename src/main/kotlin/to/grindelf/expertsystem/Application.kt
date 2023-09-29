/*
                  _         ______                           _     _____              _
    /\           (_)       |  ____|                         | |   / ____|            | |
   /  \   __   __ _   __ _ | |__   __  __ _ __    ___  _ __ | |_ | (___   _   _  ___ | |_   ___  _ __ ___
  / /\ \  \ \ / /| | / _` ||  __|  \ \/ /| '_ \  / _ \| '__|| __| \___ \ | | | |/ __|| __| / _ \| '_ ` _ \
 / ____ \  \ V / | || (_| || |____  >  < | |_) ||  __/| |   | |_  ____) || |_| |\__ \| |_ |  __/| | | | | |
/_/    \_\  \_/  |_| \__,_||______|/_/\_\| .__/  \___||_|    \__||_____/  \__, ||___/ \__| \___||_| |_| |_|
                                         | |                               __/ |
                                         |_|                              |___/

AviaExpertSystem. Created by GrindelfP on 2023-09-27.
*/

package to.grindelf.expertsystem

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * Main object for launching the application.
 */
object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        Application.launch(ExpertSystem::class.java)
    }
}

/**
 * Main class for instantiating the application.
 */
class ExpertSystem : Application() {

    /**
     * Companion object for storing application constants, such as
     * application title, window width and height.
     */
    companion object {
        const val APP_TITLE: String = "Expert System"
        const val WINDOW_WIDTH: Double = 1000.0
        const val WINDOW_HEIGHT: Double = 750.0
    }

    /**
     * Overrides start method. It loads the main view and shows it.
     */
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(ExpertSystem::class.java.getResource("expert-view.fxml"))
        val scene = Scene(fxmlLoader.load(), WINDOW_WIDTH, WINDOW_HEIGHT)
        stage.title = APP_TITLE
        stage.scene = scene
        stage.show()
    }
}
