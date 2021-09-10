package ressources;

import java.awt.event.*;

import javafx.scene.input.KeyEvent;
import jeu.Main;



public class Clavier implements KeyListener{



@Override
public void keyTyped(java.awt.event.KeyEvent e) {
    // TODO Auto-generated method stub
    
}
@Override
public void keyPressed(java.awt.event.KeyEvent e) {
     
    if (e.getKeyCode()==68) { //touche D (droite)
        Main.scene.vaisseau.setdx(Constantes.DX_VAISSEAU);
    } else if (e.getKeyCode() == 81) {//touche Q (gauche)
        Main.scene.vaisseau.setdx(-Constantes.DX_VAISSEAU);
    }

    
}
@Override
public void keyReleased(java.awt.event.KeyEvent e) { // si on relache la touche on doit arreter le vaisseau !
     Main.scene.vaisseau.setdx(0);
    
}

}
    
