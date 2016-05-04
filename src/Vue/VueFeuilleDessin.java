package Vue;

// package logo;
import Modele.Segment;
import Modele.Tortue;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 * Titre : Logo Description : Un exemple de programme graphique utilisant la
 * celebre Tortue Logo Copyright : Copyright (c) 2000 Societe : LIRMM
 *
 * @author J. Ferber
 * @version 2.0
 */
public class VueFeuilleDessin extends JPanel {

    protected static final int rp = 10, rb = 5; // Taille de la pointe et de la base de la fleche
    private ArrayList<Tortue> tortues; // la liste des tortues enregistrees

    public VueFeuilleDessin() {
        tortues = new ArrayList<Tortue>();
    }

    public void addTortue(Tortue o) {
        tortues.add(o);
    }

    public void reset() {
        for (Iterator it = tortues.iterator(); it.hasNext();) {
            Tortue t = (Tortue) it.next();
            t.reset();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color c = g.getColor();

        Dimension dim = getSize();
        g.setColor(Color.white);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(c);

        showTurtles(g);
    }

    public void showTurtles(Graphics g) {
        for (Iterator it = tortues.iterator(); it.hasNext();) {
            Tortue t = (Tortue) it.next();
            drawTurtle(g, t);
        }
    }

    public void drawTurtle(Graphics graph, Tortue t) {
        if (graph == null) {
            return;
        }

        // Dessine les segments
        for (Iterator it = t.getListSegments().iterator(); it.hasNext();) {
            Segment seg = (Segment) it.next();
            seg.drawSegment(graph);
        }

        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(t.getX(), t.getY());
        Polygon arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta = Tortue.getRatioDegRad() * (-t.getDir());
        //Demi angle au sommet du triangle
        double alpha = Math.atan((float) rb / (float) rp);
        //Rayon de la fleche
        double r = Math.sqrt(rp * rp + rb * rb);
        //Sens de la fleche

        //Pointe
        Point p2 = new Point((int) Math.round(p.x + r * Math.cos(theta)),
                (int) Math.round(p.y - r * Math.sin(theta)));
        arrow.addPoint(p2.x, p2.y);
        arrow.addPoint((int) Math.round(p2.x - r * Math.cos(theta + alpha)),
                (int) Math.round(p2.y + r * Math.sin(theta + alpha)));

        //Base2
        arrow.addPoint((int) Math.round(p2.x - r * Math.cos(theta - alpha)),
                (int) Math.round(p2.y + r * Math.sin(theta - alpha)));

        arrow.addPoint(p2.x, p2.y);
        graph.setColor(Color.green);
        graph.fillPolygon(arrow);
    }

}
