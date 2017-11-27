/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualManager;

import card_deck.*;
import gameWindow.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Neel Patel
 */
public class visualManager {

    private final int rows = 4;
    private final int cols = 13;
    private final int height = 98;
    private final int width = 73;


    public int connect(Gofish game) {
        GoFishWindow window = new GoFishWindow();
        window.setVisible(true);
//        if(window.activateButton()){
//            game.playGofish();
//            return game.getCurrentTurn();
//        }
        return Integer.MIN_VALUE;
    }

    public int getCardPosition(Card c) {
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
        return numValue * numSuit; 
    }

}
