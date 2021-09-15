package jeu;

import javax.swing.JPanel;

import entites.Chateau;
import entites.GroupeAliens;
import entites.Soucoupe;
import entites.TirAlien;
import entites.TirVaisseau;
import entites.Vaisseau;
import ressources.Chrono;
import ressources.Clavier;
import ressources.Constantes;

import java.awt.*;

// creation du panneau

public class Scene extends JPanel {

    // variables
    public Vaisseau vaisseau = new Vaisseau();
    public GroupeAliens groupeAliens = new GroupeAliens();
    public TirVaisseau tirVaisseau = new TirVaisseau();
    public Chateau tabChateaux[] = new Chateau[4]; // Création d'un tableau contenant les 4 chateaux
    public TirAlien tirAlien1, tirAlien2, tirAlien3;
    public Soucoupe soucoupe;

    private Font afficheScore = new Font("Arial", Font.PLAIN, 20);
    private Font afficheTexte = new Font("Arial", Font.PLAIN, 80);

    public int score = 0;

    // Constructeur
    public Scene() {
        super();
        // Instanciation des chateaux
        for (int colonne = 0; colonne < 4; colonne++) {
            this.tabChateaux[colonne] = new Chateau(Constantes.MARGE_FENETRE + Constantes.X_POS_INIT_CHATEAU
                    + colonne * (Constantes.LARGEUR_CHATEAU + Constantes.ECART_CHATEAU));
        }
        // Instanciation de la classe clavier
        // ecoute du clavier par la classe Scene
        this.setFocusable(true);
        // focus dans la fenetre du jeu pour entendre les evneemts clavier
        this.requestFocusInWindow();
        // instance du clavier
        this.addKeyListener(new Clavier());
        // Instanciation du chrono (à la fin du constructeur) pour repeindre l'ecran
        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    // Methodes
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        // dessin du fond d'ecran
        g2.setColor(Color.black);
        g2.fillRect(0, 0, Constantes.LARGEUR_FENETRE, Constantes.HAUTEUR_FENETRE);
        // dessin ligne verte en bas de l'ecran
        g2.setColor(Color.green);
        g2.fillRect(30, 530, 535, 5);

        // Affichage du score
        g.setFont(afficheScore);
        g.drawString("SCORE : " + score, 400, 25);

        // Dessin du vaisseau
        this.vaisseau.dessinVaisseau(g2);
        // Dessin des aliens
        this.groupeAliens.dessinAliens(g2);

        // Dessin du tir vaisseau
        this.tirVaisseau.dessinTirVaisseau(g2);

        // Detection contatc tirVaisseau avec alien
        this.groupeAliens.tirVaisseauToucheAlien(this.tirVaisseau);

        // Dessin des chateaux
        for (int colonne = 0; colonne < 4; colonne++) {
            this.tabChateaux[colonne].dessinChateau(g2);
        }

        // Message de bienvenue
        if (Chrono.compteTours < 500) {
            g.setFont(afficheTexte);
            g.drawString("Good luck   ! ", 95, 100);
        }

        // Detection contact tirVaisseau avec chateau
        this.tirVaisseau.tirVaisseauDetruitChateau(tabChateaux);

        // Dessin des tirs des aliens
        if (Chrono.compteTours % 500 == 0) {
            tirAlien1 = new TirAlien(this.groupeAliens.choixAlienQuiTire());// new instance
        }
        if (this.tirAlien1 != null) {
            this.tirAlien1.dessinTirAlien(g2);
            this.tirAlien1.TirAlienDetruitChateau(tabChateaux);// Detection contact
            if (this.tirAlien1.toucheVaisseau(vaisseau) == true) {
                this.vaisseau.setvivant((false));
            }

        }

        if (Chrono.compteTours % 750 == 0) {
            tirAlien2 = new TirAlien(this.groupeAliens.choixAlienQuiTire()); // new instance
        }
        if (this.tirAlien2 != null) {
            this.tirAlien2.dessinTirAlien(g2);
            this.tirAlien2.TirAlienDetruitChateau(tabChateaux);// Detection contact
            if (this.tirAlien2.toucheVaisseau(vaisseau) == true) {
                this.vaisseau.setvivant((false));
            }
        }

        if (Chrono.compteTours % 900 == 0) {
            tirAlien3 = new TirAlien(this.groupeAliens.choixAlienQuiTire());// new instance
        }
        if (this.tirAlien3 != null) {
            this.tirAlien3.dessinTirAlien(g2);
            this.tirAlien3.TirAlienDetruitChateau(tabChateaux);// Detection contact
            if (this.tirAlien3.toucheVaisseau(vaisseau) == true) {
                this.vaisseau.setvivant((false));
            }
        }
        // Dessin de la soucoupe
        if (Chrono.compteTours % 2500 == 0) {
            soucoupe = new Soucoupe();
        }
        if (this.soucoupe != null) {
            if (this.soucoupe.getxPos() > 0) {
                // Detection contact tir vaisseau avec soucoupe
                if (this.tirVaisseau.detruitSoucoupe(this.soucoupe) == true) {
                    if (this.soucoupe.getdx() != 0) {
                        this.score += Constantes.VALEUR_SOUCOUPE;
                    }
                    this.soucoupe.setdx(0);
                    this.soucoupe.setvivant(false);
                    this.soucoupe.musiqueSoucoupe.stop();
                    this.soucoupe.musiqueDestructionSoucoupe.play();
                }

                this.soucoupe.dessinSoucoupe(g2);
            } else {
                this.soucoupe = null;

            }
        }
        // Message de la fin du jeu
        if (!this.vaisseau.isVivant()) {
            g.setFont(afficheTexte);
            g.drawString("GAME OVER  ! ", 50, 100);
        }

    }
}
