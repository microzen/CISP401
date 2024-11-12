package ui.lab11;

import javax.swing.*;
import java.awt.*;

public class Drawing extends JPanel {
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // set the coordinates for the 3 corners of the outer triangle
        // the coordinates are stored as arrays of length 2, where element 0 is x and element 1 is y
        int[] a = {150, 0};
        int[] b = {0, 300};
        int[] c = {300, 300};

        // set the drawing color to black
        g.setColor(Color.black);

        // draw the sides of the outer triangle
        g.drawLine(a[0], a[1], b[0], b[1]);
        g.drawLine(a[0], a[1], c[0], c[1]);
        g.drawLine(c[0], c[1], b[0], b[1]);

        // create a variable to store the current point
        // its initial value should be one of the 3 corners
        int[] current = new int[2];
        current[0] = a[0];
        current[1] = a[1];

        // create the variable for the target point
        int[] target = new int[2];

        // repeat the following steps an arbitrarily large number of times
        for (int i = 0; i < 100000; i++) {

            // randomly choose one of the corners to be the target
            int num = (int) (Math.random() * 3);
            switch(num) {
                case 0: target = a;
                    break;
                case 1: target = b;
                    break;
                case 2: target = c;
                    break;
            }

            // calculate the halfway point between the current point and the target point
            // this halfway point becomes the new current point
            current[0] = Math.abs((current[0] - target[0]) / 2 + target[0]);
            current[1] = Math.abs((current[1] - target[1]) / 2 + target[1]);

            // fill in a single pixel at the new current point and repeat
            g.fillRect(current[0], current[1], 1, 1);
        }
    }
}
