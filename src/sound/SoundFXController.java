//Controls sound and audio output

package sound;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.sound.sampled.*;

public class SoundFXController {
    
    public static File Sound;
    public static Clip clip;

    public static void changeFX(File playMe) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
    //Change clip binding and play audio 
    //Do not call me manually, unless you know what you are doing
        clip = AudioSystem.getClip(); //initialize clip
        clip.open(AudioSystem.getAudioInputStream(playMe)); //Get audio stream and bind to clip
        clip.start(); //Play clip (sound)
    }
    
    public static void startAudio() {
        clip.start(); //Play clip
    }
    
    public static void swordFX() throws UnsupportedAudioFileException, LineUnavailableException, IOException, MalformedURLException, InterruptedException {
        switch (ThreadLocalRandom.current().nextInt(0, 2)) { //Random clip from 0-1 (2 options)
            case 0:
                Sound = new File("./src/Sound/FX/swordOne.wav"); //Clip one
                break;
            case 1:
                Sound = new File("./src/Sound/FX/swordTwo.wav"); //Clip two
                break;
        }
        changeFX(Sound); //Change clip and play sound
    }
    
    public static void effectOne() throws UnsupportedAudioFileException, LineUnavailableException, IOException, MalformedURLException, InterruptedException {
        Sound = new File("./src/Sound/FX/effectOne.wav");
        changeFX(Sound);
    }
    
    public static void effectTwo() throws UnsupportedAudioFileException, LineUnavailableException, IOException, MalformedURLException, InterruptedException {
        Sound = new File("./src/Sound/FX/effectTwo.wav");
        changeFX(Sound);
    }

    public static void effectThree() throws UnsupportedAudioFileException, LineUnavailableException, IOException, MalformedURLException, InterruptedException {
        Sound = new File("./src/Sound/FX/effectThree.wav");
        changeFX(Sound);
    }
    
}
