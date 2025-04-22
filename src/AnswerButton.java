import java.awt.*;

public class AnswerButton {
    private int x;
    private int y;
    private int width;
    private int height;
    private String value;
    private Color color;

    public AnswerButton(String value) {
        this.x = 200;
        this.y = 200;
        this.width = 300;
        this.height = 100;
        this.value = value;
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

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
