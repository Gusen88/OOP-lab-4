import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Main extends JPanel {

    double theta = 0;
    double deltaTheta = Math.PI / 90;
    int x = 0;
    int deltaX = 1;
    int side = 100;

    public Main() {
        Timer timer = new Timer(10, e -> {
            theta += deltaTheta;
            x += deltaX;
            if (x > getWidth() - side || x < 0) {
                deltaX *= -1;
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.translate(x, getHeight() / 2);
        g2d.rotate(theta);
        Rectangle2D rectangle = new Rectangle2D.Double(-side / 2, -side / 2, side, side);
        g2d.draw(rectangle);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new Main(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
