package com.example.mvc_practice_fx.view;

import com.example.mvc_practice_fx.controller.Controller;
import com.example.mvc_practice_fx.controller.ControllerImpl;
import com.example.mvc_practice_fx.model.Playlist;
import com.example.mvc_practice_fx.model.PlaylistImpl;
import com.example.mvc_practice_fx.model.Song;
import com.example.mvc_practice_fx.model.SongImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppLauncher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        // Model
        Song longLive = new SongImpl("Long Live", "Taylor Swift", 5);
        Song allTooWell = new SongImpl("All Too Well", "Taylor Swift", 5);
        Song hotToGo = new SongImpl("HOT TO GO!", "Chappell Roan", 5);

        PlaylistImpl playlist = new PlaylistImpl();

        playlist.addSong(longLive);
        playlist.addSong(allTooWell);
        playlist.addSong(hotToGo);

        // Controller
        Controller controller = new ControllerImpl(playlist);

        // View
        View view = new View(controller, playlist, stage);
        playlist.addObserver(view);
        PlaylistPanel playlistPanel = new PlaylistPanel(playlist, controller);
        ControlPanel controlPanel = new ControlPanel(controller);

        root.getChildren().add(controlPanel.render());
        root.getChildren().add(playlistPanel.render());

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/style/main.css").toExternalForm());

        stage.setTitle("Lucy's Music Library");
        stage.setScene(scene);
        stage.show();
    }
}
