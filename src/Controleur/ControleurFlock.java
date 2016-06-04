package Controleur;

import Modele.BancDeTortues;
import Modele.TortueIntelligente;
import Vue.VueFlock;
import Vue.VueSuperTortue;
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
public class ControleurFlock {

    private static int NB_TORTUES = 10;
    private ArrayList<TortueIntelligente> tortues;
    private VueFlock vue;

    public ControleurFlock(VueFlock vue) {
        TortueIntelligente tortue;
        this.vue = vue;
        tortues = new ArrayList();
        for (int i = 0; i < NB_TORTUES; i++) {
            tortue = new TortueIntelligente();
            tortue.setColor(ThreadLocalRandom.current().nextInt(0, 12));
            tortues.add(tortue);
            this.vue.getFeuille().addTortue(new VueSuperTortue(tortue));
            tortue.addObserver(this.vue);
        }
        
                class next extends TimerTask {

            public void run() {
                tick();
            }
        }

        Timer timer = new Timer();
        timer.schedule(new next(), 0, 500);

    }

    public void tick() {
        for (TortueIntelligente tortue : tortues) {
            //Todo
        }
    }
}
