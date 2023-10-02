module to.grindelf.expertsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.kotlin;

    opens to.grindelf.expertsystem to javafx.fxml;
    exports to.grindelf.expertsystem;
    exports to.grindelf.expertsystem.controllers;
    opens to.grindelf.expertsystem.controllers to javafx.fxml;

    exports to.grindelf.expertsystem.domain to com.fasterxml.jackson.databind, kotlin.reflect;
    opens to.grindelf.expertsystem.domain to com.fasterxml.jackson.databind;
}