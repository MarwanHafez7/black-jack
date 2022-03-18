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
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    static Game game = new Game();

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        GUI gui = new GUI();
        game.carddeck();
        game.setnameandrawcards();
        gui.runGUI(game.cards, game.players[0].playercards, game.players[1].playercards, game.players[2].playercards, game.players[3].playercards);
        for (int i = 0; i < 3; i++) {
            while (true) {
                int j = 0;
                int x;
                System.out.printf("player %d : for hit enter 1 and for stand 2 \n", i + 1);
                x = input.nextInt();
                if (x == 1 && game.players[i].isPlayerlost() == false && game.players[i].isBlackjack() == false) 
                {
                    game.players[i].playercards[j + 2] = game.drawcard();
                    gui.updatePlayerHand(game.players[i].playercards[j + 2], i);
                     int valueofcard = game.players[i].playercards[j + 2].getValue();
                    game.players[i].setScore(game.players[i].getScore() + valueofcard);
                    game.updatehighscore();
                    if (game.players[i].getScore() > 21) {
                        game.players[i].setPlayerlost(true);
                        System.out.printf("player %d : busts \n", i + 1);
                        break;
                    } else if (game.players[i].getScore() == 21) {
                        game.players[i].setBlackjack(true);
                        System.out.printf("player %d : got blackjack \n", i + 1);
                        game.updatehighscore();
                        break;
                    }
                   
                }
                else 
                {
                     game.updatehighscore();
                    break;
                }
                j++;
            }
        }

        while (game.players[3].isBlackjack() == false && game.players[3].isPlayerlost() == false && game.players[3].getScore()<=game.highscoreofallplayers)
        {
            int j = 0;
            game.players[3].playercards[j + 2] = game.drawcard();
            gui.updateDealerHand(game.players[3].playercards[j + 2], game.cards);
            int valueofcard = game.players[3].playercards[j + 2].getValue();
            game.players[3].setScore(game.players[3].getScore() + valueofcard);
            game.updatehighscore();

            if (game.players[3].getScore() > 21)
            {
                game.players[3].setPlayerlost(true);
                break;
            } else if (game.players[3].getScore() == 21) {
                game.players[3].setBlackjack(true);
                game.updatehighscore();
                break;
            }
            
         
            j++;
        }
        
       // System.out.printf("the winner is %s \n",game.thewinnerplayer.getName());
      
       
       
       
       Boolean flag = false,blackjack=false;
        int maxscore = 0, index = 0;
        for (int i = 0; i < 4; i++) {
            if (game.players[i].isBlackjack() == true) {
                System.out.printf("the winner is the player number %d \n", i + 1);
                blackjack=true;
              
            }
            if (game.players[i].isPlayerlost() == false && game.players[i].getScore() > maxscore && blackjack==false) {
                flag = true;
                maxscore = game.players[i].getScore();
                //System.out.printf("the high score %d \n",maxscore);
                index = i;
            }
            
        }
        if (flag == true) {
            System.out.printf("the winner is the player number %d \n", index + 1);

        } else if(flag==false && blackjack==false){
            System.out.printf("the game is PUSH \n");
        }

    }

}
