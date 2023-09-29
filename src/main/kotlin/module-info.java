module to.grindelf.expertsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens to.grindelf.expertsystem to javafx.fxml;
    exports to.grindelf.expertsystem;
    exports to.grindelf.expertsystem.controllers;
    opens to.grindelf.expertsystem.controllers to javafx.fxml;
}