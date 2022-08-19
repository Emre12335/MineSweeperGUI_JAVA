import java.awt.*;
import Game.Game;
import Music.Music;
import Music.Click;
import MyComboBox.MyComboBoxEditor;
import MyComboBox.MyComboBoxRenderer;
import Stopwatch.Stopwatch;

import javax.swing.*;

public class Main {
    static JLabel label;
    static Stopwatch sw;

    static JLabel filabel;
    static JFrame mf = new JFrame("Minesweeper");
    static JPanel uppanel = new JPanel();
    static JPanel downpanel = new JPanel();
    static JPanel westpanel = new JPanel();
    static JPanel eastpanel = new JPanel();
    static JPanel centerpanel = new JPanel();
    static Game ng;

    static Color blue1 = new Color(63,93,117);
    static Color blue2 = new Color(46,78,99);
    static Color ground_color = new Color(195,195,195);
    static Color ground_color2 = new Color(211,209,210);
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

        /* ------------ */
        String [] boxOptions = {"Easy","Medium","Hard"};
        JComboBox<String> cb = new JComboBox<>(boxOptions);
        cb.setPreferredSize(new Dimension(200,50));
        cb.setEditable(true);
        cb.setRenderer(new MyComboBoxRenderer());
        cb.setEditor(new MyComboBoxEditor());
        uppanel.add(Box.createVerticalStrut(170));
        uppanel.add(cb);

        /* Horizontal structs for between componenets */
        Component cb_flagl = Box.createHorizontalStrut(150);
        Component flagl_sw = Box.createHorizontalStrut(20);
        Component sw_mb = Box.createHorizontalStrut(50);


        cb.addActionListener(e -> {
            if(e.getSource() == cb){
                String msg = (String)cb.getSelectedItem();
                if (msg != null) {
                    switch (msg){
                        case "Easy":
                            ng = new Game(1,700,700);
                            mf.remove(centerpanel);
                            mf.remove(westpanel);
                            mf.remove(eastpanel);
                            westpanel = new JPanel();
                            eastpanel = new JPanel();
                            eastpanel.setBackground(ground_color);
                            westpanel.setBackground(ground_color);
                            centerpanel = ng.centerpanel;
                            westpanel.setPreferredSize(new Dimension(200,700));
                            eastpanel.setPreferredSize(new Dimension(200,700));
                            mf.add(centerpanel,BorderLayout.CENTER);
                            mf.add(westpanel,BorderLayout.WEST);
                            mf.add(eastpanel,BorderLayout.EAST);
                            if(label == null){
                                uppanel.add(cb_flagl);
                                label = ng.flag_label;
                                filabel = ng.flag_image_label;
                                uppanel.add(filabel);
                                uppanel.add(label);
                            }
                            else{
                                uppanel.remove(filabel);
                                uppanel.remove(label);
                                uppanel.remove(cb_flagl);
                                label = ng.flag_label;
                                uppanel.add(cb_flagl);
                                uppanel.add(filabel);
                                uppanel.add(label);}
                            if(sw == null){
                                uppanel.add(flagl_sw);
                                sw = ng.sw1;
                                uppanel.add(sw);
                            }
                            else{
                                uppanel.remove(flagl_sw);
                                uppanel.remove(sw);
                                sw = ng.sw1;
                                uppanel.add(flagl_sw);
                                uppanel.add(sw);
                            }
                            mf.revalidate();
                            mf.repaint();
                            break;
                        case "Medium":
                            ng = new Game(2,700,700);
                            mf.remove(centerpanel);
                            mf.remove(westpanel);
                            mf.remove(eastpanel);
                            westpanel = new JPanel();
                            eastpanel = new JPanel();
                            eastpanel.setBackground(ground_color);
                            westpanel.setBackground(ground_color);
                            centerpanel = ng.centerpanel;
                            westpanel.setPreferredSize(new Dimension(200,700));
                            eastpanel.setPreferredSize(new Dimension(200,700));
                            mf.add(westpanel,BorderLayout.WEST);
                            mf.add(eastpanel,BorderLayout.EAST);
                            mf.add(centerpanel,BorderLayout.CENTER);
                            if(label == null){
                                uppanel.add(cb_flagl);
                                label = ng.flag_label;
                                filabel = ng.flag_image_label;
                                uppanel.add(filabel);
                                uppanel.add(label);
                            }
                            else{
                                uppanel.remove(filabel);
                                uppanel.remove(label);
                                uppanel.remove(cb_flagl);
                                label = ng.flag_label;
                                uppanel.add(cb_flagl);
                                uppanel.add(filabel);
                                uppanel.add(label);}
                            if(sw == null){
                                uppanel.add(flagl_sw);
                                sw = ng.sw1;
                                uppanel.add(sw);
                            }
                            else{
                                uppanel.remove(flagl_sw);
                                uppanel.remove(sw);
                                sw = ng.sw1;
                                uppanel.add(flagl_sw);
                                uppanel.add(sw);
                            }
                            mf.revalidate();
                            mf.repaint();

                            break;
                        case "Hard":
                            ng = new Game(3,700,1080);
                            mf.remove(centerpanel);
                            mf.remove(westpanel);
                            mf.remove(eastpanel);
                            westpanel = new JPanel();
                            eastpanel = new JPanel();
                            eastpanel.setBackground(ground_color);
                            westpanel.setBackground(ground_color);
                            centerpanel = ng.centerpanel;
                            westpanel.setPreferredSize(new Dimension(10,700));
                            eastpanel.setPreferredSize(new Dimension(10,700));
                            mf.add(westpanel,BorderLayout.WEST);
                            mf.add(eastpanel,BorderLayout.EAST);
                            mf.add(centerpanel,BorderLayout.CENTER);
                            if(label == null){
                                uppanel.add(cb_flagl);
                                label = ng.flag_label;
                                filabel = ng.flag_image_label;
                                uppanel.add(filabel);
                                uppanel.add(label);
                            }
                            else{
                                uppanel.remove(filabel);
                                uppanel.remove(label);
                                uppanel.remove(cb_flagl);
                                label = ng.flag_label;
                                uppanel.add(cb_flagl);
                                uppanel.add(filabel);
                                uppanel.add(label);}
                            if(sw == null){
                                uppanel.add(flagl_sw);
                                sw = ng.sw1;
                                uppanel.add(sw);
                            }
                            else{
                                uppanel.remove(flagl_sw);
                                uppanel.remove(sw);
                                sw = ng.sw1;
                                uppanel.add(flagl_sw);
                                uppanel.add(sw);
                            }
                            mf.revalidate();
                            mf.repaint();
                            break;

                    }
                }
            }
        });
        cb.setSelectedIndex(0);
        cb.getEditor().getEditorComponent().setBackground(ground_color2);

        /* Panels for border layout */


        uppanel.setPreferredSize(new Dimension(100,150));
        uppanel.setBackground(ground_color);

        downpanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        Music nm = new Music();
        Click nc = new Click();
        downpanel.add(Box.createVerticalStrut(120));
        downpanel.add(nc.click_button);
        downpanel.add(nm.music_button);
        downpanel.add(Box.createHorizontalStrut(30));
        downpanel.setBackground(ground_color);
        downpanel.setPreferredSize(new Dimension(100,100));

        westpanel.setBackground(ground_color);
        westpanel.setPreferredSize(new Dimension(200,700));

        eastpanel.setBackground(ground_color);
        eastpanel.setPreferredSize(new Dimension(200,700));





        /* adding panels to main screen */
        mf.add(uppanel,BorderLayout.NORTH);
        mf.add(downpanel,BorderLayout.SOUTH);
        mf.add(westpanel,BorderLayout.WEST);
        mf.add(eastpanel,BorderLayout.EAST);
        mf.setVisible(true);}




}
