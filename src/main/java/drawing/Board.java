package drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Board extends JPanel implements MouseMotionListener {
    private Color[][] board;
    private Color penColor;
    private boolean penDown;
    public Board() {
        penColor = Color.BLACK;
        this.board = new Color[60][60];
        this.fillColor(Color.WHITE);
        this.addMouseMotionListener(this);
    }
    public void setPenColor(Color penColor) {
        this.penColor = penColor;
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (board == null) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            return;
        }
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                g.setColor(board[x][y]);
                g.fillRect(x*10, y*10, 10, 10);
            }
        }

    }
    public void setBoard(Color[][] board) {
        if (board == null) {
            this.fillColor(Color.WHITE);
        }else{
            this.board = board;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX() / 10;
        int y = e.getY() / 10;
        this.board[x][y] = penColor;
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    public void fillColor(Color color){
        for (int x = 0; x < 60; x++) {
            for (int y = 0; y < 60; y++) {
                this.board[x][y] = color;
            }
        }
        this.repaint();
    }
    public Color[][] getBoard() {
        Color[][] board = new Color[60][60];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                board[x][y] = this.board[x][y];
            }
        }
        return board;
    }
}
