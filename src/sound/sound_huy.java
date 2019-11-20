/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sound;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author bumte
 */
public class sound_huy {

    public static void sound(File file) {
        try {
            File dir = new File("src\\sound\\");
            String parent = dir.getAbsolutePath();
            System.out.println(parent);
            File sound = new File(parent, file.getName());

            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        } catch (Exception e) {
            System.out.println("Lỗi file âm thanh!");
        }
    }
}
