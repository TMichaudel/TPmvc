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
public class BancDeTortues {
    ArrayList<TortueIntelligente> tortues;
    
    public BancDeTortues(int nbTortue){
        tortues=new ArrayList();
        for(int i=0;i<nbTortue;i++) {         
            tortues.add(new TortueIntelligente(ThreadLocalRandom.current().nextInt(0, 400),
                    ThreadLocalRandom.current().nextInt(0, 400),
                    ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 360)
            ));
        }
    }
    
    public void regarderEnvirons(TortueIntelligente tortue) {
        
    }
}
