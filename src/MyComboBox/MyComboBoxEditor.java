package MyComboBox;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxEditor;

import static javax.swing.SwingConstants.CENTER;

public class MyComboBoxEditor extends BasicComboBoxEditor {
    static Color blue1 = new Color(63,93,117);
    static Color blue2 = new Color(46,78,99);

    static Color blue3 = new Color(63,97,117);

    static Color blue4 = new Color(184,207,229);
    static Color ground_color = new Color(211,209,211);
    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();
    private Object selectedItem;

    public MyComboBoxEditor() {

        label.setOpaque(false);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(blue1);
        label.setHorizontalAlignment(CENTER);

        panel.setLayout(new BorderLayout());
        panel.add(label,BorderLayout.CENTER);
        panel.setBackground(ground_color);
    }

    public Component getEditorComponent() {
        return this.panel;
    }

    public Object getItem() {
        return this.selectedItem.toString();
    }

    public void setItem(Object item) {
        this.selectedItem = item;
        label.setText(item.toString());
    }

}
