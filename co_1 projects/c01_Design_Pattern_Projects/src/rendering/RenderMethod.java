package rendering;

import java.awt.Graphics2D;

public interface RenderMethod {
    void drawCircle(Graphics2D g2d, int x, int y, int radius);
    void drawSquare(Graphics2D g2d, int x, int y, int side);
}
