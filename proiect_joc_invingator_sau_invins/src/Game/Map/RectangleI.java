package Game.Map;
import java.awt.*;

public class RectangleI {
    public Rectangle r;
    public RectangleI(int x, int y, int w, int h) {
        r = new Rectangle(x, y, w, h);
    }

    public void UpdateX(int x) {
        r.x = x;
    }
    public void UpdateY(int y) {
        r.y = y;
    }
    public int getX()
    {
        return this.r.x;
    }
    public int getY()
    {
        return this.r.y;
    }
}