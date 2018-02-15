import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class GUIEventDemo extends JFrame {
    private JLabel jlbMessage = new JLabel("Hello", JLabel.CENTER);


    private JCheckBox jchkBold = new JCheckBox("Bold");
    private JCheckBox jchkItalic = new JCheckBox("Italic");


    private JRadioButton jrbRed = new JRadioButton("Red");
    private JRadioButton jrbBlue = new JRadioButton("Blue");
    private JRadioButton jrbGreen = new JRadioButton("Green");


    private JTextField jtfMessage = new JTextField(10);

    public static void main(String[] args) {
        GUIEventDemo frame = new GUIEventDemo();
        frame.setTitle("GUIEventDemo");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }


    public GUIEventDemo() {
        jlbMessage.setBorder(new LineBorder(Color.BLACK,2));
        add(jlbMessage,BorderLayout.CENTER);

        JPanel jpCheckBoxes = new JPanel();
        jpCheckBoxes.setLayout(new GridLayout(2,1));
        jpCheckBoxes.add(jchkBold);
        jpCheckBoxes.add(jchkItalic);
        add(jpCheckBoxes, BorderLayout.EAST);

        JPanel jpRadioButtons = new JPanel();
        jpRadioButtons.setLayout(new GridLayout(3,1));
        jpRadioButtons.add(jrbRed);
        jpRadioButtons.add(jrbBlue);
        jpRadioButtons.add(jrbGreen);
        add(jpRadioButtons,BorderLayout.WEST);


        ButtonGroup group = new ButtonGroup();
        group.add(jrbBlue);
        group.add(jrbRed);
        group.add(jrbGreen);


        jrbBlue.setSelected(true);
        jlbMessage.setForeground(Color.BLUE);


        JPanel jpTextField = new JPanel();
        jpTextField.setLayout(new BorderLayout(5,0));
        jpTextField.add(new JLabel("Enter a new Message"), BorderLayout.WEST);
        jpTextField.add(jtfMessage,BorderLayout.CENTER);
        jtfMessage.setHorizontalAlignment(JTextField.RIGHT);
        add(jpTextField,BorderLayout.NORTH);


        jchkBold.setMnemonic('B');
        jchkItalic.setMnemonic('I');
        jrbRed.setMnemonic('E');
        jrbGreen.setMnemonic('G');
        jrbBlue.setMnemonic('U');


        jchkBold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNewFont();
            }
        });
        jchkItalic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNewFont();
            }
        });
        jrbRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbMessage.setForeground(Color.red);
            }
        });
        jrbBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbMessage.setForeground(Color.blue);
            }
        });
        jrbGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbMessage.setForeground(Color.green);
            }
        });
        jtfMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbMessage.setText(jtfMessage.getText());
                jtfMessage.requestFocusInWindow();
            }
        });
    }
    private void setNewFont() {
        int fontStyle = Font.PLAIN;
        fontStyle += (jchkBold.isSelected() ? Font.BOLD : Font.PLAIN);
        fontStyle += (jchkItalic.isSelected() ? Font.ITALIC : Font.PLAIN);


        Font font = jlbMessage.getFont();
        jlbMessage.setFont(new Font(font.getName(), fontStyle, font.getSize()));
    }
}
