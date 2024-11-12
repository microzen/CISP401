package drawing;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Application {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 230, 100));
        frame.setTitle("Drawing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        GridBagLayout gridBagLayout = new GridBagLayout();
        frame.setLayout(gridBagLayout);

        Board board = new Board();
        JButton colorButton = new JButton("Pick Color");
        JButton clearButton = new JButton("Clear Image");
        JButton saveButton = new JButton("Save Image");
        JButton loadButton = new JButton("Load Image");
        JLabel fileNameLabel = new JLabel("File Name:");
        JTextField fileNameTextField = new JTextField(10);


        GridBagConstraints cBoard = new GridBagConstraints();
        cBoard.gridx = 0;
        cBoard.gridy = 0;
        cBoard.gridwidth = 4;
        cBoard.anchor = GridBagConstraints.CENTER;
        frame.add(board, cBoard);

        GridBagConstraints cColorButton = new GridBagConstraints();
        cColorButton.gridx = 0;
        cColorButton.gridy = 1;
        cColorButton.gridwidth = 2;
        cColorButton.fill = GridBagConstraints.BOTH;
        frame.add(colorButton, cColorButton);

        GridBagConstraints cClearButton = new GridBagConstraints();
        cClearButton.gridx = 2;
        cClearButton.gridy = 1;
        cClearButton.gridwidth = 2;
        cClearButton.fill = GridBagConstraints.BOTH;
        frame.add(clearButton, cClearButton);

        GridBagConstraints cSaveButton = new GridBagConstraints();
        cSaveButton.gridx = 0;
        cSaveButton.gridy = 2;
        frame.add(saveButton, cSaveButton);

        GridBagConstraints cLoadButton = new GridBagConstraints();
        cLoadButton.gridx = 1;
        cLoadButton.gridy = 2;
        frame.add(loadButton, cLoadButton);

        GridBagConstraints cFileNameLabel = new GridBagConstraints();
        cFileNameLabel.gridx = 2;
        cFileNameLabel.gridy = 2;
        frame.add(fileNameLabel, cFileNameLabel);

        GridBagConstraints cFileNameTextField = new GridBagConstraints();
        cFileNameTextField.gridx = 3;
        cFileNameTextField.gridy = 2;
        cFileNameTextField.fill = GridBagConstraints.BOTH;
        frame.add(fileNameTextField, cFileNameTextField);

        loadButton.addActionListener(e -> {
            FileInputStream fis;
            ObjectInputStream in;
            try {
                fis = new FileInputStream(fileNameTextField.getText().trim());
                in = new ObjectInputStream(fis);
                Object obj = in.readObject();
                board.setBoard((Color[][]) obj);
                board.repaint();
                in.close();
                fis.close();
            } catch (FileNotFoundException ex) {
                board.setBoard(null);
                board.repaint();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        frame.pack();
    }
}
