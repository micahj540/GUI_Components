import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScrollBarDemo extends JFrame {
    private JScrollBar jscbHort = new JScrollBar(JScrollBar.HORIZONTAL);
    private JScrollBar jscbVert = new JScrollBar(JScrollBar.VERTICAL);

    private MessagePanel messagePanel = new MessagePanel("Welcome to Java");

    public static void main(String[] args) {
        ScrollBarDemo frame = new ScrollBarDemo();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("ScrollBarDemo");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.pack();
    }

    public ScrollBarDemo() {
        setLayout(new BorderLayout());
        add(messagePanel, BorderLayout.CENTER);
        add(jscbVert, BorderLayout.EAST);
        add(jscbHort, BorderLayout.SOUTH);

        jscbHort.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                double value = jscbHort.getValue();
                double maximumValue = jscbHort.getMaximum();
                double newX = (value * messagePanel.getWidth() / maximumValue);
                messagePanel.setxCoordinate((int)newX);
            }
        });
        jscbVert.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                double value = jscbVert.getValue();
                double maximumValue = jscbVert.getMaximum();
                double newY = (value * messagePanel.getHeight() / maximumValue);
                messagePanel.setyCoordinate((int)newY);
            }
        });
    }
}
