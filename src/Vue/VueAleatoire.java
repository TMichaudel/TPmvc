package Vue;

// package logo;
import Controleur.ContoleurAleatoire;
import Controleur.ControleurManuel;
import Modele.Tortue;
import java.awt.*;


import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author mathieu
 */
public class VueAleatoire extends JFrame implements Observer{

    public static final Dimension VGAP = new Dimension(1, 5);
    public static final Dimension HGAP = new Dimension(5, 1);

    private ContoleurAleatoire control;
    private VueFeuilleDessin feuille;

    private JTextField inputValue;
        
    private void quitter() {
        System.exit(0);
    }

    public VueFeuilleDessin getFeuille() {
        return feuille;
    }
    public void initFeuille(){
        feuille = new VueFeuilleDessin();
        feuille.setBackground(Color.white);
        feuille.setSize(new Dimension(600, 400));
        feuille.setPreferredSize(new Dimension(600, 400));
    }
    
    public VueAleatoire() {
        super("Tortues aléatoires");
        initFeuille();
        this.control = new ContoleurAleatoire(this);

        logoInit();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    public void logoInit() {
        getContentPane().setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(feuille, "Center");
        pack();
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        feuille.repaint();
    }
}
