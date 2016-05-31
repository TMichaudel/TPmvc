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

     // Taille de la pointe et de la base de la fleche
    private ArrayList<VueTortue> tortues; // la liste des tortues enregistrees

    public VueFeuilleDessin() {
        tortues = new ArrayList<>();
    }

    public void addTortue(VueTortue o) {
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
        for (VueTortue t : tortues) {
            t.drawTurtle(g);
        }
    }

}
