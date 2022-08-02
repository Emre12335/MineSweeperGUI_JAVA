package Game;

import Mine.Mine;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Game implements MouseListener{
    static Color blue1 = new Color(63,93,117);
    static Color blue2 = new Color(46,78,99);

    static Color blue3 = new Color(63,97,117);

    static Color blue4 = new Color(184,207,229);
    static Color ground_color = new Color(211,209,211);
    static ImageIcon flag2 = new ImageIcon("images/flag4.jpg");
    static ImageIcon flag1 = new ImageIcon("images/flag5.jpg");
    static ImageIcon flag3 = new ImageIcon("images/flag8.jpg");

    static ImageIcon flag;
    static ImageIcon mine;

    static ImageIcon mine3 = new ImageIcon("images/new_mine4.jpg");
    static ImageIcon mine2 = new ImageIcon("images/new_mine3.jpg");
    static ImageIcon mine1 = new ImageIcon("images/new_mine2.jpg");

    public JPanel centerpanel = new JPanel();
    public Mine[][] mine_list;
    int rows;
    int columns;
    int mine_count;
    int mine_opened = 0;

    boolean game_end = false;
    public Game(int mode,int depth, int width){
        centerpanel.setPreferredSize(new Dimension(width,depth));
        centerpanel.setBackground(blue3);
        centerpanel.setBorder(BorderFactory.createLineBorder(blue2,4));
        switch (mode){
            case 1:
                rows = 9;
                columns = 9;
                mine_list = new Mine[9][9];
                mine_count = 10;
                flag = flag1;
                mine = mine1;
                break;
            case 2:
                rows = 16;
                columns = 16;
                mine_list = new Mine[16][16];
                mine_count = 40;
                flag  = flag2;
                mine = mine2;
                break;
            case 3:
                rows = 16;
                columns = 30;
                mine_list = new Mine[16][30];
                mine_count = 100;
                flag = flag3;
                mine = mine3;
            default:
                System.out.println("Something went wrong");

        }
        centerpanel.setLayout(new GridLayout(this.rows,this.columns));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mine_list[i][j] = new Mine(i,j);
                mine_list[i][j].setBackground(blue3);
                this.mine_list[i][j].setBorder(BorderFactory.createLineBorder(blue2,2));
                this.mine_list[i][j].addMouseListener(this);
                centerpanel.add(mine_list[i][j]);
            }
        }




    }

    public void generateMines(int row,int column){
        int total_nums = this.rows * this.columns;
        Random rand = new Random();
        int num = rand.nextInt(total_nums);
        int nrow = num / this.columns;
        int ncolumn = num % this.columns;
        int mine_count1 = this.mine_count;

        while(mine_count1 > 0){
            if(nrow >= row-1 && nrow <= row+1 && ncolumn >= column-1 && ncolumn <= column+1){
                num = rand.nextInt(total_nums);
                nrow = num / this.columns;
                ncolumn = num % this.columns;
            }
            else if(this.mine_list[nrow][ncolumn].getDistance() == -1){
                num = rand.nextInt(total_nums);
                nrow = num / this.columns;
                ncolumn = num % this.columns;
            }
            else{
                mine_count1--;
                this.mine_list[nrow][ncolumn].setDistance(-1);
            }
        }
    }

    public void open_one_mine(int row,int column){
        this.mine_list[row][column].setVisiblty(true);
        this.mine_list[row][column].setFlag(false);
        this.mine_list[row][column].setIcon(null);
        this.mine_list[row][column].setDisabledIcon(null);
        this.mine_list[row][column].setEnabled(false);
        this.mine_list[row][column].setBackground(ground_color);
        switch(this.mine_list[row][column].getDistance()){
            case -1:
                this.mine_list[row][column].setIcon(mine);
                this.mine_list[row][column].setDisabledIcon(mine);
                break;
            case 0:
                break;
            default:
                this.mine_list[row][column].setText(this.mine_list[row][column].getDistance()+"");
                this.mine_list[row][column].setFont(new Font("Arial",Font.PLAIN,40));
                this.mine_list[row][column].setUI(new MetalButtonUI(){
                    protected Color getDisabledTextColor() {
                        return blue2;
                    }
                });
                break;
        }

        this.mine_list[row][column].setBorder(BorderFactory.createLineBorder(blue2,2));
        // for disabled button


    }

    public void open_mine_in_game(int row,int column){
        switch(this.mine_list[row][column].getDistance()){
            case -1:
                show_answer();
                break;
            case 0:
                this.mine_list[row][column].setIcon(null);
                this.mine_list[row][column].setDisabledIcon(null);
                this.mine_list[row][column].setVisiblty(true);
                this.mine_list[row][column].setFlag(false);
                this.mine_list[row][column].setEnabled(false);
                this.mine_list[row][column].setBackground(ground_color);
                this.mine_list[row][column].setBorder(BorderFactory.createLineBorder(blue2,2));
                this.mine_opened++;
                for (int i = row-1; i <= row+1; i++) {
                    for (int j = column-1; j <= column+1; j++) {
                        if(i < 0 || j < 0 || i >= this.rows || j >= this.columns){}
                        else if (this.mine_list[i][j].getVisiblty()) {}
                        else{this.open_mine_in_game(i,j);}
                    }
                }
                break;
            default:
                this.mine_list[row][column].setIcon(null);
                this.mine_list[row][column].setDisabledIcon(null);
                this.mine_list[row][column].setFlag(false);
                this.mine_list[row][column].setVisiblty(true);
                this.mine_list[row][column].setEnabled(false);
                this.mine_list[row][column].setBackground(ground_color);
                this.mine_list[row][column].setText(this.mine_list[row][column].getDistance()+"");
                this.mine_list[row][column].setFont(new Font("Arial",Font.PLAIN,40));
                this.mine_opened++;
                this.mine_list[row][column].setUI(new MetalButtonUI(){
                    protected Color getDisabledTextColor() {
                        return blue2;
                    }
                });
                this.mine_list[row][column].setBorder(BorderFactory.createLineBorder(blue2,2));
                break;
        }
        if(this.mine_opened == this.rows * this.columns - this.mine_count ){
            this.game_end = true;
            show_answer();
        }


    }
    @SuppressWarnings("all")
    public void attempt_mine(int row,int column){
        for (int i = row-1; i <= row+1; i++) {
            for (int j = column-1; j <= column+1 ; j++) {
                if(i < 0 || j < 0 || i >= this.rows || j >= this.columns){}
                else if (this.mine_list[i][j].getDistance() == -1){}
                else {this.mine_list[i][j].setDistance(this.mine_list[i][j].getDistance()+1);}
            }

        }
    }
    public void attempt_mines(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(this.mine_list[i][j].getDistance() == -1){
                    attempt_mine(i,j);
                }
            }
        }
    }

    public void show_answer(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                open_one_mine(i,j);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Mine but = (Mine) e.getComponent();
        int a = e.getButton();
        if(a == 1){
            if(!but.getFlag() && !but.getVisiblty()){
                if(this.mine_opened == 0){
                    this.generateMines(but.row, but.column);
                    this.attempt_mines();
                    open_mine_in_game(but.row,but.column);
                }

                else {open_mine_in_game(but.row, but.column);}
            }
        }
        else if(a == 3){
            if(!but.getFlag() && !but.getVisiblty() && !this.game_end){
                but.setEnabled(false);
                but.setFlag(true);
                but.setBackground(blue4);
                but.revalidate();
                but.setIcon(flag);
                but.setDisabledIcon(flag);}
            else if(but.getFlag() && !but.getVisiblty() && !this.game_end){
                but.setEnabled(true);
                but.setFlag(false);
                but.setDisabledIcon(null);
                but.setIcon(null);
                but.setBackground(blue4);
            }
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Mine but = (Mine) e.getComponent();
        if(!but.getFlag() && !but.getVisiblty()){
            but.setBackground(blue4);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Mine but = (Mine) e.getComponent();
        if(!but.getVisiblty() && !but.getFlag()){
            but.setBackground(blue3);
        }
    }

}
