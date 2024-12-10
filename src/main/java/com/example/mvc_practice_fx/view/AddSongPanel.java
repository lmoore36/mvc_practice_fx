package com.example.mvc_practice_fx.view;

import com.example.mvc_practice_fx.controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class AddSongPanel implements FXComponent {
    private Controller controller;
    private TextField titleInput;
    private TextField artistInput;
    private Slider ratingSlider;

    public AddSongPanel(Controller controller){
        this.controller = controller;
        this.titleInput = new TextField();
        this.artistInput = new TextField();
        this.ratingSlider = new Slider(0, 5, 0);
        this.ratingSlider.getStyleClass().add("add-song-slider");
    }


    @Override
    public Parent render() {
        Pane pane = new StackPane();

        Button addButton = new Button("Add Song");
        addButton.setOnAction((ActionEvent e) -> {
            String title = titleInput.getText();
            String artist = artistInput.getText();
            int rating = (int) ratingSlider.getValue();
            controller.addSong(title, artist, rating);
        });


        Button shuffleButton = new Button("Shuffle");
        shuffleButton.setOnAction((ActionEvent e) ->{
            controller.shuffle();
        });

        pane.getChildren().addAll(addButton, shuffleButton, titleInput, artistInput, ratingSlider);
        return pane;
    }
}
