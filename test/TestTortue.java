/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modele.Tortue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mathieu
 */
public class TestTortue {
    
    @Test
    public void testAvance(){
        Tortue t = new Tortue(15, 15);
        t.avancer(10);
        assertEquals(t.getPosX(), 15);
        assertEquals(t.getPosY(), 5);
    }
    
    @Test
    public void testDroite(){
        Tortue t = new Tortue (15, 15);
        t.droite(90);
        assertEquals(t.getDir(), 0);
    }
    
    @Test
    public void testGauche(){
        Tortue t = new Tortue(15, 15);
        t.gauche(90);
        assertEquals(t.getDir(), -180);
    }
    
}
