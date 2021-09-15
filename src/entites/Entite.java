package entites;

import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * Classe abstraite
 */
public abstract class Entite {
    // ========= variables ================
    /*
     * protected on ne poura acceder à ces variables que depuis les classes qui
     * heritent de cette classe Entite
     */

    protected int largeur, hauteur, xPos, yPos, dx, dy;
    protected boolean vivant;
    protected String strImg1, strImg2, strImg3;// chemin des images
    protected ImageIcon ico;
    protected Image img;

    // ========== Pas de constructeur ===============

    // =============== Methodes ====================
    public void setlargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getlargeur() {
        return largeur;
    }

    public void sethauteur(int Hauteur) {
        this.hauteur = Hauteur;
    }

    public int gethauteur() {
        return hauteur;
    }

    public void setxPos(int xpos) {
        this.xPos = xpos;
    }

    public int getxPos() {
        return xPos;
    }

    public void setyPos(int ypos) {
        this.yPos = ypos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setdx(int dx) {
        this.dx = dx;
    }

    public int getdx() {
        return dx;
    }

    public void setdy(int dy) {
        this.dy = dy;
    }

    public int getdy() {
        return dy;
    }

    public void setvivant(boolean vivant) {
        this.vivant = vivant;
    }

    public boolean isVivant() {
        return vivant;

    }

    public void setStrImg1(String strImg1) {
        this.strImg1 = strImg1;
    }

    public String getstrImg1() {
        return strImg1;
    }

    public void setStrImg2(String strImg2) {
        this.strImg2 = strImg2;
    }

    public String getstrImg2() {
        return strImg2;
    }

    public void setStrImg3(String strImg3) {
        this.strImg3 = strImg3;
    }

    public String getstrImg3() {
        return strImg3;
    }

    public void setico(ImageIcon ico) {
        this.ico = ico;
    }

    public void setimg(Image img) {
        this.img = img;
    }

    public Image getimg() {
        return img;
    }

}