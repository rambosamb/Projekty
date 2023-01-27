package Boards;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private BoardXandO boardXandO = new BoardXandO();
    public MainPanel() {
        setPreferredSize(new Dimension(Board.MAX_X, Board.MAX_Y));


    }

    @Override
    protected void paintComponent(Graphics g) {
        Board.draw(g);
        boardXandO.draw(g);
    }
}
