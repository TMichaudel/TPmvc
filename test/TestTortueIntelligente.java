/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modele.TortueIntelligente;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Thibaud
 */
public class TestTortueIntelligente {
    
    public TestTortueIntelligente() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testVue(){
        TortueIntelligente t1 = new TortueIntelligente(100,100,0,0);
        TortueIntelligente t2 = new TortueIntelligente(200,125,0,0);
        assertEquals(t1.voit(t2),true);
    }
}
