/*
 * ©2015 Joel Brisbin. All Rights Reserved.
 */

package com.example.user.joelscrappycrapsapp;

/**
 * Created by User on 9/8/2015.
 */
public class Craps {
    private int rollNumber;
    private int point;
    private int sum;
    private int wins;
    private int losses;
    public Craps(){
        this.rollNumber = 1;
        this.point = 0;
        this.sum = 0;
        this.wins = 0;
        this.losses = 0;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getRollNumber() {
        return rollNumber;
    }


    public String gameCheck(Die dice1, Die dice2){
        int r1 = dice1.getFace();
        int r2 = dice2.getFace();
        int sum = dice1.getFace() + dice2.getFace();
        if(rollNumber == 1){
            if(sum == 7 || sum == 11){
                wins++;
                return "Congratulations! You won because you rolled a " + sum + "!";
            }
            else if(sum == 2 || sum == 3 || sum == 12){
                losses++;
                return "Conglaturation! You are loser because you rolled a " + sum + "!";
            }
            else{
                point = sum;
                point++;
                return "You need to roll a " + point + " in order to win.";
            }
        }
        else{
            if(sum == 7){
                losses++;
                return "Conglaturation! You are loser because you rolled a " + sum + "!";
            }
            else if(sum == point){
                wins++;
                return "Congratulations! You won because you rolled a " + sum + "!";

            }
            else{
                point = sum;
                point++;
                return "You need to roll a " + point + " in order to win.";
            }
        }
    }

    public void resetGame(){
        this.rollNumber = 1;
        this.point = 0;
    }
}
