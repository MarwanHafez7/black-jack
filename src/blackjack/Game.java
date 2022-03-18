/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author usama
 */
public class Game {
    Player players[]=new Player[4];
   // Player thewinnerplayer = new Player();
    Card cards[]= new Card[52];
    int highscoreofallplayers=0;
    public void carddeck ()
    {
        int counter=0;
      for (int i=0;i<4;i++)
    {
        
        for (int j=0;j<13;j++)
        {
        if (j>=9)
             cards[counter]= new Card(i,j,10);
        else
            cards[counter]= new Card(i,j,j+1);
        counter++;
        }
    }   
    }
    Card drawcard ()
    {
        while (true)
        {
        Random x= new Random();
        int y = x.nextInt(52);
        if (cards[y]!=null)
        {
        Card choosencard = new Card(cards[y]);
        //players[playerindex].setScore(cards[y].getValue()+ players[playerindex].getScore());
        cards[y]=null;
        return choosencard;
        
        }
        else
            continue;
    }
        
   }
    void setnameandrawcards ()
    {
        Scanner input = new Scanner(System.in);
        for (int i=0;i<3;i++)
        {
            System.out.printf("enter the name of the %d player \n",i+1); 
            String s=input.nextLine();
            players[i]=new Player(s,0,false);
            players[i].playercards[0]=drawcard();
            players[i].playercards[1]=drawcard();
            int sum = players[i].playercards[0].getValue()+players[i].playercards[1].getValue();
            players[i].setScore(sum);
            if (highscoreofallplayers<players[i].getScore()&& players[i].getScore()<=21)
            {
                highscoreofallplayers=players[i].getScore();
            }
            
        }
               
            players[3]=new Player("dealer",0,false);
            players[3].playercards[0]=drawcard();
            players[3].playercards[1]=drawcard();
            int sum = players[3].playercards[0].getValue()+players[3].playercards[1].getValue();
            players[3].setScore(sum);
       
        
    }
     void updatehighscore()
        {
                for (int i=0;i<4;i++)
                {
                    if (players[i].getScore()>highscoreofallplayers && players[i].getScore()<=21)
                    {
                        highscoreofallplayers=players[i].getScore();
                      //  thewinnerplayer=players[i];
                    }
                }
        }
    
    
}
