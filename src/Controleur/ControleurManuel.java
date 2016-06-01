/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Tortue;
import Vue.VueFeuilleDessin;
import Vue.VueManuel;
import Vue.VueSuperTortue;
import Vue.VueTortue;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

/**
 *
 * @author mathieu
 */
public class ControleurManuel implements KeyListener, ActionListener{

    private Tortue courante;
    private VueManuel vue;


    public ControleurManuel(VueManuel vue) {
        this.vue = vue;
        Dimension size = this.vue.getFeuille().getSize();
        this.courante=new Tortue(size.width / 2, size.height / 2);
        this.vue.getFeuille().addTortue(new VueSuperTortue(courante));
        this.courante.addObserver(this.vue);
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
                try {
                    int v = Integer.parseInt(vue.getInputValue());
                    avancer(v);
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
            }
            // actions des boutons du bas
            if (c.equals("Proc1")) {
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
        }
    }
    
    public void avancer(int v){
        int posX = courante.getPosX();
        int posY = courante.getPosY();
        Dimension size = this.vue.getFeuille().getSize();
        int newX = (int) Math.round(posX + v );
        int newY = (int) Math.round(posY + v );
        if (newX > 0 && newY > 0 && newX < size.width && newY < size.height){
            courante.avancer(v);
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
        this.vue.getFeuille().reset();
        this.vue.getFeuille().repaint();

        // Replace la tortue au centre
        Dimension size = this.vue.getFeuille().getSize();
        courante.setPosition(size.width / 2, size.height / 2);
    }

    private void quitter() {
        System.exit(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                try {
                    int v = Integer.parseInt(vue.getInputValue());
                    avancer(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
                }
                break;
            case KeyEvent.VK_RIGHT:
                try {
                    int v = Integer.parseInt(vue.getInputValue());
                    courante.droite(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
                }
                break;
            case KeyEvent.VK_LEFT:
                try {
                    int v = Integer.parseInt(vue.getInputValue());
                    courante.gauche(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
                }
                break;
            case KeyEvent.VK_DOWN:
                if (courante.isCrayon()){
                    courante.leverCrayon();
                }
                else {
                    courante.baisserCrayon();
                }   break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
}
