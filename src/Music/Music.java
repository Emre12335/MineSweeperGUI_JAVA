package Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Music {
    static Color blue1 = new Color(63,93,117);
    static Color blue2 = new Color(46,78,99);

    static Color blue3 = new Color(63,97,117);

    static Color blue4 = new Color(184,207,229);
    static Color ground_color = new Color(211,209,211);
    static Color ground_color2 = new Color(195,195,195);

    public JButton music_button;
    ImageIcon music_icon_on = new ImageIcon("images/note1.jpg");
    boolean on = true;
    ImageIcon music_icon_off = new ImageIcon("images/note_muted1.jpg");
    public Music(){

        music_button = new JButton(music_icon_on);
        music_button.addActionListener(e -> {
            if (e.getSource() == music_button){
                if(on){
                    music_button.setIcon(music_icon_off);
                    on = false;
                }
                else{
                    music_button.setIcon(music_icon_on);
                    on = true;
                }
            }
        });
        music_button.setPreferredSize(new Dimension(50,50));
        music_button.setBackground(ground_color2);
        music_button.setBorder(BorderFactory.createEmptyBorder());
        music_button.setFocusPainted(false);
    }
}
