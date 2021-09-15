package entites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import jeu.Main;
import ressources.Chrono;
import ressources.Constantes;

public class Vaisseau extends Entite {
    // ============= VARIABLES ==============
    private int compteur = 0;

    // ============ CONSTRUCTEUR ==============

    public Vaisseau() {
        // Initialisation des variables de la super classe
        // acces aux variables de la classe mere 'Entite par 'super'
        super.xPos = Constantes.X_POS_INIT_VAISSEAU;
        super.yPos = Constantes.Y_POS_VAISSEAU;
        super.largeur = Constantes.LARGEUR_VAISSEAU;
        super.hauteur = Constantes.HAUTEUR_VAISSEAU;
        super.dx = 0; // depart à 0 pour eviter qu ele vaisseau commence sans appuie sur les touches
                      // au depart avec la boucle
        super.dy = 0;

        // Adresse des images du vaisseau
        super.strImg1 = "/images/vaisseau.png";
        super.strImg2 = "/images/vaisseauDetruit1.png";
        super.strImg3 = "/images/vaisseauDetruit2.png";

        // Chargement de l'image du vaisseau
        super.ico = new ImageIcon(getClass().getResource(super.strImg1));
        super.img = this.ico.getImage();
        super.vivant = true;

    }

    // ================= METHODES ======================
    public int deplacementVaisseau() {
        // renvoie la nouvelle position du vaisseau après deplacement eventuel
        if (this.dx < 0) {
            if (this.xPos > Constantes.LIMITE_GAUCHE_VAISSEAU)
                this.xPos = this.xPos + this.dx;
        } else if (dx > 0) {
            if (this.xPos + this.dx < Constantes.LIMITE_DROITE_VAISSEAU) {
                this.xPos = this.xPos + this.dx;
            }

        }
        return this.xPos;
    }

    public void dessinVaisseau(Graphics g) {
        if (this.vivant == false) {
            this.destructionVaisseau();
        }
        g.drawImage(this.img, this.deplacementVaisseau(), this.yPos, null);

    }

    public void destructionVaisseau() {
        if (compteur < 300) {
            if (Chrono.compteTours % 2 == 0) {
                super.ico = new ImageIcon(getClass().getResource(super.strImg2));
            } else {
                super.ico = new ImageIcon(getClass().getResource(super.strImg3));
            }
            compteur++;
        } else {
            Main.jeu = false;

        }
        super.img = this.ico.getImage(); // chargement de l'image à chaque appel de la méthode
    }
}