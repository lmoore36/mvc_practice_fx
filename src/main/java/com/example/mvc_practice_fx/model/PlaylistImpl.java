package com.example.mvc_practice_fx.model;

import java.util.*;

public class PlaylistImpl implements Playlist {
    private List<Song> playlist;
    private List<PlaylistObserver> observers;

    public PlaylistImpl() {
        this.playlist = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public PlaylistImpl(List<Song> songs) {
        this.playlist = new ArrayList<>(songs);
        this.observers = new ArrayList<>();
    }

    @Override
    public Song getSong(int index) {
        if (index < 0 || index >= playlist.size()) {
            throw new IllegalArgumentException();
        }
        return playlist.get(index);
    }

    @Override
    public void addSong(Song song) {
        playlist.add(song);
        notifyObservers();
    }

    @Override
    public void removeSong(int index) {
        if (index < 0 || index >= playlist.size()) {
            throw new IllegalArgumentException();
        }
        playlist.remove(index);
        notifyObservers();
    }

    @Override
    public void moveSong(int oldIndex, int newIndex) {
        Song songToMove = playlist.remove(oldIndex);
        playlist.add(newIndex, songToMove);
        notifyObservers();
    }

    @Override
    public void shuffleSongs() {
        Collections.shuffle(playlist);
        notifyObservers();
    }

    @Override
    public int getNumSongs() {
        return playlist.size();
    }

    @Override
    public void addObserver(PlaylistObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(PlaylistObserver observer) {
        observers.remove(observer);
    }

    @Override
    public Iterator<Song> iterator() {
        return playlist.iterator();
    }

    private void notifyObservers() {
        for (PlaylistObserver observer : observers) {
            observer.update(this);
        }
    }
}
