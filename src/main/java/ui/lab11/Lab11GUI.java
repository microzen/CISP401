package ui.lab11;

import javax.swing.*;
import java.awt.*;

public class Lab11GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Lab 11 GUI");

        frame.setPreferredSize(new Dimension(600, 400));
        frame.getContentPane().setBackground(new Color(255, 230, 100));

        GridBagLayout gridBagLayout = new GridBagLayout();
        frame.setLayout(gridBagLayout);

        GridBagConstraints gDrawing = new GridBagConstraints();
        gDrawing.gridx = 0;
        gDrawing.gridy = 0;
        gDrawing.gridheight = 2;
        Drawing drawing = new Drawing();
        frame.add(drawing, gDrawing);

        GridBagConstraints gButton1 = new GridBagConstraints();
        gButton1.gridx = 1;
        gButton1.gridy = 0;
        gButton1.gridwidth = 1;
        Group button1 = new Group("Button1");
        frame.add(button1, gButton1);

        GridBagConstraints gButton2 = new GridBagConstraints();
        gButton2.gridx = 1;
        gButton2.gridy = 1;
        gButton2.gridwidth = 1;
        Group button2 = new Group("Button2");
        frame.add(button2, gButton2);

        GridBagConstraints gLabel = new GridBagConstraints();
        gLabel.gridx = 0;
        gLabel.gridy = 2;
        gLabel.anchor = GridBagConstraints.WEST;
        JLabel label = new JLabel("Comments:");
        frame.add(label, gLabel);

        GridBagConstraints gText = new GridBagConstraints();
        gText.gridx = 0;
        gText.gridy = 3;
        gText.gridwidth = 2;
//        gText.fill = GridBagConstraints.HORIZONTAL;
        gText.anchor = GridBagConstraints.CENTER;
        JTextArea textArea = new JTextArea(2,48); // different between win and mac
        textArea.setText("Please type your comments here");

        frame.add(textArea, gText);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
