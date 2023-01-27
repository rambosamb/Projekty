package Boards;
import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("TicTacToe");
        add(new MainPanel());
        pack();
        setLocationRelativeTo(null);
        setResizable(false);



    }
}
