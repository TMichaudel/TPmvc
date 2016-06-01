package Vue;

import Modele.Segment;
import Modele.Tortue;
import java.awt.Graphics;
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
    private Tortue tortue;
    public VueSuperTortue(Tortue tortue) {
        super(tortue);
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
    }
}
