import javax.swing.*;
//import java.swing.*;
import java.awt.*;

public class GuiWindow {
    private JFrame frame;
    private JSlider headSlider;
    private JSlider pitchSlider;
    private JPanel renderPanel;

    public GuiWindow(){
        frame = new JFrame();
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        headSlider = new JSlider(0,360,180);
        pane.add(headSlider,BorderLayout.SOUTH);

        pitchSlider = new JSlider(SwingConstants.VERTICAL,-90,90,0);
        pane.add(pitchSlider,BorderLayout.EAST);

        renderPanel = new JPanel(){
            public void paintComponent(Graphics g){
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0,0,getWidth(),getHeight());

            }
        };
        pane.add(renderPanel,BorderLayout.CENTER);

        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
