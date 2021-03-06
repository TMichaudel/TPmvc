/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Modele.Segment;
import Modele.Tortue;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Iterator;

/**
 *
 * @author Thibaud
 */
public class VueTortue {
    protected Tortue tortue;
    static final int rp = 10, rb = 5;
    
    public VueTortue(Tortue tortue) {
		this.tortue = tortue;;
	}
    public Tortue getTortue() {
		return tortue;
	}
    
    public void reset(){
        tortue.reset();
    }
    
    public void drawTurtle(Graphics graph) {
        if (graph == null) {
            return;
        }

        // Dessine les segments
        for (Iterator it = tortue.getListSegments().iterator(); it.hasNext();) {
            Segment seg = (Segment) it.next();
            seg.drawSegment(graph);
        }

        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(tortue.getX(), tortue.getY());
        Polygon arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta = Tortue.getRatioDegRad() * (-tortue.getDir());
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
