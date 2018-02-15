import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MultipleWindowsDemo extends JFrame {
    private JTextArea jta;
    private JButton jbtShowHistogram = new JButton("Show Histogram");
    private Histogram histogram = new Histogram();
    private JFrame histogrameFrame = new JFrame();

    public MultipleWindowsDemo() {
        JScrollPane scrollPane = new JScrollPane(jta = new JTextArea());
        scrollPane.setPreferredSize(new Dimension(300,200));
        jta.setWrapStyleWord(true);
        jta.setLineWrap(true);

        add(scrollPane,BorderLayout.CENTER);
        add(jbtShowHistogram,BorderLayout.SOUTH);

        jbtShowHistogram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] count = countLetters();
                histogram.showHistogram(count);
                histogrameFrame.setVisible(true);
            }
        });
        histogrameFrame.add(histogram);
        histogrameFrame.pack();
        histogrameFrame.setTitle("Histogram");
    }
    private int[] countLetters() {
        int[] count = new int[26];
        String text = jta.getText();
        for(int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if(character >= 'A' && character <= 'Z') {
                count[character-'A']++;
            } else if(character>= 'a' && character<='z') {
                count[character-'a']++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        MultipleWindowsDemo frame = new MultipleWindowsDemo();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("MultipleWindowsDemo");
        frame.setVisible(true);
        frame.pack();
    }
}
