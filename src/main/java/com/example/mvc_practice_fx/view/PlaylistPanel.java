package com.example.mvc_practice_fx.view;

import com.example.mvc_practice_fx.controller.Controller;
import com.example.mvc_practice_fx.model.Playlist;
import com.example.mvc_practice_fx.model.PlaylistImpl;
import com.example.mvc_practice_fx.model.Song;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class PlaylistPanel implements FXComponent {
    private List<SongView> songViews = new ArrayList<>();
    private Playlist playlist;
    private Controller controller;

    public PlaylistPanel(Playlist playlist, Controller controller) {
        this.playlist = playlist;
        this.controller = controller;

        for (int i = 0; i < playlist.getNumSongs(); i++) {
            Song song = playlist.getSong(i);
            SongView currentSongView = new SongView(song, controller, i);
            songViews.add(currentSongView);
        }
    }

    @Override
    public Parent render() {
        VBox container = new VBox();

        for (SongView songView : songViews) {
            container.getChildren().add(songView.render());
        }

        return container;
    }
}
