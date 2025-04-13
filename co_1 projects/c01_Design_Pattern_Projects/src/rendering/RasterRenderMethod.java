package rendering;

import java.awt.Graphics2D;
import java.awt.Color;

public class RasterRenderMethod implements RenderMethod {
    @Override
    public void drawCircle(Graphics2D g2d, int x, int y, int radius) {
        g2d.setColor(Color.BLUE);
        g2d.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public void drawSquare(Graphics2D g2d, int x, int y, int side) {
        g2d.setColor(Color.BLUE);
        g2d.fillRect(x, y, side, side);
    }
}
