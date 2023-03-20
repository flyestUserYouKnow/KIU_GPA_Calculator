import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.text.DecimalFormat;

public class ThirdGUI {

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JLabel label2;
    private JButton button;
    private DecimalFormat df = new DecimalFormat("0.00");
//    double gpa = Main.gpa;
//    String gpaToString = df.format(gpa);
    Double gpa = Main.gpa;
    public ThirdGUI(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setTitle("KIU GPA Calculator");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 80);

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        label = createLabel();
        label2 = createLabel2();
        button = createButton();


        panel.add(label);
        panel.add(label2);
        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);
    }


    private JLabel createLabel(){
        JLabel label = new JLabel("Your GPA Is:");
        label.setFont(new Font("Areal", Font.BOLD,12));
        label.setForeground(Color.CYAN);

        return label;
    }

    private String gpaToString(Double gpa){
        String gpaToString;
        if(!gpa.isNaN()){
            gpaToString = df.format(gpa);
        }else{
            gpaToString = "INVALID INPUT";
        }

        return gpaToString;
    }

    private JLabel createLabel2(){
        JLabel label = new JLabel(gpaToString(gpa));
        label.setFont(new Font("Areal", Font.BOLD,12));
        if(gpa > 3) {
            label.setForeground(Color.GREEN);
        }else{
            label.setForeground(Color.RED);
        }


        return label;
    }


    private JButton createButton(){
        JButton button = new JButton("Close");

        button.setFocusable(false);
        button.setToolTipText("Press To Close");
        ImageIcon icon = new ImageIcon("x icon2.png");
        button.setIcon(icon);
        button.setIconTextGap(10);
        button.setHorizontalTextPosition(SwingConstants.LEFT);
        button.setVerticalTextPosition(SwingConstants.CENTER);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        return  button;
    }


}
