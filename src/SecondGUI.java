import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondGUI{

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    //private JPanel southPanel;
    private JTextField textField;
    private JTextField creditsTextField;
    private JButton button;
    private final int numOfSub;
    public static ArrayList<Subject> subjectList = new ArrayList<>();
    private static final List<Double> points = new ArrayList<>();
    private static final List<Integer> credits = new ArrayList<>();

    private List<JTextField> txtFields = new ArrayList<>();

    private final HashMap<Double,Integer> pointsAndCreds = new HashMap<>();

    public SecondGUI(){
        numOfSub = Main.numberOfSubjects;
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    private void initialize(){
        frame = new JFrame();
        frame.setTitle("KIU GPA Calculator");
        frame.setSize(420,200);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        panel = new JPanel();
        panel.setBackground(Color.black);
        label = createLabel();
        JLabel label2 = createLabel2();
        panel.setLayout(new GridLayout(numOfSub + 2, 2));
        button = createButton();



        panel.add(label);
        panel.add(label2);
        for (int i = 0; i < numOfSub; i++) {
            textField = createTextField();
            panel.add(textField);
            creditsTextField = createCreditTextField();
            panel.add(creditsTextField);
            txtFields.add(textField);
            txtFields.add(creditsTextField);
        }
        panel.add(button);


        frame.add(panel, BorderLayout.CENTER);
        //frame.add(southPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private JTextField createTextField(){
        JTextField textField = new JTextField(10);

        textField.setFont(new Font("Areal", Font.BOLD,12));
        //textField.setMargin(new Insets(5,5,5,5));
        textField.setToolTipText("Enter Your Points");

        textField.setForeground(Color.BLACK);
        textField.setBackground(Color.CYAN);

        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (textField.getText().length() >= 4 ) // limit textfield to 1 characters
                    e.consume();
            }
        });

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                points.add(Double.parseDouble(textField.getText()));
            }
        });

        return textField;
    }

    private JTextField createCreditTextField(){
        JTextField textField = new JTextField(10);

        textField.setFont(new Font("Areal", Font.BOLD,12));
        //textField.setMargin(new Insets(5,5,5,5));
        textField.setToolTipText("Enter The Number Of Credits");

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
                credits.add(Integer.parseInt(textField.getText()));
            }
        });

        return textField;
    }

    private void addToMap(){
        for (int i = 0; i < numOfSub; i++) {
            pointsAndCreds.put(points.get(i), credits.get(i));
        }

    }


    private JLabel createLabel(){
        JLabel label = new JLabel("Enter Your Points");
        label.setFont(new Font("Areal", Font.BOLD,12));
        label.setForeground(Color.CYAN);

        return label;
    }

    private JLabel createLabel2(){
        JLabel label = new JLabel("Enter Number Of Credits");
        label.setFont(new Font("Areal", Font.BOLD,12));
        label.setForeground(Color.CYAN);

        return label;
    }

    private JButton createButton(){
        JButton button = new JButton("Next");

        button.setFocusable(false);
        button.setToolTipText("Press To View Your GPA");
        ImageIcon icon = new ImageIcon("arrow.png");
        button.setIcon(icon);
        button.setIconTextGap(10);
        button.setHorizontalTextPosition(SwingConstants.LEFT);
        button.setVerticalTextPosition(SwingConstants.CENTER);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                for (int i = 0; i < txtFields.size(); i += 2) {
                    pointsAndCreds.put(Double.parseDouble(txtFields.get(i).getText().toString()),
                            Integer.parseInt(txtFields.get(i +1).getText().toString()));

                    Subject subject = new Subject(Double.parseDouble(txtFields.get(i).getText().toString()),
                            Integer.parseInt(txtFields.get(i + 1).getText().toString()));

                    subjectList.add(subject);
                }

                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        return  button;
    }


}


