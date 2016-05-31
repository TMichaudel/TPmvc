package Modele;

// package logo;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 * ***********************************************************************
 *
 * Un petit Logo minimal qui devra etre ameliore par la suite
 *
 * Source originale : J. Ferber - 1999-2001
 *
 * Cours de DESS TNI - Montpellier II
 *
 * @version 2.0
 * @date 25/09/2001
 *
 *************************************************************************
 */
public class Tortue extends Observable {

    // Rapport radians/degres (pour la conversion)
    protected static final double ratioDegRad = 0.0174533;
    protected ArrayList<Segment> listSegments; // Trace de la tortue
    protected int x, y;
    protected int dir;
    protected boolean crayon;
    protected int coul;

    public void setColor(int n) {
        coul = n;
        setChanged();
        notifyObservers();
    }

    public int getColor() {
        return coul;
    }

    public Tortue() {
        listSegments = new ArrayList<Segment>();
        reset();
    }

    public ArrayList<Segment> getListSegments() {
        return listSegments;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDir() {
        return dir;
    }

    public boolean isCrayon() {
        return crayon;
    }

    public static double getRatioDegRad() {
        return ratioDegRad;
    }

    public int getCoul() {
        return coul;
    }

    public void reset() {
        x = 250;
        y = 250;
        dir = -90;
        coul = 0;
        crayon = true;
        listSegments.clear();
        setChanged();
        notifyObservers();
    }

    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
        setChanged();
        notifyObservers();
    }

    public void setDirection(int dir) {
        this.dir = dir;
        setChanged();
        notifyObservers();
    }

    protected Color decodeColor(int c) {
        switch (c) {
            case 0:
                return (Color.black);
            case 1:
                return (Color.blue);
            case 2:
                return (Color.cyan);
            case 3:
                return (Color.darkGray);
            case 4:
                return (Color.red);
            case 5:
                return (Color.green);
            case 6:
                return (Color.lightGray);
            case 7:
                return (Color.magenta);
            case 8:
                return (Color.orange);
            case 9:
                return (Color.gray);
            case 10:
                return (Color.pink);
            case 11:
                return (Color.yellow);
            default:
                return (Color.black);
        }
    }

    public void avancer(int dist) {
        int newX = (int) Math.round(x + dist * Math.cos(ratioDegRad * dir));
        int newY = (int) Math.round(y + dist * Math.sin(ratioDegRad * dir));

        if (crayon == true) {
            Segment seg = new Segment();

            seg.ptStart.x = x;
            seg.ptStart.y = y;
            seg.ptEnd.x = newX;
            seg.ptEnd.y = newY;
            seg.color = decodeColor(coul);

            listSegments.add(seg);
        }
        setPosition(newX, newY);
    }

    public void droite(int ang) {
        setDirection((dir + ang) % 360);
    }

    public void gauche(int ang) {
        setDirection((dir - ang) % 360);
    }

    public void baisserCrayon() {
        crayon = true;
        setChanged();
        notifyObservers();
    }

    public void leverCrayon() {
        crayon = false;
        setChanged();
        notifyObservers();
    }

    public void couleur(int n) {
        coul = n % 12;
        setChanged();
        notifyObservers();
    }

    public void couleurSuivante() {
        couleur(coul + 1);
    }

    /**
     * quelques classiques
     */
    public void carre() {
        for (int i = 0; i < 4; i++) {
            avancer(100);
            droite(90);
        }
    }

    public void poly(int n, int a) {
        for (int j = 0; j < a; j++) {
            avancer(n);
            droite(360 / a);
        }
    }

    public void spiral(int n, int k, int a) {
        for (int i = 0; i < k; i++) {
            couleur(coul + 1);
            avancer(n);
            droite(360 / a);
            n = n + 1;
        }
    }
}
