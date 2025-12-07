import javax.swing.*;
//import java.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;


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
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0,0,getWidth(),getHeight());

                //Here the code really starts
                List <Triangle> tris = new ArrayList();
                tris.add(new Triangle(
                        new Vertex(100,100,100),
                        new Vertex(-100,-100,100),
                        new Vertex(-100,100,-100),
                        Color.WHITE));
                tris.add(new Triangle(
                        new Vertex(100,100,100),
                        new Vertex(-100,-100,100),
                        new Vertex(100,-100,-100),
                        Color.RED));
                tris.add(new Triangle(
                        new Vertex(-100,100,-100),
                        new Vertex(-100,-100,-100),
                        new Vertex(100,100,100),
                        Color.GREEN));
                tris.add(new Triangle(
                        new Vertex(-100,100,-100),
                        new Vertex(100,-100,-100),
                        new Vertex(-100,-100,100),
                        Color.BLUE));

                g2.translate(getWidth()/2,getHeight()/2);
                g2.setColor(Color.WHITE);

                for(Triangle t : tris){
                    Path2D path = new Path2D.Double();
                    path.moveTo(t.v1.x,t.v1.y);
                    path.lineTo(t.v2.x,t.v2.y);
                    path.lineTo(t.v3.x,t.v3.y);
                    path.closePath();
                    g2.draw(path);
                }

            }
        };
        pane.add(renderPanel,BorderLayout.CENTER);



        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
