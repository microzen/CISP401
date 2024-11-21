package ui.lab12;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Lab12 extends JFrame implements ActionListener, MouseListener, MouseMotionListener, ChangeListener,ComponentListener {
    private int width;
    private int height;
    private JButton button;
    private JLabel wLabel;
    private JLabel hLabel;
    private JTextField wTextField;
    private JTextField hTextField;
    private JLabel checkBoxLabel;
    private JCheckBox checkBox;
    private JLabel clickXPositionLabel;
    private JLabel clickYPositionLabel;
    private JLabel xPositionLabel;
    private JLabel yPositionLabel;
    private JSpinner widthSpinner;
    private JSpinner heightSpinner;
    private final String clickXPositionStr = "Last click X Position: ";
    private final String clickYPositionStr = "Last click Y Position: ";
    private final String xPositionStr = "Mouse X Position: ";
    private final String yPositionStr = "Mouse Y Position: ";

    public void setHeight(int height) {
        this.heightSpinner.setValue(height);
        this.hTextField.setText(String.valueOf(height));
        this.setSize(new Dimension(this.getWidth(),height));
    }
    public void setWidth(int width) {
        this.widthSpinner.setValue(width);
        this.wTextField.setText(String.valueOf(width));
        this.setSize(new Dimension(width,this.getHeight()));
    }

    public Lab12() {
        super("Lab 12");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        GridBagLayout layout = new GridBagLayout();
        setLayout (layout) ;
        button = new JButton("Reset Window Size");
        wLabel = new JLabel("Window Width:");
        hLabel = new JLabel("Window Height:");
        wTextField = new JTextField(10);
        hTextField = new JTextField(10);
        checkBoxLabel = new JLabel("Equal width and height");
        checkBox = new JCheckBox();

        JLabel winWidthLabel = new JLabel("Window Width:");
        JLabel winHeightLabel = new JLabel("Window Height:");
        this.widthSpinner = new JSpinner();
        this.heightSpinner = new JSpinner();

        clickXPositionLabel = new JLabel(clickXPositionStr);
        clickYPositionLabel = new JLabel(clickYPositionStr);
        xPositionLabel = new JLabel(xPositionStr);
        yPositionLabel = new JLabel(yPositionStr);

        GridBagConstraints cButton = new GridBagConstraints();
        cButton.gridx = 0;
        cButton.gridy = 0;
        cButton.gridheight = 3;
        cButton.gridwidth = 2;
        cButton.fill = GridBagConstraints.BOTH;

        GridBagConstraints cWLabel = new GridBagConstraints();
        cWLabel.gridx = 2;
        cWLabel.gridy = 0;
        GridBagConstraints cWField = new GridBagConstraints();
        cWField.gridx = 3;
        cWField.gridy = 0;

        GridBagConstraints cHLabel = new GridBagConstraints();
        cHLabel.gridx = 2;
        cHLabel.gridy = 1;
        GridBagConstraints cHField = new GridBagConstraints();
        cHField.gridx = 3;
        cHField.gridy = 1;

        GridBagConstraints cCheckBox = new GridBagConstraints();
        cCheckBox.gridx = 2;
        cCheckBox.gridy = 2;
        cCheckBox.gridwidth = 2;
        cCheckBox.anchor = GridBagConstraints.WEST;

        GridBagConstraints cCheckBoxLabel = new GridBagConstraints();
        cCheckBoxLabel.gridx = 2;
        cCheckBoxLabel.gridy = 2;
        cCheckBoxLabel.gridwidth = 2;
        cCheckBoxLabel.anchor = GridBagConstraints.CENTER;

        GridBagConstraints cClickXPosition = new GridBagConstraints();
        cClickXPosition.gridx = 0;
        cClickXPosition.gridy = 3;
        cClickXPosition.gridwidth = 2;

        GridBagConstraints cClickYPosition = new GridBagConstraints();
        cClickYPosition.gridx = 2;
        cClickYPosition.gridy = 3;
        cClickYPosition.gridwidth = 2;

        GridBagConstraints cXPosition = new GridBagConstraints();
        cXPosition.gridx = 0;
        cXPosition.gridy = 4;
        cXPosition.gridwidth = 2;

        GridBagConstraints cYPosition = new GridBagConstraints();
        cYPosition.gridx = 2;
        cYPosition.gridy = 4;
        cYPosition.gridwidth = 2;

        GridBagConstraints cWWLabel = new GridBagConstraints();
        cWWLabel.gridx = 0;
        cWWLabel.gridy = 5;
        cWWLabel.gridwidth = 2;

        GridBagConstraints cWJSpinner = new GridBagConstraints();
        cWJSpinner.gridx = 2;
        cWJSpinner.gridy = 5;
        cWJSpinner.gridwidth = 2;
        cWJSpinner.fill = GridBagConstraints.BOTH;

        GridBagConstraints cWHLabel = new GridBagConstraints();
        cWHLabel.gridx = 0;
        cWHLabel.gridy = 6;
        cWHLabel.gridwidth = 2;

        GridBagConstraints cHJSpinner = new GridBagConstraints();
        cHJSpinner.gridx = 2;
        cHJSpinner.gridy = 6;
        cHJSpinner.fill = GridBagConstraints.BOTH;
        cHJSpinner.gridwidth = 2;

        this.add(button,cButton);
        this.add(wLabel,cWLabel);
        this.add(hLabel,cHLabel);
        this.add(wTextField,cWField);
        this.add(hTextField,cHField);
        this.add(checkBox,cCheckBox);
        this.add(checkBoxLabel,cCheckBoxLabel);

        this.add(xPositionLabel,cXPosition);
        this.add(yPositionLabel,cYPosition);
        this.add(clickXPositionLabel,cClickXPosition);
        this.add(clickYPositionLabel,cClickYPosition);

        this.add(widthSpinner, cWJSpinner);
        this.add(heightSpinner, cHJSpinner);
        this.add(winWidthLabel, cWWLabel);
        this.add(winHeightLabel, cWHLabel);

        this.setVisible(true);
        this.pack();

        this.width = this.getWidth();
        this.height = this.getHeight();

        hTextField.setText(String.valueOf(this.height));
        wTextField.setText(String.valueOf(this.width));


        widthSpinner.setValue(this.width);
        heightSpinner.setValue(this.height);

        button.addActionListener(this);
        hTextField.addActionListener(this);
        wTextField.addActionListener(this);
        checkBox.addActionListener(this);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        widthSpinner.addChangeListener(this);
        heightSpinner.addChangeListener(this);

        this.addComponentListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button) {
            this.setSize(this.width,this.height);
            this.hTextField.setText(String.valueOf(this.height));
            this.wTextField.setText(String.valueOf(this.width));
        }
        if (e.getSource() == this.wTextField) {
            int w = Integer.parseInt(this.wTextField.getText());
            if(checkBox.isSelected()) {
                this.setSize(w,w);
            }else{
                this.setSize(w,Integer.parseInt(this.hTextField.getText()));

            }
        }
        if (e.getSource() == this.hTextField) {
            this.setSize(this.getWidth(),Integer.parseInt(this.hTextField.getText()));
        }
        if (e.getSource() == this.checkBox) {
            if (checkBox.isSelected()) {
                this.hTextField.setEditable(false);
                this.hTextField.setBackground(Color.LIGHT_GRAY);
                this.heightSpinner.setEnabled(false);
                this.heightSpinner.setBackground(Color.LIGHT_GRAY);
            }else{
                this.hTextField.setEditable(true);
                this.hTextField.setBackground(Color.WHITE);
                this.heightSpinner.setEnabled(true);
                this.heightSpinner.setBackground(Color.WHITE);
            }
            this.actionPerformed(new ActionEvent(wTextField,ActionEvent.ACTION_PERFORMED,null));
        }
    }

    public static void main(String[] args) {
        Lab12 lab12 = new Lab12();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.clickXPositionLabel.setText(clickXPositionStr + e.getX());
        this.clickYPositionLabel.setText(clickYPositionStr + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.xPositionLabel.setText(clickXPositionStr + e.getX());
        this.yPositionLabel.setText(clickYPositionStr + e.getY());
    }

    @Override
    public void componentResized(ComponentEvent e) {
        setHeight(this.getHeight());
        setWidth(this.getWidth());
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == widthSpinner) {
            this.setWidth(Integer.parseInt(this.widthSpinner.getValue().toString()));
        }
        if(e.getSource() == heightSpinner) {
            this.setHeight(Integer.parseInt(this.heightSpinner.getValue().toString()));
        }
    }
}
