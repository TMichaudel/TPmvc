package Modele;

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
    private static int DIST_VUE =150;
    private static int ANGLE_VUE= 60;
    private int distVue;
    private int angleVue;
    private int vitesse;
    
    public TortueIntelligente(int posx, int posy, int vitesse, int direction){
        super(posx, posy);
        distVue=DIST_VUE;
        angleVue=ANGLE_VUE;
        this.vitesse=vitesse;
        this.dir=direction;
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
    
    @Override
    public void avancer(int dist) {
        vitesse=dist;
        super.avancer(dist);
    }
    
    public boolean voit(TortueIntelligente tortueAVoir) {
        boolean enVue=false;
        double distance=Math.sqrt((this.x-tortueAVoir.x)*(this.x-tortueAVoir.x)+(this.y-tortueAVoir.y)*(this.y-tortueAVoir.y));
        if (this.distVue>distance) {
            int newX=tortueAVoir.x-this.x;
            int newY=tortueAVoir.y-this.y;         
            double distance2=Math.abs(newY);
            System.out.println(distance+" "+distance2);
            double angleRad=Math.cos(distance/distance2);
            System.out.println(angleRad);
            int angle;
            if (newX<0){
                if(newY<0) {
                    System.out.println("a");
                    angle=90+(int)Math.round(angleRad*180/Math.PI);
                }
                else {
                    System.out.println("b");
                    angle=270-(int)Math.round(angleRad*180/Math.PI);
                }
            }
            else {
                if(newY<0){
                    System.out.println("c");
                    angle=90-(int)Math.round(angleRad*180/Math.PI);
                }
                else {
                    System.out.println("d");
                    angle=270+(int)Math.round(angleRad*180/Math.PI);
                }
            }           
            System.out.println(angle);
            if((angle<this.dir+this.angleVue/2)&&(angle>this.dir-this.angleVue/2)){
                enVue=true;
            }
        }
        return enVue; 
    }
}
