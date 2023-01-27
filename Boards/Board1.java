
package Boards;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Board1 extends JFrame implements ActionListener {


    JPanel p1, p2;
    JButton bRestart;
    JButton[] field;
    boolean move;
    boolean gameOver = false;
    String whichField = " ";


    Board1() {
        setSize(450, 520);
        setTitle("TicTacToe");
        setLocation(1200, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        p1 = new JPanel(new GridLayout(3, 3));
        p1.setPreferredSize(new Dimension(420, 420));
        field = new JButton[9];
        for (int i = 0; i < 9; i++) {
            field[i] = new JButton();
            field[i].setName(String.valueOf(i));
            field[i].setText("");
            field[i].setBackground(Color.lightGray);
            field[i].setFont(new Font("TimesRoman", Font.BOLD, 75));
            field[i].addActionListener(this);
            p1.add(field[i]);

        }
        add(p1);

        p2 = new JPanel();
        bRestart = new JButton("Restart");
        bRestart.addActionListener(this);
        p2.add(bRestart);
        add(p2);
    }

    public void restart() {
        for (int i = 0; i < 9; i++) {
            field[i].setText("");
            field[i].setBackground(Color.lightGray);
            field[i].setEnabled(true);
            gameOver = false;
        }
    }

    public void over() {
        gameOver = true;
        System.out.println("Game over");
        for (int i = 0; i < 9; i++) {
            field[i].setEnabled(false);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bRestart) {
            System.out.println("restart");
            restart();
        }
    }





}
