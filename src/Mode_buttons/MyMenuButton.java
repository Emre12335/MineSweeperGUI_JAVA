package Mode_buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class MyMenuButton extends JButton {
    static int count = 0;
    int own;
    public MyMenuButton(String name, Color bg_color,Color fg_color,Color border_color,int thickness){
        super(name);
        this.setFont(new Font("Arial",Font.PLAIN,40));
        this.setForeground(fg_color);
        this.setBackground(bg_color);
        this.setBorder(BorderFactory.createLineBorder(border_color,thickness));
        count++;
        this.own = count;
    }

    public int getOwn(){
        return own;
    }
}
