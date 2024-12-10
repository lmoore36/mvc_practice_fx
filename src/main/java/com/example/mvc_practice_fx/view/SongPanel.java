package com.example.mvc_practice_fx.view;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SongPanel implements FXComponent {
    @Override
    public Parent render() {
        HBox layout = new HBox();

        // Title
        TextField titleInput = new TextField();
        layout.getChildren().add(new Label("Song:"));
        layout.getChildren().add(titleInput);

        // Artist
        TextField artistInput = new TextField();
        layout.getChildren().add(new Label("Artist:"));
        layout.getChildren().add(artistInput);

        // Rating
        Slider ratingSlider = new Slider(0, 5, 5);
        layout.getChildren().add(new Label("Rating:"));
        layout.getChildren().add(ratingSlider);

        // Add button
        Button addButton = new Button("\uff0b");
        layout.getChildren().add(addButton);

        return null;
    }
}
