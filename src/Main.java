import java.awt.*;
import Game.Game;
import MainMenu.MainMenu;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class Main {
    static JFrame mf = new JFrame();
    static Color blue1 = new Color(63,93,117);
    static Color blue2 = new Color(46,78,99);
    static Color ground_color = new Color(195,195,195);
    public static void main(String[] args) {
        /* Difficulty*/
        /* First screen player will choice game mode */

        /* Main screen for both level screen and game screen */
        
        mf.setVisible(true);
        mf.setResizable(true);
        ImageIcon icon = new ImageIcon("images/new_mine.jpg");
        mf.setIconImage(icon.getImage());
        mf.setSize(1100,900);
        mf.setLocationRelativeTo(null);/*localizes main screen at the center*/
        mf.getContentPane().setBackground(ground_color);
        mf.setLayout(new BorderLayout());
        /* ----------------------------------------- */

        /* Panels for border layout */
        MainMenu nm = new MainMenu(700,700);
        JPanel uppanel = new JPanel();
        uppanel.setPreferredSize(new Dimension(100,150));
        uppanel.setBackground(ground_color);
        JPanel downpanel = new JPanel();
        downpanel.setBackground(ground_color);
        downpanel.setPreferredSize(new Dimension(100,100));
        JPanel westpanel = new JPanel();
        westpanel.setBackground(ground_color);
        westpanel.setPreferredSize(new Dimension(200,700));
        JPanel eastpanel = new JPanel();
        eastpanel.setBackground(ground_color);
        eastpanel.setPreferredSize(new Dimension(200,700));

        /* adding panels to main screen */
        mf.add(uppanel,BorderLayout.NORTH);
        mf.add(downpanel,BorderLayout.SOUTH);
        mf.add(westpanel,BorderLayout.WEST);
        mf.add(eastpanel,BorderLayout.EAST);
        mf.add(nm.centerpanel,BorderLayout.CENTER);
        mf.setVisible(true);
        while (nm.mode == 0){
        }


        /*I want panel size to be according to game mode that is why i used if else*/
        if(nm.mode == 3){
            Game ng = new Game(3,700,1080);
            mf.remove(nm.centerpanel);
            mf.remove(westpanel);
            mf.remove(eastpanel);
            JPanel nwp = new JPanel();
            JPanel nep = new JPanel();
            nwp.setPreferredSize(new Dimension(10,700));
            nep.setPreferredSize(new Dimension(10,700));
            mf.add(ng.centerpanel,BorderLayout.CENTER);
            mf.add(nwp,BorderLayout.WEST);
            mf.add(nep,BorderLayout.EAST);
            mf.revalidate();
            mf.repaint();
        }
        else{
            Game ng = new Game(nm.mode,700,700);
            mf.remove(nm.centerpanel);
            mf.add(ng.centerpanel,BorderLayout.CENTER);
            mf.revalidate();
            mf.repaint();}
    }

}
