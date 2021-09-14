package entites;

import ressources.Chrono;
import ressources.Constantes;
import java.awt.*;

public class GroupeAliens {

    // Variables

    // Tableau contenant tous les Aliens (50)
    private Alien tabAlien[][] = new Alien[5][10];

    private boolean vaAdroite, pos1;
    private int vitesse;

    private int[] tabAlienMort = { -1, -1 };// emplacemen alien mort dans tableau aliens

    // =================== Constructeur =================
    public GroupeAliens() {

        this.initTableauAliens();
        this.vaAdroite = true; // commencea droite a udepart!
        this.pos1 = true;
        this.vitesse = Constantes.VITESSE_ALIEN;
    }

    // ================ MEthodes ===================
    private void initTableauAliens() {
        // Methode qui remplit le tablau complet des Aliens
        for (int colonne = 0; colonne < 10; colonne++) {
            this.tabAlien[0][colonne] = new Alien(
                    Constantes.X_POS_INIT_ALIEN
                            + (Constantes.LARGEUR_ALIEN + Constantes.ECART_COLONNES_ALIEN) * colonne,
                    Constantes.ALT_INIT_ALIEN, "/images/alienHaut1.png", "/images/alienHaut2.png");
            {
                for (int ligne = 1; ligne < 3; ligne++) {
                    this.tabAlien[ligne][colonne] = new Alien(
                            Constantes.X_POS_INIT_ALIEN
                                    + (Constantes.LARGEUR_ALIEN + Constantes.ECART_COLONNES_ALIEN) * colonne,
                            Constantes.ALT_INIT_ALIEN + Constantes.ECART_LIGNES_ALIEN * ligne,
                            "/images/alienMilieu1.png", "/images/alienMilieu2.png");
                }
                for (int ligne = 3; ligne < 5; ligne++) {
                    this.tabAlien[ligne][colonne] = new Alien(
                            Constantes.X_POS_INIT_ALIEN
                                    + (Constantes.LARGEUR_ALIEN + Constantes.ECART_COLONNES_ALIEN) * colonne,
                            Constantes.ALT_INIT_ALIEN + Constantes.ECART_LIGNES_ALIEN * ligne, "/images/alienBas1.png",
                            "/images/alienBas2.png");
                }
            }

        }
    }

    public void dessinAliens(Graphics g) {
        if (Chrono.compteTours % (100 - 10 * this.vitesse) == 0) {
            this.deplacementAliens();
        }
        // Dessin des aliens contenus dans le tableau tabAlien
        for (int colonne = 0; colonne < 10; colonne++) {
            for (int ligne = 0; ligne < 5; ligne++) {

                if (this.tabAlien[ligne][colonne] != null) {
                    this.tabAlien[ligne][colonne].choixImage(pos1);
                    g.drawImage(this.tabAlien[ligne][colonne].getimg(), this.tabAlien[ligne][colonne].getxPos(),
                            this.tabAlien[ligne][colonne].getyPos(), null);
                }
            }
        }

    }

    private boolean toucheBordGauche() {
        // Methode qui detecte le bord gauche de la fenetre
        boolean reponse = false;
        for (int colonne = 0; colonne < 10; colonne++) {
            for (int ligne = 0; ligne < 5; ligne++) {
                if (this.tabAlien[ligne][colonne] != null) {
                    if (this.tabAlien[ligne][colonne].getxPos() < Constantes.MARGE_FENETRE) {
                        reponse = true;
                        break;
                    }
                }
            }
        }
        return reponse;

    }

    private boolean toucheBordDroit() {
        // Methode qui detecte le bord droit de la fenetre
        boolean reponse = false;
        for (int colonne = 0; colonne < 10; colonne++) {
            for (int ligne = 0; ligne < 5; ligne++) {
                if (this.tabAlien[ligne][colonne] != null) {
                    if (this.tabAlien[ligne][colonne].getxPos() > Constantes.LARGEUR_FENETRE - Constantes.LARGEUR_ALIEN
                            - Constantes.DX_ALIEN - Constantes.MARGE_FENETRE) {
                        reponse = true;
                        break;
                    }
                }
            }
        }
        return reponse;

    }

    public void alienTourneEtDescend() {
        // Méthode qui change le sens du déplacement de l'alien et le descend d'un cran
        if (this.toucheBordDroit() == true) {
            for (int colonne = 0; colonne < 10; colonne++) {
                for (int ligne = 0; ligne < 5; ligne++) {
                    if (this.tabAlien[ligne][colonne] != null) {
                        this.tabAlien[ligne][colonne]
                                .setyPos(this.tabAlien[ligne][colonne].getyPos() + Constantes.DY_ALIEN);
                    }
                }
            }
            this.vaAdroite = false;
            if (this.vitesse < 9) {
                this.vitesse++;
            }
        } else {
            if (this.toucheBordGauche() == true) {

                for (int colonne = 0; colonne < 10; colonne++) {
                    for (int ligne = 0; ligne < 5; ligne++) {
                        if (this.tabAlien[ligne][colonne] != null) {
                            this.tabAlien[ligne][colonne]
                                    .setyPos(this.tabAlien[ligne][colonne].getyPos() + Constantes.DY_ALIEN);
                        }
                    }
                }
                this.vaAdroite = true;
                if (this.vitesse < 9) {
                    this.vitesse++;
                }
            }
        }
    }

    public void deplacementAliens() {
        // Methode qui gere le deplacement des aliens
        if (this.tabAlienMort[0] != -1) {
            {// elimination de l'alien mort si necessaire
                elimineAlienMort(tabAlienMort);
                tabAlienMort[0] = -1;// reinitialisation de tabAlienMort
            }
        }
        if (this.vaAdroite == true) {// deplacement vers la droite
            for (int colonne = 0; colonne < 10; colonne++) {
                for (int ligne = 0; ligne < 5; ligne++) {
                    if (this.tabAlien[ligne][colonne] != null) {
                        this.tabAlien[ligne][colonne]
                                .setxPos(this.tabAlien[ligne][colonne].getxPos() + Constantes.DX_ALIEN);
                    }
                }
            }
        } else

        {// deplacement vers la gauche

            for (int colonne = 0; colonne < 10; colonne++) {
                for (int ligne = 0; ligne < 5; ligne++) {
                    if (this.tabAlien[ligne][colonne] != null) {
                        this.tabAlien[ligne][colonne]
                                .setxPos(this.tabAlien[ligne][colonne].getxPos() - Constantes.DX_ALIEN);
                    }
                }
            }
        }
        // Changement de l'image de l'alien
        this.pos1 = !this.pos1;
        // if (this.pos1 == true) {
        // this.pos1 = false;
        // } else {
        // this.pos1 = true;
        // }
        // maj du sens de deplacement si un alien atteint le bord de la fenetre
        this.alienTourneEtDescend();

    }

    public void tirVaisseauToucheAlien(TirVaisseau tirVaisseau) {
        // Detecttion contact tirVaisseau avec alien
        for (int colonne = 0; colonne < 10; colonne++) {
            for (int ligne = 0; ligne < 5; ligne++) {
                if (this.tabAlien[ligne][colonne] != null) {

                    if (tirVaisseau.tueAlien(this.tabAlien[ligne][colonne]) == true) {

                        this.tabAlien[ligne][colonne].vivant = false; // on tue l'alien
                        tirVaisseau.yPos = -1; // on tue le tir
                        // on enregistre la position de l'alien mort dasn le tableau
                        this.tabAlienMort[0] = ligne;
                        this.tabAlienMort[1] = colonne;
                        break;

                    }

                }

            }
        }

    }

    private void elimineAlienMort(int[] tabAlienMort) {
        // Methode qui enleve l'alien mort d utabluea (case à null)
        this.tabAlien[tabAlienMort[0]][tabAlienMort[1]] = null;
    }
}
