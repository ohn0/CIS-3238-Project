/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameWindow;

import javax.swing.JOptionPane;
import visualManager.visualManager;

/**
 *
 * @author tuf62546
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Go Fish");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goFishButton(evt);
            }
        });

        jButton2.setText("Blackjack");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blackjackButton(evt);
            }
        });

        jButton3.setText("gofish help");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addGap(77, 77, 77)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(112, 112, 112))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goFishButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goFishButton
        new Thread(new visualManager()).start();
        this.setVisible(false);
    }//GEN-LAST:event_goFishButton

    private void blackjackButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blackjackButton
        // Sets Blackjack window to true
        BlackjackMenu window = new BlackjackMenu();
        window.setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_blackjackButton

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String help = "You will play gofish against three computer opponents.\n"
                + "The game will start with each player being dealt 7 cards.\n"
                + "Each player has a hand a collection of books, their hand is\n"
                + "the current of cards that they have. Their book collection \n"
                + "is a collection of all the card pairs that they have found.\n"
                + "Each player's turn will consist of them asking another player\n"
                + "for a card value that the current player owns.\n"
                + "So if I have a 2 and a 5, I can ask the other players for 2s or 5s.\n"
                + "If the other player has a card with that matching value, they\n "
                + "must give it to me, if they don't have it, I draw from the deck\n"
                + "if it still exists. The game progresses as such until a player\n"
                + "no longer has any cards in their hand. The game then ends and the\n"
                + "player with the most books is the winner.\n"
                + "The top of the screen contains a section for each of the AI players.\n"
                + "Each AI section has an interact button and their current card count.\n"
                + "The interact button has 2 options, 'show books' and 'ask for a card'.\n"
                + "When it is your turn, you can click the 'interact' button for \n"
                + "an AI and ask them for a card, or view which books they have.\n"
                + "The center of the screen contains the log, this is where all \n"
                + "updates to the game will be displayed. You will be able to see\n"
                + "Which AI is requesting which card from which player and whether\n"
                + "they got a pair or not. Keep an eye on this to know what card to\n"
                + "ask for when it is your turn.\n"
                + "The bottom of the screen is your hand. These are the cards that\n"
                + "you have currently drawn. The button on the bottom right will\n"
                + "display all the books that you have collected.\n";
        JOptionPane.showMessageDialog(this, help);

    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
