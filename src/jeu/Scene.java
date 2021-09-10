package jeu;

import javax.swing.JPanel;

import ressources.Constantes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

// creation du panneau

public class Scene extends JPanel {
    // variables

    // Constructeur
    public Scene() {
        super();

    }

    // Methodes
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        //dessin du fond d'ecran
        g2.setColor(Color.black);
        g2.fillRect(0, 0, Constantes.LARGEUR_FENETRE, Constantes.HAUTEUR_FENETRE);
        //dessin ligne verte en bas de l'ecran
        g2.setColor(Color.green);
        g2.fillRect(30, 530, 535, 5);
        


    }
    
}