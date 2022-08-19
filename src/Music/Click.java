package Music;

import javax.swing.*;
import java.awt.*;

public class Click {
    static Color blue1 = new Color(63,93,117);
    static Color blue2 = new Color(46,78,99);

    static Color blue3 = new Color(63,97,117);

    static Color blue4 = new Color(184,207,229);
    static Color ground_color = new Color(211,209,211);
    static Color ground_color2 = new Color(195,195,195);
    public JButton click_button;
    ImageIcon click_icon_on = new ImageIcon("images/vol_on.jpg");
    boolean on = true;
    ImageIcon click_icon_off = new ImageIcon("images/vol_off.jpg");
    public Click(){

        click_button = new JButton(click_icon_on);
        click_button.addActionListener(e -> {
            if (e.getSource() == click_button){
                if(on){
                    click_button.setIcon(click_icon_off);
                    on = false;
                }
                else{
                    click_button.setIcon(click_icon_on);
                    on = true;
                }
            }
        });
        click_button.setPreferredSize(new Dimension(50,50));
        click_button.setBackground(ground_color2);
        click_button.setBorder(BorderFactory.createEmptyBorder());
        click_button.setFocusPainted(false);
    }
}
