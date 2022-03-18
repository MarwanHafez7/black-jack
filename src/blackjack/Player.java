/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Scanner;

/**
 *
 * @author usama
 */
public class Player {
    private String Name;
    private int Score;
    Card[] playercards=new Card[10];   

 
       private boolean blackjack=false;
     private boolean playerlost=false;

      public Player() {
       
    }

    public Player(String name, int score, boolean loseornot) {
        this.Name = name;
        this.Score = score;
        this.playerlost=loseornot;
    }

    public boolean isPlayerlost() {
        return playerlost;
    }

    public void setPlayerlost(boolean playerlost) {
        this.playerlost = playerlost;
    }
       public boolean isBlackjack() {
        return blackjack;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setScore(int score) {
        this.Score = score;
    }
    
    public String getName() {
        return Name;
    }

    public int getScore() {
        return Score;
    }
}
