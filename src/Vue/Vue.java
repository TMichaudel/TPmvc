/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Controleur;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author mathieu
 */
public class Vue extends JFrame {

    public static final Dimension VGAP = new Dimension(1, 5);
    public static final Dimension HGAP = new Dimension(5, 1);

    private Controleur control;
    
    public static void main(String[] args) {
		  // SwingUtilities.invokeLater(new Runnable(){
		//		public void run(){
                                        Vue fenetre = new Vue();
					fenetre.setVisible(true);
				}
			//});
		//}
    
    private void quitter() {
        System.exit(0);
    }
    
    public Vue() {
        super("Choose wisely");
        this.control = new Controleur(this);

        initWindow();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }
    
    public void initWindow(){
        getContentPane().setLayout(new BorderLayout(10, 10));
        JPanel buttonPanel = new JPanel(new GridLayout());
        JButton bmanuel = new JButton("Manuela, la tortuga");
        JButton bAlea = new JButton("Random, the turtles");
        buttonPanel.add(bmanuel);
        bmanuel.addActionListener(control);
        buttonPanel.add(bAlea);
        bAlea.addActionListener(control);
        getContentPane().add(buttonPanel);
        pack();
        setVisible(true);
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
}
