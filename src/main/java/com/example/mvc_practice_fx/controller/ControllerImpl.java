package com.example.mvc_practice_fx.controller;

import com.example.mvc_practice_fx.model.Playlist;
import com.example.mvc_practice_fx.model.Song;
import com.example.mvc_practice_fx.model.SongImpl;

public class ControllerImpl implements Controller {
    private Playlist model;

    public ControllerImpl(Playlist playlist) {
        this.model = playlist;
    }

    @Override
    public void shuffle() {
        model.shuffleSongs();
    }

    @Override
    public void deleteSong(int index) {
        model.removeSong(index);
    }

    @Override
    public void moveSongUp(int index) {
        System.out.println("moveSongUp " + index);
        if (index == 0) {
            return;
        }
        Song song = model.getSong(index);
        model.moveSong(index, index + 1);
    }

    @Override
    public void moveSongDown(int index) {
        if (index == model.getNumSongs()-1) {
            return;
        }
        Song song = model.getSong(index);
        model.moveSong(index, index - 1);
    }

    @Override
    public void addSong(String title, String artist, int rating) {
        Song song = new SongImpl(title, artist, rating);
        model.addSong(song);

    }
}
