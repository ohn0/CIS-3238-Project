/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualManager;

import card_deck.*;
import gameWindow.*;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class visualManager extends Thread{
    
    public visualManager(){
        
    }

    @Override
    public void run(){
        try {
            this.connect(new Gofish(new Deck()));
        } catch (InterruptedException ex) {
            Logger.getLogger(visualManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(visualManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
   
    public synchronized int connect(Gofish game) throws InterruptedException, IOException{
        GoFishWindow window = new GoFishWindow();
        window.linkWindow(game.AI, game.HUMAN);
        window.setVisible(true);
        int currentPlayerIndex = 0;
        game.dealCards();
        GofishPlayer human = game.HUMAN;
        GofishPlayer player = null;
        window.updatePlayerWindow(human);
        for(GofishPlayer p: game.AI){
            window.updateHandLabel(p);
        }
        while(!game.isOver()){
            if(currentPlayerIndex == 0){
                window.changeTextColor(Color.green);
                System.out.println("=================New Round Starting, there are " + 
                        game.cardsRemainingInPool() + " cards remaining to be drawn.=================");
                window.changeTextColor(Color.BLACK);
            }
            if(currentPlayerIndex == 3){
                System.out.println("It is your turn, choose a player and ask them for a card.");
                while (!window.valuesFound()){
                    Thread.sleep(500);
                }
                GofishPlayer AIplayer = window.getPlayerRequest();
                Card card = window.getCardRequest();
                System.out.println("Player has made a decision. They want to "
                        + "request a " + card.value + " from " + AIplayer.ID);
                window.nullifyValues();
                game.humanTurn(AIplayer, card);
                game.findBooksInHand(human);
                window.updatePlayerWindow(human);
            }else{
                game.executeAITurn(currentPlayerIndex);
                window.updateHandLabel(game.AI[currentPlayerIndex]);
            }
            if((player  = game.checkForWinner()) != null){
                System.out.println(player.ID + " has an empty hand. Game is over.");
                System.out.println("Checking for winner...");
                player = game.findWinner();
                System.out.println("The winner is " + player.ID + " who has a "
                        + "total of " + player.books.size()/2 + " books.");
                window.showWinner(player);
                
            }
            currentPlayerIndex = (currentPlayerIndex+1) % 4;
        }
        return 0;
    }

    public String getCardLocation(Card c) {
        String value = c.getValue();
        String suit = c.getSuit();
        int numValue, numSuit;
        numValue = numSuit = 0;
        switch (value) {
            case "ace":
                numValue = 1;
                break;
            case "jack":
                numValue = 11;
                break;
            case "queen":
                numValue = 12;
                break;
            case "king":
                numValue = 13;
                break;
            default:
                numValue = Integer.parseInt(c.getValue());
        }

        switch (suit) {
            case "clubs":
                numSuit = 1;
                break;
            case "spades":
                numSuit = 2;
                break;
            case "hearts":
                numSuit = 3;
                break;
            case "diamonds":
                numSuit = 4;
                break;
            default:
                break;
        }
        
        return "/images/" + ((13*(numSuit-1)) + numValue) + ".png" ;
    }

}
