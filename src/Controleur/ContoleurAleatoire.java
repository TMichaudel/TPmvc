package Controleur;

import Modele.Tortue;
import Vue.VueAleatoire;
import Vue.VueTortue;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thibaud
 */
public class ContoleurAleatoire {
    private static int NB_TORTUES = 10;
    private ArrayList<Tortue> tortues;
    private VueAleatoire vue;
    
    public ContoleurAleatoire(VueAleatoire vue) {
        this.vue = vue;
        for(int i=0;i<NB_TORTUES;i++) {
            Tortue tortue = new Tortue();
            tortue.setColor(ThreadLocalRandom.current().nextInt(0, 12));
            tortues.add(tortue);
            this.vue.getFeuille().addTortue(new VueTortue(tortue));
        }
    }
    
    public void tick () {
            for (Tortue tortue : tortues) { 
                tortue.setDirection(ThreadLocalRandom.current().nextInt(0, 360));
                tortue.avancer(ThreadLocalRandom.current().nextInt(0, 150));     
            }
    }
}
