package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstGUI{

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JTextField textField;
    private JButton button;
    private int numOfSub;

    public JFrame getFrame() {
        return frame;
    }

    public int getNumOfSub() {
        return numOfSub;
    }

    public FirstGUI(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setTitle("KIU GPA Calculator");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420,80);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10,10));

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        label = createLabel();
        textField = createTextField();
        button = createButton();



        panel.add(label);
        panel.add(textField);
        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);
    }


    private JButton createButton(){
        JButton button = new JButton("Next");

        button.setFocusable(false);
        button.setToolTipText("Proceed To The Next Step");
        ImageIcon icon = new ImageIcon("C:\\Users\\mikhe\\Desktop\\cOdE\\Intellij\\KIU_GPA_Calculator\\src\\arrow.png");
        button.setIcon(icon);
        button.setIconTextGap(10);
        button.setHorizontalTextPosition(SwingConstants.LEFT);
        button.setVerticalTextPosition(SwingConstants.CENTER);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfSub = Integer.parseInt(textField.getText());
                //SecondGUI secondGUI = new SecondGUI();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        return  button;
    }

    private JLabel createLabel(){
        JLabel label = new JLabel("Enter The Number Of Subjects");
        label.setFont(new Font("Areal", Font.BOLD,12));
        label.setForeground(Color.CYAN);

        return label;
    }


    private JTextField createTextField(){
        JTextField textField = new JTextField(10);

        textField.setFont(new Font("Areal", Font.BOLD,12));
        //textField.setMargin(new Insets(5,5,5,5));
        textField.setToolTipText("Enter The Number Of Arshetenil Subjects");

        textField.setForeground(Color.BLACK);
        textField.setBackground(Color.CYAN);

        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (textField.getText().length() >= 1 ) // limit textfield to 1 characters
                    e.consume();
            }
        });


        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfSub = Integer.parseInt(textField.getText());
                //SecondGUI secondGUI = new SecondGUI();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });


        return textField;
    }






}
