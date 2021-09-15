package ressources;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {

    // ========= VARIABLES ==============

    private Clip clip;

    // =============== Constructuer ===========
    public Audio(String son) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(son));
            clip = AudioSystem.getClip();
            clip.open(audio);
        } catch (Exception e) {

        }
    }

    // ============= Methodes =============
    // pour des sons plus long, on fera des instances
    public Clip getClip() {
        return clip;
    }

    public void play() {
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

    public static void playSound(String son) { // pour un son tres court... pas d'instance à créer
        Audio s = new Audio(son);
        s.play();
    }
}