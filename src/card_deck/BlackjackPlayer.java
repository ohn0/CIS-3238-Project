/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_deck;


/**
 *
 * @author Chris
 */
public class BlackjackPlayer {

    private int lastCard;
    public Hand hand;
    public Hand hand2;

    public BlackjackPlayer() {
        this.hand = new Hand();
        this.hand2 = new Hand(); 
    }

    public void draw(Hand h, Deck d) {
        int topOfDeck = d.cards.size() - 1;
        hand.cards.add((d.cards.remove(topOfDeck)));
        lastCard = getCardValue(h);
    }

    /*  if player's hand is less than 21, he may draw another card */
    public void hit(Hand h, Deck d) {
        //Check if player's hand < 21
        if (!bust(h)) {
            draw(h, d);
        }
    }

    /*  if player's hand is over 21 return true */
    public boolean bust(Hand h) {
        return h.handCount > 21;
    }

    /* get value of the newest card in your hand 
        and update handCount */
    private int getCardValue(Hand h) {
        int topOfHand = hand.cards.size() - 1;
        int numValue;
        Card c = hand.cards.get(topOfHand);
        String value = c.getValue();
        if (h.acesInHand > 0 && h.handCount > 21 && h.cards.size() < 12) {
            h.handCount -= 10;
        }
        switch (value) {
            case "ace":
                if (h.handCount > 11) {
                    numValue = 1;
                } else {
                    numValue = 11;
                }
                h.acesInHand++;
                break;
            case "jack":
                numValue = 10;
                break;
            case "queen":
                numValue = 10;
                break;
            case "king":
                numValue = 10;
                break;
            default:
                numValue = Integer.parseInt(c.getValue());
        }
        h.handCount += numValue;
        return numValue;
    }

    /*  Checks if the original 2 cards given have the same value
        If true, split into 2 hands */
    public void split() {
        if (hand.cards.size() == 2) {
            if (hand.cards.get(0).value.equals(hand.cards.get(1).value)) {
                hand2 = new Hand();
                hand2.cards.add((hand.cards.remove(1)));
                if (hand.acesInHand == 2) {
                    hand.handCount = hand2.handCount = 11;
                } else {
                    hand.handCount = hand2.handCount = hand.handCount / 2;
                }
            }
        }
    }
}
