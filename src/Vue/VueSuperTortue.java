package Vue;

import Modele.Segment;
import Modele.Tortue;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thibaud
 */
public class VueSuperTortue extends VueTortue {

    public VueSuperTortue(Tortue tortue) {
        super(tortue);
    }
    

    public static Point rotatePoint(Point pt, Point center, double angleDeg) {
        double angleRad = Math.toRadians(angleDeg);
        double cosThetha = Math.cos(angleRad); //The angle COS
        double sinThetha = Math.sin(angleRad); //The angle SIN
        double dx = (pt.x - center.x); //Difference (Point in transformed to origo)
        double dy = (pt.y - center.y); //Difference -- || --
        int ptX = center.x + (int) (dx * cosThetha - dy * sinThetha);
        int ptY = center.y + (int) (dx * sinThetha + dy * cosThetha);
        return new Point(ptX, ptY);
    }
    
    public static Polygon rotatePolygon(Polygon po, Point center, double angleDeg) {
        Polygon rotPo = new Polygon();
        for(int i=0;i<po.npoints;i++){
            Point point = rotatePoint(new Point(po.xpoints[i],po.ypoints[i]),center,angleDeg);
            rotPo.addPoint(point.x,point.y);
        }
        return rotPo;
    }
    
    @Override
    public void drawTurtle(Graphics graph) {
        if (graph == null) {
            return;
        }
        for (Iterator it = tortue.getListSegments().iterator(); it.hasNext();) {
            Segment seg = (Segment) it.next();
            seg.drawSegment(graph);
        }
        Point p = new Point(tortue.getX(),tortue.getY());
        Polygon formeTortue = new Polygon();
        
        formeTortue.addPoint(p.x-4,p.y+16);
        formeTortue.addPoint(p.x-4,p.y+8);
        formeTortue.addPoint(p.x-8,p.y+8);
        formeTortue.addPoint(p.x-8,p.y+4);
        formeTortue.addPoint(p.x-12,p.y+4);
        formeTortue.addPoint(p.x-12,p.y+0);
        formeTortue.addPoint(p.x-8,p.y+0);
        formeTortue.addPoint(p.x-8,p.y-4);
        formeTortue.addPoint(p.x-12,p.y-4);
        formeTortue.addPoint(p.x-12,p.y-8);
        formeTortue.addPoint(p.x-8,p.y-8);
        formeTortue.addPoint(p.x-8,p.y-12);
        
        formeTortue.addPoint(p.x+8,p.y-12);
        formeTortue.addPoint(p.x+8,p.y-8);
        formeTortue.addPoint(p.x+12,p.y-8);
        formeTortue.addPoint(p.x+12,p.y-4);
        formeTortue.addPoint(p.x+8,p.y-4);
        formeTortue.addPoint(p.x+8,p.y-0);
        formeTortue.addPoint(p.x+12,p.y-0);
        formeTortue.addPoint(p.x+12,p.y+4);
        formeTortue.addPoint(p.x+8,p.y+4);
        formeTortue.addPoint(p.x+8,p.y+8);
        formeTortue.addPoint(p.x+4,p.y+8);
        formeTortue.addPoint(p.x+4,p.y+16);
       
        formeTortue=rotatePolygon(formeTortue, p, tortue.getDir()-90);
        graph.setColor(Color.green);
        graph.fillPolygon(formeTortue);
        graph.setColor(Color.black);
        graph.drawPolygon(formeTortue);
    }
}
