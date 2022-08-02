import java.awt.*;
import Game.Game;
import Mode_buttons.Mbutton;
import javax.swing.*;
public class Main {
    static int game_mode = 0;
    public static void main(String[] args) {
        /* Difficulty*/
        /* First screen player will choice game mode */

        /* Main screen for both level screen and game screen */
        JFrame mf = new JFrame();
        mf.setVisible(true);
        mf.setResizable(true);
        ImageIcon icon = new ImageIcon("images/new_mine.jpg");
        mf.setIconImage(icon.getImage());
        mf.setSize(1100,900);
        mf.setLocationRelativeTo(null);/*localizes main screen at the center*/
         Color blue1 = new Color(63,93,117);
         Color blue2 = new Color(46,78,99);
         Color ground_color = new Color(195,195,195);
        mf.getContentPane().setBackground(ground_color);
        mf.setLayout(new BorderLayout());
        /* ----------------------------------------- */

        /* Panels for border layout */
        JPanel centerpanel = new JPanel();
        centerpanel.setPreferredSize(new Dimension(700,700));
        centerpanel.setLayout(new GridLayout(3,0,0,80));
        centerpanel.setBackground(ground_color);
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

        /* buttons for centerpanel */
        Mbutton e_but = new Mbutton("Easy",1);
        Mbutton n_but = new Mbutton("Normal",2);
        Mbutton h_but = new Mbutton("Hard",3);
        centerpanel.add(e_but);
        centerpanel.add(n_but);
        centerpanel.add(h_but);

        /* adding panels to main screen */
        mf.add(uppanel,BorderLayout.NORTH);
        mf.add(downpanel,BorderLayout.SOUTH);
        mf.add(westpanel,BorderLayout.WEST);
        mf.add(eastpanel,BorderLayout.EAST);
        mf.add(centerpanel,BorderLayout.CENTER);
        mf.setVisible(true);
        while (game_mode == 0){
            game_mode = Mbutton.mode;
            System.out.println(Mbutton.mode);
        }

        /* after opening screen game will start so we will delete buttons */
        centerpanel.remove(e_but);
        centerpanel.remove(n_but);
        centerpanel.remove(h_but);

        /*I want panel size to be according to game mode that is why i used if else*/
        if(game_mode == 3){
            Game ng = new Game(3,700,1080);
            mf.remove(centerpanel);
            mf.remove(westpanel);
            mf.remove(eastpanel);
            westpanel.setPreferredSize(new Dimension(10,700));
            eastpanel.setPreferredSize(new Dimension(10,700));
            mf.add(ng.centerpanel,BorderLayout.CENTER);
            mf.add(westpanel,BorderLayout.WEST);
            mf.add(eastpanel,BorderLayout.EAST);
            mf.revalidate();
            mf.repaint();
        }
        else{
            Game ng = new Game(game_mode,700,700);
            mf.remove(centerpanel);
            mf.add(ng.centerpanel,BorderLayout.CENTER);
            mf.revalidate();
            mf.repaint();}
    }
}
