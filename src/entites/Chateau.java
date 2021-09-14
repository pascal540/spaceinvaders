package entites;

import java.awt.Color;
import java.awt.Graphics;

import ressources.Constantes;

public class Chateau extends Entite {
    // ================== VARIABLES ====================

    private final int NBRE_LIGNES = Constantes.HAUTEUR_CHATEAU / Constantes.DIMENSION_BRIQUE;
    private final int NBRE_COLONNES = Constantes.LARGEUR_CHATEAU / Constantes.DIMENSION_BRIQUE;

    // Tableau contenant les briques du chateau
    boolean tabChateau[][] = new boolean[NBRE_LIGNES][NBRE_COLONNES];

    // ============= Constructeur ================
    public Chateau(int xPos) {
        super.xPos = xPos; // Abcisse du point le plus à gauche du chateau
        super.yPos = Constantes.Y_POS_CHATEAU; // Ordonnée du sommet du chateau
        this.initTabChateau();

    }

    // Creation du tableau global associé au chateau sans degat
    public void initTabChateau() {
        // On remplmit toutes les cases du tableau avec true
        for (int ligne = 0; ligne < NBRE_LIGNES; ligne++) {
            for (int colonne = 0; colonne < NBRE_COLONNES; colonne++) {
                tabChateau[ligne][colonne] = true;
            }
        }
        // On remplit touts les cases sans brique du chateau avec false
        // Biseautage du haut du chateau
        for (int colonne = 0; colonne < 6; colonne++) {
            for (int ligne = 0; ligne < 2; ligne++) {
                tabChateau[ligne][colonne] = false;
                tabChateau[ligne][NBRE_COLONNES - colonne - 1] = false;
            }
        }
        for (int colonne = 0; colonne < 4; colonne++) {
            for (int ligne = 0; ligne < 4; ligne++) {
                tabChateau[ligne][colonne] = false;
                tabChateau[ligne][NBRE_COLONNES - colonne - 1] = false;
            }
        }
        for (int colonne = 0; colonne < 2; colonne++) {
            for (int ligne = 0; ligne < 6; ligne++) {
                tabChateau[ligne][colonne] = false;
                tabChateau[ligne][NBRE_COLONNES - colonne - 1] = false;
            }
        }
        // Entrée du chateau
        for (int ligne = 18; ligne < NBRE_LIGNES; ligne++) {
            for (int colonne = 10; colonne < NBRE_COLONNES - 10; colonne++) {
                tabChateau[ligne][colonne] = false;

            }
        }
        // Biseautage entrée du chateau
        for (int colonne = 12; colonne < NBRE_COLONNES - 12; colonne++) {
            for (int ligne = 16; ligne < 18; ligne++) {
                tabChateau[ligne][colonne] = false;
                tabChateau[ligne][NBRE_COLONNES - colonne - 1] = false;
            }
        }
        for (int colonne = 14; colonne < NBRE_COLONNES - 14; colonne++) {
            for (int ligne = 14; ligne < 16; ligne++) {
                tabChateau[ligne][colonne] = false;
                tabChateau[ligne][NBRE_COLONNES - colonne - 1] = false;
            }
        }
        for (int colonne = 0; colonne < 2; colonne++) {
            for (int ligne = 4; ligne < 6; ligne++) {
                tabChateau[ligne][colonne] = false;
                tabChateau[ligne][NBRE_COLONNES - colonne - 1] = false;
            }
        }
    }

    // Dessin du chateau
    public void dessinChateau(Graphics g2) {
        for (int ligne = 0; ligne < NBRE_LIGNES; ligne++) {
            for (int colonne = 0; colonne < NBRE_COLONNES; colonne++) {
                if (tabChateau[ligne][colonne] == true) {
                    g2.setColor(Color.green);
                } else {
                    g2.setColor(Color.BLACK);
                }
                g2.fillRect(this.xPos + Constantes.DIMENSION_BRIQUE * colonne,
                        this.yPos + Constantes.DIMENSION_BRIQUE * ligne, Constantes.DIMENSION_BRIQUE,
                        Constantes.DIMENSION_BRIQUE);

            }
        }
    }
}
