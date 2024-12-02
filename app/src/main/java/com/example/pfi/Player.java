package com.example.pfi;

import android.media.Image;

public class Player {

    private int numberOfLife;
    private String name;
    private int score;
    private Image avatar;
    private MovesEnum move;

    public Player(String name, int score, Image avatar) {
        this.name = name;
        this.score = score;
        this.avatar = avatar;
        this.numberOfLife = 3;
    }

    public void SetMove(MovesEnum move) {
        move = move;
    }
    public MovesEnum GetMove() {
        return move;
    }

    public int GetLife() {
        return numberOfLife;
    }
}
