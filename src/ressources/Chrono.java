package ressources;

import jeu.Main;


public class Chrono implements Runnable {

 /**
 * Variables
 */
 private final int PAUSE = 5; //temps d'attente entre de tours de boucle : 5 ms
 public static int compteTours = 0;

 /**
  * Methodes
  */
  @Override
  public void run() {
      while (true) {
          // appel de la methode PaintComponent de l'objet scene
          Main.scene.repaint();
          try {Thread.sleep(PAUSE);}
          catch(InterruptedException e) {}

      }
  }
    
}