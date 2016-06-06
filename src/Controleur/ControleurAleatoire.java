package Controleur;

import Modele.Tortue;
import Vue.VueAleatoire;
import Vue.VueSuperTortue;
import Vue.VueTortue;
import java.awt.Dimension;
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
public class ControleurAleatoire {

    private static int NB_TORTUES = 10;
    private static int TPS_REFRESH = 500;
    private ArrayList<Tortue> tortues;
    private VueAleatoire vue;

    public ControleurAleatoire(VueAleatoire vue) {
        Tortue tortue;
        this.vue = vue;
        tortues = new ArrayList();
        for (int i = 0; i < NB_TORTUES; i++) {
            tortue = new Tortue();
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
        timer.schedule(new next(), 0, TPS_REFRESH);

    }
    
    public void avancerToroidal(Tortue tortue, int v) {
        int posX = tortue.getPosX();
        int posY = tortue.getPosY();
        int dir = tortue.getDir();
        Dimension size = this.vue.getFeuille().getSize();
        int newX = (int) Math.round(posX + v * Math.cos(dir*0.0174533));
        int newY = (int) Math.round(posY + v * Math.sin(dir*0.0174533));

        tortue.avancer(v);
        if (newX < 0) {
            tortue.setPosition(size.width + newX, newY);
        }
        if (newY < 0) {
            tortue.setPosition(newX, newY + size.height);
        }
        if (newX > size.width) {
            tortue.setPosition(newX - size.width, newY);
        }
        if (newY > size.height) {
            tortue.setPosition(newX, newY - size.height);
        }
    }
    
    public void tick() {
        for (Tortue tortue : tortues) {
            tortue.setDirection(ThreadLocalRandom.current().nextInt(0, 360));
            avancerToroidal(tortue, ThreadLocalRandom.current().nextInt(0, 50));
        }
    }
}
