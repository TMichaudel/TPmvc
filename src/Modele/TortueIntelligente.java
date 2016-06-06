package Modele;

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
public class TortueIntelligente extends Tortue {

    private static int DIST_VUE = 300;
    private static int ANGLE_VUE = 90;
    private int distVue;
    private int angleVue;
    private int vitesse;

    public TortueIntelligente(int posx, int posy, int vitesse, int direction) {
        super(posx, posy);
        distVue = DIST_VUE;
        angleVue = ANGLE_VUE;
        this.vitesse = vitesse;
        this.dir = direction;
    }

    public TortueIntelligente() {
        super(ThreadLocalRandom.current().nextInt(0, 400), ThreadLocalRandom.current().nextInt(0, 400));
        distVue = DIST_VUE;
        angleVue = ANGLE_VUE;
        vitesse = ThreadLocalRandom.current().nextInt(0, 100);
        dir = ThreadLocalRandom.current().nextInt(0, 360);

    }

    public int getDistVue() {
        return distVue;
    }

    public int getAngleVue() {
        return angleVue;
    }

    public int getVitesse() {
        return vitesse;
    }

    public boolean voit(TortueIntelligente tortueAVoir) {
        boolean enVue = false;
        double distance = Math.sqrt((this.x - tortueAVoir.x) * (this.x - tortueAVoir.x) + (this.y - tortueAVoir.y) * (this.y - tortueAVoir.y));
        if (this.distVue > distance || distance == 0) {
            int newX = tortueAVoir.x - this.x;
            int newY = tortueAVoir.y - this.y;
            double distance2 = Math.abs(newY);
            double angleRad = Math.cos(distance / distance2);
            int angle;
            if (newX < 0) {
                if (newY < 0) {
                    angle = 90 + (int) Math.round(angleRad * 180 / Math.PI);
                } else {
                    angle = 270 - (int) Math.round(angleRad * 180 / Math.PI);
                }
            } else {
                if (newY < 0) {
                    angle = 90 - (int) Math.round(angleRad * 180 / Math.PI);
                } else {
                    angle = 270 + (int) Math.round(angleRad * 180 / Math.PI);
                }
            }
            if ((angle < this.dir + this.angleVue / 2) && (angle > this.dir - this.angleVue / 2)) {
                enVue = true;
            }
        }
        return enVue;
    }

    public void regarderEnvirons(ArrayList<TortueIntelligente> tortues) {
        int somme = 0;
        int sommeAngle = 0;
        int sommeVitesse = 0;
        for (TortueIntelligente tortue : tortues) {
            if (voit(tortue)) {
                somme++;
                sommeAngle += tortue.getDir();
                sommeVitesse += tortue.getVitesse();
            }
            if (somme > 0) {
                this.dir = sommeAngle / somme;
                this.vitesse = sommeAngle / somme;
            } else {
                this.dir = ThreadLocalRandom.current().nextInt(0, 360);
                this.vitesse = ThreadLocalRandom.current().nextInt(0, 100);

            }
        }
    }
}
