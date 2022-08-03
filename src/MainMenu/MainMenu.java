package MainMenu;

import Mode_buttons.MyMenuButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainMenu implements MouseListener {
    public JPanel centerpanel = new JPanel();
    public volatile int mode = 0;

    static Color blue1 = new Color(63,93,117);
    static Color blue2 = new Color(46,78,99);

    static Color blue3 = new Color(63,97,117);

    static Color blue4 = new Color(184,207,229);
    static Color ground_color = new Color(211,209,211);
    static Color ground_color2 = new Color(195,195,195);


    public MainMenu(int width,int height){

        int width_side = width/3;
        int height_hor = height/4;
        centerpanel.setLayout(new BorderLayout());
        centerpanel.setBackground(ground_color2);
        centerpanel.setPreferredSize(new Dimension(width,height));

        JPanel cp_center = new JPanel();
        cp_center.setLayout(new GridLayout(3,0,0,height_hor/6));
        cp_center.setBackground(ground_color2);
        cp_center.setPreferredSize(new Dimension(width-2*width_side,height-2*height_hor));
        centerpanel.add(cp_center,BorderLayout.CENTER);

        JPanel cp_west = new JPanel();
        cp_west.setLayout(new BorderLayout());
        cp_west.setBackground(ground_color2);
        cp_west.setPreferredSize(new Dimension(width_side,height-2*height_hor));
        centerpanel.add(cp_west,BorderLayout.WEST);

        JPanel cp_east = new JPanel();
        cp_east.setLayout(new BorderLayout());
        cp_east.setBackground(ground_color2);
        cp_east.setPreferredSize(new Dimension(width_side,height-2*height_hor));
        centerpanel.add(cp_east,BorderLayout.EAST);

        JPanel cp_north = new JPanel();
        cp_north.setLayout(new BorderLayout());
        cp_north.setBackground(ground_color2);
        cp_north.setPreferredSize(new Dimension(width,height_hor));
        centerpanel.add(cp_north,BorderLayout.NORTH);

        JPanel cp_south = new JPanel();
        cp_south.setLayout(new BorderLayout());
        cp_south.setBackground(ground_color2);
        cp_south.setPreferredSize(new Dimension(width,height_hor));
        centerpanel.add(cp_south,BorderLayout.SOUTH);

        MyMenuButton e_but = new MyMenuButton("Easy",blue3,Color.BLACK,blue2,3);
        e_but.addMouseListener(this);
        cp_center.add(e_but);
        MyMenuButton m_but = new MyMenuButton("Medium",blue3,Color.BLACK,blue2,3);
        m_but.addMouseListener(this);
        cp_center.add(m_but);
        MyMenuButton h_but = new MyMenuButton("Hard",blue3,Color.BLACK,blue2,3);
        h_but.addMouseListener(this);
        cp_center.add(h_but);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        MyMenuButton but = (MyMenuButton)e.getComponent();
        mode = but.getOwn();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        MyMenuButton but = (MyMenuButton)e.getComponent();
        but.setBackground(blue4);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        MyMenuButton but = (MyMenuButton)e.getComponent();
        but.setBackground(blue3);
    }
}
