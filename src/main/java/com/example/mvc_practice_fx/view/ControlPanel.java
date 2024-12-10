package com.example.mvc_practice_fx.view;

import com.example.mvc_practice_fx.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class ControlPanel implements FXComponent {
    private Controller controller;

    public ControlPanel(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        Pane pane = new StackPane();
        pane.getStyleClass().add("controls-layout");
        // Add other UI components to the pane here
        return pane;
    }
}
