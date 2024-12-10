package com.example.mvc_practice_fx.view;

import com.example.mvc_practice_fx.controller.Controller;
import com.example.mvc_practice_fx.model.Song;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class SongView implements FXComponent {
    private Song song;
    private Controller controller;
    private int songIndex;

    public SongView(Song song, Controller controller, int songIndex) {
        this.song = song;
        this.controller = controller;
        this.songIndex = songIndex;
    }

    @Override
    public Parent render() {
        HBox container = new HBox();
        container.getStyleClass().add("song-layout");

        Button deleteButton = new Button("\u274C");
        deleteButton.setOnAction((ActionEvent e) -> {
            controller.deleteSong(this.songIndex);
        });

        Button upButton = new Button("\u25B2");
        upButton.setOnAction((ActionEvent e) -> {
            controller.moveSongUp(songIndex);
        });

        Button downButton = new Button("\u25BC");
        downButton.setOnAction((ActionEvent e) -> {
            controller.moveSongDown(songIndex);
        });

        Label songLabel = new Label(makeSongLabel());

        container.getChildren().addAll(deleteButton, upButton, downButton, songLabel);
        return container;
    }

    private String makeSongLabel() {
        String label = "";
        label += song.getTitle() + "by" + song.getArtist() + "(";

        for (int i=0; i<song.getRating(); i++) {
            label += "\u2605";
        }

        for (int i=song.getRating(); i<5; i++) {
            label += "\u2606";
        }

        label += ")";
        return label;
    }
}
