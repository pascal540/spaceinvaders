package jeu;

import javax.swing.JPanel;

import entites.GroupeAliens;
import entites.TirVaisseau;
import entites.Vaisseau;
import ressources.Chrono;
import ressources.Clavier;
import ressources.Constantes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

// creation du panneau

public class Scene extends JPanel {

    // variables
    public Vaisseau vaisseau = new Vaisseau();
    public GroupeAliens groupeAliens = new GroupeAliens();
    public TirVaisseau tirVaisseau = new TirVaisseau();

    // Constructeur
    public Scene() {
        super();
        // Instanciation de la classe clavier

        // ecoute du clavier par la classe Scene
        this.setFocusable(true);
        // focus dans la fenetre du jeu pour entendre les evneemts clavier
        this.requestFocusInWindow();
        // instance du clavier
        this.addKeyListener(new Clavier());
        // Instanciation du chrono (à la fin du constructeur) pour repeindre l'ecran
        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    // Methodes
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        // dessin du fond d'ecran
        g2.setColor(Color.black);
        g2.fillRect(0, 0, Constantes.LARGEUR_FENETRE, Constantes.HAUTEUR_FENETRE);
        // dessin ligne verte en bas de l'ecran
        g2.setColor(Color.green);
        g2.fillRect(30, 530, 535, 5);

        // Dessin du vaisseau
        this.vaisseau.dessinVaisseau(g2);
        // Dessin des aliens
        this.groupeAliens.dessinAliens(g2);

        // Dessin du tir vaisseau
        this.tirVaisseau.dessinTirVaisseau(g2);
    }

}