package com.example.mvc_practice_fx.view;

import com.example.mvc_practice_fx.controller.Controller;
import com.example.mvc_practice_fx.model.Playlist;
import com.example.mvc_practice_fx.model.PlaylistImpl;
import com.example.mvc_practice_fx.model.PlaylistObserver;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View implements FXComponent, PlaylistObserver {
    Playlist model;
    Controller controller;
    Stage stage;

    public View (Controller controller, Playlist model, Stage stage) {
        this.controller = controller;
        this.model = model;
        this.stage = stage;
    }

    @Override
    public void update(PlaylistImpl model) {
        Scene scene = new Scene(render());
        stage.setScene(scene);

    }

    @Override
    public Parent render() {
        return null;
    }
}
