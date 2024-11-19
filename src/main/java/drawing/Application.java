package drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Application extends JFrame implements ActionListener {
    private JButton colorButton;
    private JButton clearButton;
    private JButton saveButton;
    private JButton loadButton;
    private Board board;
    private JTextField fileNameTextField;
    public Application(){
        this.setTitle("Drawing Application");
        this.board = new Board();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout (layout) ;

        board = new Board();
        colorButton = new JButton("Pick Color");
        clearButton = new JButton("Clear Image");
        saveButton = new JButton("Save Image");
        loadButton = new JButton("Load Image");
        fileNameTextField = new JTextField(10);
        JLabel fileNameLabel = new JLabel("File Name:");

        GridBagConstraints cBoard = new GridBagConstraints();
        cBoard.gridx = 0;
        cBoard.gridy = 0;
        cBoard.gridwidth = 4;
        cBoard.anchor = GridBagConstraints.CENTER;
        this.add(board, cBoard);

        GridBagConstraints cColorButton = new GridBagConstraints();
        cColorButton.gridx = 0;
        cColorButton.gridy = 1;
        cColorButton.gridwidth = 2;
        cColorButton.fill = GridBagConstraints.BOTH;
        this.add(colorButton, cColorButton);

        GridBagConstraints cClearButton = new GridBagConstraints();
        cClearButton.gridx = 2;
        cClearButton.gridy = 1;
        cClearButton.gridwidth = 2;
        cClearButton.fill = GridBagConstraints.BOTH;
        this.add(clearButton, cClearButton);

        GridBagConstraints cSaveButton = new GridBagConstraints();
        cSaveButton.gridx = 0;
        cSaveButton.gridy = 2;
        this.add(saveButton, cSaveButton);

        GridBagConstraints cLoadButton = new GridBagConstraints();
        cLoadButton.gridx = 1;
        cLoadButton.gridy = 2;
        this.add(loadButton, cLoadButton);

        GridBagConstraints cFileNameLabel = new GridBagConstraints();
        cFileNameLabel.gridx = 2;
        cFileNameLabel.gridy = 2;
        this.add(fileNameLabel, cFileNameLabel);

        GridBagConstraints cFileNameTextField = new GridBagConstraints();
        cFileNameTextField.gridx = 3;
        cFileNameTextField.gridy = 2;
        cFileNameTextField.fill = GridBagConstraints.BOTH;
        this.add(fileNameTextField, cFileNameTextField);

        this.pack();

        this.loadButton.addActionListener(this);
        this.colorButton.addActionListener(this);
        this.clearButton.addActionListener(this);
        this.saveButton.addActionListener(this);
    }
    public static void main(String[] args) {

        Application app = new Application();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.loadButton) {
            this.loadImage();
        }
        if (e.getSource() == this.colorButton) {
            this.pickColorAction();
        }
        if(e.getSource() == this.clearButton){
            this.clearImage();
        }
        if(e.getSource() == this.saveButton){
            this.saveImage();
        }
    }
    private void pickColorAction(){
        JColorChooser colorChooser = new JColorChooser();
        this.board.setPenColor(colorChooser.showDialog(this, "Choose Color", colorChooser.getColor()));
    }
    private void loadImage(){
        JFileChooser fileChooser = new JFileChooser("./");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileNameTextField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                FileInputStream fis = new FileInputStream(fileChooser.getSelectedFile());
                ObjectInputStream in = new ObjectInputStream(fis);
                Object obj = in.readObject();
                board.setBoard((Color[][]) obj);
                board.repaint();
                in.close();
                fis.close();
            } catch (FileNotFoundException ex) {
                board.setBoard(null);
                board.repaint();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error load image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
    private void saveImage(){
        JFileChooser fileChooser = new JFileChooser("./");
        fileChooser.setDialogTitle("Save Image");

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String fileName = fileToSave.getName();
            if (!fileName.endsWith(".bin")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".bin");
            }
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileToSave));
                out.writeObject(board.getBoard());
                JOptionPane.showMessageDialog(this, "Image saved successfully: " + fileToSave.getAbsolutePath());
                out.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    private void clearImage(){
        board.FillColor(Color.white);
    }
}
