package com.example.mvc_practice_fx.controller;

public interface Controller {
    void shuffle();
    void deleteSong(int index);
    void moveSongUp(int index);
    void moveSongDown(int index);
    void addSong(String title, String artist, int rating);
}
