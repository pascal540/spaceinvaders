package entites;

import javax.swing.ImageIcon;

import jeu.Main;
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
        super.largeur = Constantes.LARGEUR_TIR_VAISSEAU;
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

    public boolean tueAlien(Alien alien) {
        // Le tir du vaisseau détruit un alien
        if (this.yPos < alien.getyPos() + alien.gethauteur() && this.yPos + this.hauteur > alien.getyPos()
                && this.xPos + this.largeur > alien.getxPos() && this.xPos < alien.getxPos() + alien.getlargeur()) {
            return true; // touché !
        }

        else
            return false;
    }

    private boolean tirVaisseauAHauteurDeChateau() {
        // Renvoie vrai si le tir du vaisseau est à hauteur des chateaux
        if (this.yPos < Constantes.Y_POS_CHATEAU + Constantes.HAUTEUR_CHATEAU && this.yPos > Constantes.Y_POS_CHATEAU) {
            return true;
        } else {
            return false;
        }
    }

    private int chateauProche() {
        // Renvoie le numéro du chateau ( 0 à 3) dans la zone de tir du chateau
        int numeroChateau = -1;
        int colonne = -1;
        while (numeroChateau == -1 && colonne < 4) {
            colonne++;
            if (this.xPos + this.largeur > Constantes.MARGE_FENETRE + Constantes.X_POS_INIT_CHATEAU
                    + colonne * (Constantes.LARGEUR_CHATEAU + Constantes.ECART_CHATEAU)
                    && this.xPos < Constantes.MARGE_FENETRE + Constantes.X_POS_INIT_CHATEAU + Constantes.LARGEUR_CHATEAU
                            + colonne * (Constantes.LARGEUR_CHATEAU + Constantes.ECART_CHATEAU)) {
                numeroChateau = colonne;
            }
        }
        return numeroChateau;
    }

    private int abscisseContactTirChateau(Chateau chateau) {
        // Renvoie l'abscisse du tir du vaisseau lors du contact avec un chateau
        int xPosTirVaisseau = -1;
        if (this.xPos + this.largeur > chateau.getxPos()
                && this.xPos < chateau.getxPos() + Constantes.LARGEUR_CHATEAU) {
            xPosTirVaisseau = this.xPos;
        }
        return xPosTirVaisseau;
    }

    public int[] tirVaisseauToucheChateau() {
        // Renvoie numéro chateau e tabscisse du tir
        int[] tabRep = { -1, -1 };
        if (this.tirVaisseauAHauteurDeChateau() == true) { // le tir du vaisseau est à hauteur du chateau
            tabRep[0] = this.chateauProche();// enregistre le numero du chateau touché dasn tabRep[0]
            if (tabRep[0] != -1) {
                // Enregistre l'abscisse du tir du vaisseau lors du coantact avec le chateau
                // dasn tabRep[1]
                tabRep[1] = this.abscisseContactTirChateau(Main.scene.tabChateaux[tabRep[0]]);

            }

        }
        return tabRep;
    }

    public void tirVaisseauDetruitChateau(Chateau tabChateaux[]) {
        int[] tab = this.tirVaisseauToucheChateau();// contient {-1 -1} ou le numero du chateau touché et l'abscisse
        if (tab[0] != -1) {
            if (tabChateaux[tab[0]].trouveBrique(tabChateaux[tab[0]].trouveColonneChateau(tab[1])) != -1) {
                tabChateaux[tab[0]].casseBriques(tab[1]);// Détruit les briques du chateau touché
                this.yPos = -1;// On tue le tir et on réactive le canon du vaisseau
            }
        }

    }
}
