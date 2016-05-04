/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.VueFeuilleDessin;
import Modele.Tortue;
import Vue.Vue;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

/**
 *
 * @author mathieu
 */
public class Controleur implements ActionListener {

    private VueFeuilleDessin feuille;
    private Tortue courante;
    private Vue vue;

    /**
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Controleur control = new Controleur();
            }
        });

    }

    public Controleur() {
        vue = new Vue(this);
        vue.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox) {
            JComboBox cb = (JComboBox) e.getSource();
            int n = cb.getSelectedIndex();
            courante.setColor(n);
        } 
        else {
            String c = e.getActionCommand();

            // actions des boutons du haut
            if (c.equals("Avancer")) {
                System.out.println("command avancer");
                try {
                    int v = Integer.parseInt(vue.getInputValue());
                    courante.avancer(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
                }

            } else if (c.equals("Droite")) {
                try {
                    int v = Integer.parseInt(vue.getInputValue());
                    courante.droite(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
                }
            } else if (c.equals("Gauche")) {
                try {
                    int v = Integer.parseInt(vue.getInputValue());
                    courante.gauche(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
                }
            } else if (c.equals("Lever")) {
                courante.leverCrayon();
            } else if (c.equals("Baisser")) {
                courante.baisserCrayon();
            } // actions des boutons du bas
            else if (c.equals("Proc1")) {
                proc1();
            } else if (c.equals("Proc2")) {
                proc2();
            } else if (c.equals("Proc3")) {
                proc3();
            } else if (c.equals("Effacer")) {
                effacer();
            } else if (c.equals("Quitter")) {
                quitter();
            }

            feuille.repaint();
        }
    }

    /**
     * les procedures Logo qui combine plusieurs commandes..
     */
    public void proc1() {
        courante.carre();
    }

    public void proc2() {
        courante.poly(60, 8);
    }

    public void proc3() {
        courante.spiral(50, 40, 6);
    }

    // efface tout et reinitialise la feuille
    public void effacer() {
        feuille.reset();
        feuille.repaint();

        // Replace la tortue au centre
        Dimension size = feuille.getSize();
        courante.setPosition(size.width / 2, size.height / 2);
    }

    private void quitter() {
        System.exit(0);
    }
}
