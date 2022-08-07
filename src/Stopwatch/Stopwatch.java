package Stopwatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends JLabel {
    public int total_seconds = 0;
    public int seconds = 0;
    public int minutes = 0;
    public int hours = 0;
    public  boolean Active = false;
    public String Second_str = String.format("%02d:%02d:%02d",hours,minutes,seconds);
    Timer t1 = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == t1 && Active){
                total_seconds++;
                hours = total_seconds / 3600;
                minutes = (total_seconds % 3600) / 60;
                seconds = (total_seconds % 3600) % 60;

                if(hours < 100){
                    Second_str = String.format("%02d:%02d:%02d",hours,minutes,seconds);
                    setText(Second_str);
                }
                else{
                    Second_str = String.format("%03d:%02d:%02d",hours,minutes,seconds);
                    setText(Second_str);
                }
            }
        }
    });

    public Stopwatch(int width,int height,Color fg){
        this.setText(Second_str);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setForeground(fg);
        this.setPreferredSize(new Dimension(width,height));
        this.setFont(new Font("Arial", Font.BOLD,40));
        t1.start();
    }
}
