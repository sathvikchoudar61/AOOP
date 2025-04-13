package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import shapes.Circle;
import shapes.Square;
import shapes.Shape;
import rendering.RenderMethod;
import rendering.VectorRenderMethod;
import rendering.RasterRenderMethod;

public class DrawingApp extends JPanel {
    private Shape shape;
    private RenderMethod vectorRenderer;
    private RenderMethod rasterRenderer;

    public DrawingApp() {
        vectorRenderer = new VectorRenderMethod();
        rasterRenderer = new RasterRenderMethod();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) { // Left click
                    shape = new Circle(e.getX(), e.getY(), 50);
                } else if (e.getButton() == MouseEvent.BUTTON3) { // Right click
                    shape = new Square(e.getX(), e.getY(), 100);
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (shape != null) {
            if (shape instanceof Circle) {
                shape.draw(g2d, vectorRenderer);
            } else {
                shape.draw(g2d, rasterRenderer);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Application");
        DrawingApp drawingApp = new DrawingApp();
        frame.add(drawingApp);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
