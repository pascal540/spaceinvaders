package entites;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import javafx.scene.canvas.GraphicsContext;
import ressources.Chrono;
import ressources.Constantes;

public class TirAlien extends Entite {

    // ============ Variables =============
    Random hasard = new Random();

    // =================== Constructeur =====================

    public TirAlien(int[] tabPositionAlien) {
        // Initialisation des variables de la super classe
        super.xPos = tabPositionAlien[0] + Constantes.LARGEUR_ALIEN / 2 - 1;
        super.yPos = tabPositionAlien[1] + Constantes.HAUTEUR_ALIEN;
        super.largeur = Constantes.LARGEUR_TIR_ALIEN;
        super.largeur = Constantes.HAUTEUR_TIR_ALIEN;
        super.dx = 0;
        super.dy = Constantes.DY_TIR_ALIEN;
        // Adresse des images du vaisseau
        super.strImg1 = "/images/tirAlien1.png";
        super.strImg2 = "/images/tirAlien2.png";
        super.strImg1 = "";
        // Chargement de l'iamge du tir de l'alien
        if (hasard.nextInt(2) == 0) {// entre 0 et 1
            super.ico = new ImageIcon(getClass().getResource(super.strImg1));
        } else { // on a tiré 1
            super.ico = new ImageIcon(getClass().getResource(super.strImg2));
        }
        super.img = this.ico.getImage();
    }

    // =================== Methodes =====================
    public int deplacementTirAlien() {
        if (Chrono.compteTours % 4 == 0) { // tous les 4 tours donc moins rapide à l'ecran
            if (this.yPos < 600) {
                this.yPos = this.yPos + Constantes.DY_TIR_ALIEN;
            }
        }
        return yPos;
    }

    public void dessinTirAlien(Graphics g) {
        g.drawImage(this.img, this.xPos, this.deplacementTirAlien(), null);

    }
}