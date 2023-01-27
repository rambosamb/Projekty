package Boards;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardXandO {

   private List<Point> body;

    public BoardXandO() {
        body = new ArrayList<>();

        body.add(new Point(2,5));
        body.add(new Point(2,4));
        body.add(new Point(2,3));
    }
    public void draw(Graphics g){

        g.setColor(Color.WHITE);

        g.fillOval(getO().x * Board.SIZE, getO().y*Board.SIZE, Board.SIZE, Board.SIZE);

        g.setColor(new Color(85, 111, 220));

        g.drawLine(getX().x* Board.SIZE, getX().y*Board.SIZE, Board.SIZE, Board.SIZE);
        g.drawLine(getX().x* Board.SIZE, getX().y*Board.SIZE, Board.SIZE, Board.SIZE);

    }

    private Point getX(){
        return body.get(0);
    }

    private Point getO(){
        return body.get(1);
    }
}
