package ui.lab11;

import javax.swing.*;
import java.awt.*;

public class Group extends JPanel {
    public Group(String labelText){

        setBackground(Color.GREEN);
        FlowLayout layout = new FlowLayout();
        setLayout (layout) ;
        JLabel label = new JLabel (labelText);
        add (label);
        JButton button = new JButton ("Press me!");
        add (button) ;

        JTextField textField = new JTextField();
        textField.setBackground(Color.blue);
        textField.setForeground(Color.white);
        textField.setText("Exit text here");
        add(textField);
//        setText("");
    }
}
