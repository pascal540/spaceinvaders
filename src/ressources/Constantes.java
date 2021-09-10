package ressources;

/**
 * classe abstraite qui ne fabriquera aucun objet
 */
public abstract class Constantes {
    //  =============================== FENETRE    ===============================
    public static final int LARGEUR_FENETRE = 600;
    public static final int HAUTEUR_FENETRE = 600;
    public static final int MARGE_FENETRE = 50; // pour que le vaisseau n'aille pas au bord de la fenetre
    
    //================= VAISSEAU ===================
    //Dimenssion du vaisseau
    public static final int LARGEUR_VAISSEAU = 39;
    public static final int HAUTEUR_VAISSEAU = 24;
    
    //Position initiale du vaisseau
    public static final int X_POS_INIT_VAISSEAU = (LARGEUR_FENETRE - LARGEUR_VAISSEAU) / 2;
    public final static int Y_POS_VAISSEAU = 490;

    //Unité de déplacement du vaisseau
    public final static int DX_VAISSEAU = 1;
}