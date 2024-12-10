package com.example.mvc_practice_fx.model;

public interface Playlist extends Iterable<Song> {
    Song getSong(int index);
    void addSong(Song song);
    void removeSong(int index);
    void moveSong(int oldIndex, int newIndex);
    void shuffleSongs();

    // useful for shuffling
    int getNumSongs();

    // model is also a Subject
    void addObserver(PlaylistObserver observer);
    void removeObserver(PlaylistObserver observer);
}
