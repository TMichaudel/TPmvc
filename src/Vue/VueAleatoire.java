package Vue;

// package logo;
import Controleur.ControleurManuel;
import Modele.Tortue;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;
import java.io.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author mathieu
 */
public class VueAleatoire extends JFrame implements Observer{

    public static final Dimension VGAP = new Dimension(1, 5);
    public static final Dimension HGAP = new Dimension(5, 1);

    private ControleurManuel control;
    private VueFeuilleDessin feuille;

    private JTextField inputValue;
    
    	public static void main(String[] args) {
		   SwingUtilities.invokeLater(new Runnable(){
				public void run(){
                                        VueAleatoire fenetre = new VueAleatoire();
					fenetre.setVisible(true);
				}
			});
		}
        
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
        //this.control = new ControleurAleatoire(this);

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

    public String getInputValue() {
        String s = inputValue.getText();
        return (s);
    }

    //utilitaires pour installer des boutons et des menus
    public void addButton(JComponent p, String name, String tooltiptext, String imageName) {
        JButton b;
        if ((imageName == null) || (imageName.equals(""))) {
            b = (JButton) p.add(new JButton(name));
        } else {
            java.net.URL u = this.getClass().getResource(imageName);
            if (u != null) {
                ImageIcon im = new ImageIcon(u);
                b = (JButton) p.add(new JButton(im));
            } else {
                b = (JButton) p.add(new JButton(name));
            }
            b.setActionCommand(name);
        }

        b.setToolTipText(tooltiptext);
        b.setBorder(BorderFactory.createRaisedBevelBorder());
        b.setMargin(new Insets(0, 0, 0, 0));
        b.addActionListener(control);
    }

    public void addMenuItem(JMenu m, String label, String command, int key) {
        JMenuItem menuItem;
        menuItem = new JMenuItem(label);
        m.add(menuItem);

        menuItem.setActionCommand(command);
        menuItem.addActionListener(control);
        if (key > 0) {
            if (key != KeyEvent.VK_DELETE) {
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, Event.CTRL_MASK, false));
            } else {
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, 0, false));
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        feuille.repaint();
    }
}
