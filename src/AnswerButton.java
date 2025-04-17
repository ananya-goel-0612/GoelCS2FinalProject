import java.awt.*;

public class AnswerButton {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public AnswerButton() {
        this.x = 200;
        this.y = 200;
        this.width = 300;
        this.height = 100;
        this.color = Color.RED;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public boolean contains(int mouseX, int mouseY) {
        if ((mouseX >= x && mouseX <= x + width) && (mouseY >= y && mouseY <= y + height)) {
            return true;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
