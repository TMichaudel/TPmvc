package Modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thibaud
 */
	public class Segment {
		public Point ptStart, ptEnd;
		public Color color;
		
		public Segment() {
			ptStart = new Point(0,0);
			ptEnd = new Point(0,0);
		}
		
		public void drawSegment(Graphics graph) {
			if (graph==null)
				return;

			graph.setColor(color);
			graph.drawLine(ptStart.x, ptStart.y, ptEnd.x, ptEnd.y);
		}	
	}
