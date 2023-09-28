package de.hdmstuttgart.trainingsapp.src.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import javax.sound.sampled.*;

/**
 * Klasse BGM wird von Thread abgeleitet und ist für Hintergrundmusik zuständig
 */


public class BGM extends Thread {
    private static final Logger log = LogManager.getLogger(BGM.class);

    public void run(){
        try{
            //Variabel musicPath zeigt auf die Audiodatei
            File musicPath = new File("Trainingsapp/Trainingsapp/src/main/resources/music/Yoshi.wav");
            if (musicPath.exists()){
                //Macht ein AudioInputSteam und findet die Audiodatei
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                //Öffnet die Audiodatei
                clip.open(audioInput);
                //Bekommt kontrolle über den Clip
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                //Setzt die Verstärkung des Audioclips auf 0.25
                double gain = 0.25;
                //Wandert die Verstärkung in dB um
                float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
                //setzt die Lautstärke des Clips auf entsprechende dB
                gainControl.setValue(dB);
                //Spielt den Audioclip auf endloser Schleife
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                log.info("Playing music on endless loop");
            } else {
                log.error("Music file not found");
            }
        } catch (Exception e) {
            log.error("Something wrong with Filepath" + e);
        }
    }
}
