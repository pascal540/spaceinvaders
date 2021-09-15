package entites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import ressources.Audio;
import ressources.Chrono;
import ressources.Constantes;

public class Soucoupe extends Entite {

    // ======== VARIABLES ============
    public Audio musiqueSoucoupe = new Audio("/sons/sonSoucoupePasse.wav"); // Onp uet arreter ces sons ionstancies avec
                                                                            // play ou stop
    public Audio musiqueDestructionSoucoupe = new Audio("/sons/sonDestructionSoucoupe.wav");

    private int compteur = 0;

    // =========== Constructeur ===========

    public Soucoupe() {
        // Initailisation des variables de la calsse mere
        super.xPos = Constantes.X_POS_INIT_SOUCOUPE;
        super.yPos = Constantes.Y_POS_SOUCOUPE;
        super.largeur = Constantes.LARGEUR_SOUCOUPE;
        super.hauteur = Constantes.HAUTEUR_SOUCOUPE;
        super.dx = Constantes.DX_SOUCOUPE;
        super.dy = 0;
        // Adresse des images de la soucoupe
        this.strImg1 = "/images/soucoupe.png";
        this.strImg2 = "/images/soucoupe100.png";
        this.strImg3 = "";
        // CHargement de l'iamge de la soucoup
        super.ico = new ImageIcon(getClass().getResource(strImg1));
        super.img = this.ico.getImage();
        super.vivant = true;
        this.musiqueSoucoupe.play();
        this.musiqueDestructionSoucoupe.stop();
        this.compteur = 0;

    }

    // ============ Methodes ============

    public int deplacementSoucoupe() {
        // Renvoie la nouvelle position apres déplacement eventuel
        if (this.vivant && Chrono.compteTours % 2 == 0) {
            if (this.xPos > 0) {
                this.xPos = this.xPos - this.dx;
            } else {
                this.xPos = Constantes.X_POS_INIT_SOUCOUPE;
            }
        }
        return this.xPos;
    }

    public void dessinSoucoupe(Graphics g) {
        if (this.vivant == false) {
            this.destructionSoucoupe();
        }
        g.drawImage(this.img, this.deplacementSoucoupe(), this.yPos, null);
    }

    public void destructionSoucoupe() {
        if (compteur < 300) {
            super.ico = new ImageIcon(getClass().getResource(super.strImg2));
            super.img = this.ico.getImage();
            compteur++;
        } else {
            this.xPos = Constantes.X_POS_INIT_SOUCOUPE;
        }

    }
}