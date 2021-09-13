package entites;

import javax.swing.ImageIcon;

import ressources.Constantes;

public class Alien extends Entite {

    // Variables

    // Constructeur
    public Alien(int xPos, int yPos, String strImg1, String strImg2) {

        // Initialisation des variables de la super classe
        // super variables definies dans la classe Entite qui est la classe mere

        super.xPos = xPos;
        super.yPos = yPos;
        super.largeur = Constantes.LARGEUR_ALIEN;
        super.hauteur = Constantes.HAUTEUR_ALIEN;
        super.dx = 0; // depart à 0
        super.dy = 0;

        // Adresse des images Alien
        super.strImg1 = strImg1;
        super.strImg2 = strImg2;
        super.strImg3 = "/images/alienMeurt.png";

        // Chargement de l'image des Aliens
        super.ico = new ImageIcon(getClass().getResource(super.strImg1));
        super.img = this.ico.getImage();

    }

    public void choixImage(boolean pos1) {
        // Methode qui charge l'image de l'alien suivant sa posiiton 1 ou 2
        if (pos1 == true) {
            super.ico = new ImageIcon(getClass().getResource(strImg1));
        } else {
            super.ico = new ImageIcon(getClass().getResource(strImg2));
        }
        super.img = this.ico.getImage();// recharge l'image
    }
}
