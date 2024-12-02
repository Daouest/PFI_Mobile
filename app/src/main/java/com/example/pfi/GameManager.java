package com.example.pfi;


import android.media.Image;

import java.util.Map;

public class GameManager{
    private Player player1;
    private Player player2;
    private int round;
    private int player1Score;
    private int player2Score;
    private MovesEnum player1Move;
    private MovesEnum player2Move;
    private Image[] avatars;
    private int scoreToWinRound = 3;
    private Map<String, Image> avatarMap;
    private Map<String, Image> moveMap;
    private Player[] enemies;

    public GameManager(Player player1, int numberOfEnemies){
        this.player1 = player1;
        this.round = 0;
        InitializeEnemies(numberOfEnemies);
        AssignMoves();
        this.player1Score = 0;
        this.player2Score = 0;

    }

    private void AssignMoves(){
        this.avatars = new Image[3];
        this.avatars[0] = avatarMap.get("ROCK");
        this.avatars[1] = avatarMap.get("PAPER");
        this.avatars[2] = avatarMap.get("SCISSORS");
    }
    public void PlayRound(){
        this.round++;
        this.player1Move = player1.GetMove();
        this.player2Move = player2.GetMove();
        if(this.player1Move == this.player2Move){
            return;
        }
        if(this.player1Move == MovesEnum.ROCK){
            if(this.player2Move == MovesEnum.PAPER){
                player2Score++;
            }else{
                player1Score++;
            }
        }else if(this.player1Move == MovesEnum.PAPER){
            if(this.player2Move == MovesEnum.SCISSORS){
                player2Score++;
            }else{
                player1Score++;
            }
        }else{
            if(this.player2Move == MovesEnum.ROCK){
                player2Score++;
            }else{
                player1Score++;
            }
        }
    }

    private void InitializeEnemies(int numberOfEnemies){
        for(int i = 0; i < numberOfEnemies; i++){
            Player enemy = new Player("Enemy " + i, 0, getRandomImage());
            enemies[i] = enemy;
        }
    }
    public boolean IsRoundOver(){
        return player1Score >= scoreToWinRound || player2Score >= scoreToWinRound;
    }

    private Image getRandomImage(){
        return avatars[(int)(Math.random() * avatars.length)];
    }

    public void ChangeEnemy(int index){
        this.player2 = enemies[index];
    }
    public int GetPlayer1Score(){
        return this.player1Score;
    }

    public int GetPlayer2Score(){
        return this.player2Score;
    }

    public int GetRound(){
        return this.round;
    }
}