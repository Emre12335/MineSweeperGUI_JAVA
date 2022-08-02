package Mode_buttons;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mbutton extends JButton implements ActionListener {
    public static int mode;
    int own_mode;
    static Color blue1 = new Color(63,93,117);
    static Color blue2 = new Color(46,78,99);
    static Color ground_color = new Color(195,195,195);
    public Mbutton(String name, int o_mode){
        super(name);
        this.setFont(new Font("Arial",Font.PLAIN,40));
        //this.setForeground(ground_color);
        this.own_mode = o_mode;
        this.setBackground(blue1);
        this.setBorder(BorderFactory.createLineBorder(blue2,5));
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this){
           mode = this.own_mode;
        }
    }
}
