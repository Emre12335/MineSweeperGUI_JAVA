package Mine;

import javax.swing.*;

public class Mine extends JButton {
    private int distance = 0;
    private boolean flag = false;
    private boolean visiblty = false;
    public int column;
    public int row;

    public Mine(int row,int column){
        this.setFocusPainted(false);
        this.row = row;
        this.column = column;
    }
    public int getDistance(){
        return this.distance;
    }
    public void setDistance(int distance){
        this.distance = distance;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getVisiblty() {
        return visiblty;
    }
    public void setVisiblty(boolean visible) {
        this.visiblty = visible;
    }
}
