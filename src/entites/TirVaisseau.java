package entites;

import javax.swing.ImageIcon;

import ressources.Constantes;
import java.awt.*;

public class TirVaisseau extends Entite {
    // tir coup par coup et non pas en rafale
    // ============ Variables ==============

    public boolean vaisseauTire = false;

    // ========== Constructeur ==============
    public TirVaisseau() {
        // Initialisation des variables de la super classe
        super.xPos = 0;
        super.yPos = Constantes.Y_POS_VAISSEAU - Constantes.HAUTEUR_TIR_VAISSEAU;
        super.largeur = Constantes.HAUTEUR_TIR_VAISSEAU;
        super.hauteur = Constantes.HAUTEUR_TIR_VAISSEAU;
        super.dx = 0;
        super.dy = Constantes.DY_TIR_VAISSEAU;
        // Adresse des images du vaisseau
        super.strImg1 = "/images/tirVaisseau.png";
        super.strImg2 = "";
        super.strImg3 = "";
        // Chargement de l'image du vaisseau
        super.ico = new ImageIcon(getClass().getResource(super.strImg1));
        super.img = this.ico.getImage();

    }

    // ================== METHODES ==========================
    // Getters et setters
    public void setVaisseauTire(boolean vaisseauTire) {
        this.vaisseauTire = vaisseauTire;
    }

    public boolean isVaisseauTire() {
        return vaisseauTire;
    }

    public int deplacementTirVaisseau() {
        if (this.vaisseauTire == true) {
            if (this.yPos > 0) {
                this.yPos = this.yPos - Constantes.DY_TIR_VAISSEAU;
            } else {
                this.vaisseauTire = false;
            }

        }
        return yPos;
    }

    public void dessinTirVaisseau(Graphics g) {
        if (this.vaisseauTire == true) {
            g.drawImage(this.img, this.xPos, this.deplacementTirVaisseau(), null);
        }

    }

}