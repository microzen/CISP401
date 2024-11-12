package drawing;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    Color[][] board;
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
        this.board = board;
    }
}
