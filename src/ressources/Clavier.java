package ressources;

import java.awt.event.*;

// import javafx.scene.input.KeyEvent;
import jeu.Main;

public class Clavier implements KeyListener {

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {

    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        if (Main.scene.vaisseau.isVivant() == true) { // Si le vaisseau est mort on ne peut plus se servir du clavier
            if (e.getKeyCode() == 39) { // touche D (droite)
                Main.scene.vaisseau.setdx(Constantes.DX_VAISSEAU);
            } else if (e.getKeyCode() == 37) {// touche Q (gauche)
                Main.scene.vaisseau.setdx(-Constantes.DX_VAISSEAU);
            } else if (e.getKeyCode() == 32) {
                if (Main.scene.tirVaisseau.isVaisseauTire() == false) {
                    Audio.playSound("/sons/sonTirVaisseau.wav"); // Pas besoin de creer d'instance, c'est un son tres
                                                                 // court ! on ne peut arretr ce son
                    Main.scene.tirVaisseau.setyPos(Constantes.Y_POS_VAISSEAU - Constantes.HAUTEUR_TIR_VAISSEAU);
                    Main.scene.tirVaisseau.setxPos(Main.scene.vaisseau.getxPos() + Constantes.LARGEUR_VAISSEAU / 2 - 1);
                    Main.scene.tirVaisseau.setVaisseauTire(true);
                }

            }
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) { // si on relache la touche on doit arreter le vaisseau !
        Main.scene.vaisseau.setdx(0);

    }

}
