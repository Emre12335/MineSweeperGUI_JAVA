package MyComboBox;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MyComboBoxRenderer extends JLabel implements ListCellRenderer{
    static Color blue1 = new Color(63,93,117);
    static Color blue2 = new Color(46,78,99);

    static Color blue3 = new Color(63,97,117);

    static Color blue4 = new Color(184,207,229);
    static Color ground_color = new Color(211,209,211);

    public MyComboBoxRenderer() {
        setOpaque(true);
        setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        setHorizontalAlignment(JLabel.CENTER);
        setBackground(blue1);
        setForeground(Color.BLACK);
        setPreferredSize(new Dimension(200,30));
        setBorder(BorderFactory.createLineBorder(blue2,1));
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.toString());
        if (isSelected) {
            this.setBackground(blue4);
            this.setForeground(blue3);
        } else {
            this.setBackground(ground_color);
            this.setForeground(blue3);

        }
        return this;
    }


}
