/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameWindow;

import card_deck.Card;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Neel
 */
public class BookViewer extends javax.swing.JFrame {

    /**
     * Creates new form BookViewer
     */
    public BookViewer(ArrayList<Card> cards) {
        initComponents();
        this.add(new JLabel("hi"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(800, 600));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(10, 10, 1, 1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //how to add panels.
        this.add(new JLabel("hello"));
        this.pack();
    }//GEN-LAST:event_formMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
