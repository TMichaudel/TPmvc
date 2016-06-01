package Controleur;

import Modele.Tortue;
import Vue.VueAleatoire;
import Vue.VueSuperTortue;
import Vue.VueTortue;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
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
        Tortue tortue;
        this.vue = vue;
        tortues = new ArrayList();
        for (int i = 0; i < NB_TORTUES; i++) {
            tortue = new Tortue();
            tortue.setColor(ThreadLocalRandom.current().nextInt(0, 12));
            tortues.add(tortue);
            this.vue.getFeuille().addTortue(new VueTortue(tortue));
            tortue.addObserver(this.vue);
        }

        class next extends TimerTask {
            public void run() {
                tick();
            }
        }

        Timer timer = new Timer();
        timer.schedule(new next(), 0, 1000);

    }

    public void tick() {
        for (Tortue tortue : tortues) {
            tortue.setDirection(ThreadLocalRandom.current().nextInt(0, 360));
            tortue.avancer(ThreadLocalRandom.current().nextInt(0, 150));
        }
    }
}
