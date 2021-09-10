package jeu;
//librairie swing
import javax.swing.JFrame;

import ressources.Constantes;

public class Main {
// ================== Variables ================
    public static Scene scene; // static donc on y accedera de partout !

    public static void main(String[] args) throws Exception {
        // creation fenetre de l'application
        JFrame fenetre = new JFrame("Jeu Space Invaders");
        fenetre.setSize(Constantes.LARGEUR_FENETRE, Constantes.HAUTEUR_FENETRE);
        fenetre.setResizable(false);
        // milieu ecran
        fenetre.setLocationRelativeTo(null); 
        //fermeture par la croix de la fenetre
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //toujours au dessus des autres fenetres
        fenetre.setAlwaysOnTop(true);
        // association du panneau scene  à la fenêtre
        scene = new Scene();
        fenetre.setContentPane(scene);


        fenetre.setVisible(true);
    }
}
