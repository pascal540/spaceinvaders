package ressources;

/**
 * classe abstraite qui ne fabriquera aucun objet
 */
public abstract class Constantes {
    // =============================== FENETRE ===============================
    public static final int LARGEUR_FENETRE = 600;
    public static final int HAUTEUR_FENETRE = 600;
    public static final int MARGE_FENETRE = 50; // pour que le vaisseau n'aille pas au bord de la fenetre

    // ================= VAISSEAU ===================
    // Dimenssion du vaisseau
    public static final int LARGEUR_VAISSEAU = 39;
    public static final int HAUTEUR_VAISSEAU = 24;

    // Position initiale du vaisseau
    public static final int X_POS_INIT_VAISSEAU = (LARGEUR_FENETRE - LARGEUR_VAISSEAU) / 2;
    public final static int Y_POS_VAISSEAU = 490;

    // Unité de déplacement du vaisseau
    public final static int DX_VAISSEAU = 1;

    // Limite de déplacement du vaisseau
    public final static int LIMITE_GAUCHE_VAISSEAU = 60;
    public final static int LIMITE_DROITE_VAISSEAU = 500;

    // ========================= ALIEN ==================================
    // Dimensions de l'Alien
    public static final int LARGEUR_ALIEN = 33;
    public static final int HAUTEUR_ALIEN = 25;

    // Parametres de position des aliens
    public static final int ALT_INIT_ALIEN = 120;
    public static final int X_POS_INIT_ALIEN = 29 + MARGE_FENETRE;
    public static final int ECART_LIGNES_ALIEN = 40;
    public static final int ECART_COLONNES_ALIEN = 10;

    // Unite de deplacement de l'Alien
    public final static int DX_ALIEN = 2;
    public final static int DY_ALIEN = 20;

}