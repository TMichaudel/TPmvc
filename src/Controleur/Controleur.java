package Controleur;

import Vue.Vue;
import Vue.VueAleatoire;
import Vue.VueManuel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thibaud
 */
public class Controleur implements ActionListener {
    Vue vue;
    public Controleur (Vue vue) {
        this.vue=vue;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();
        if (c.equals("Manuela, la tortuga")) {
            VueManuel fenetre = new VueManuel();
            fenetre.setVisible(true);
        }
        
        else if (c.equals("Random, the turtles")) {
            VueAleatoire fenetre = new VueAleatoire();
            fenetre.setVisible(true);
       }
        vue.dispose();
    }
    
}
