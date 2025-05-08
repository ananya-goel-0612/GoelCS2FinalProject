// Class to manage all the buttons in the game
// Holds the location and dimensions of the button, as well as its value
// Created by Ananya Goel

import java.awt.*;

public class AnswerButton {
    private int x;
    private int y;
    private int width;
    private int height;
    private String value;
    private Color color;

    public AnswerButton(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 200;
        this.height = 50;
        this.value = "";
        this.color = Color.RED;
    }

    public AnswerButton(int x, int y, int width, int height, String value) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.value = value;
        this.color = Color.RED;
    }

    // Method to draw each button
    public void draw(Graphics g) {
        // Draws the rectangle
        g.setColor(color);
        g.fillRect(x, y, width, height);
        // Draws the value
        g.setColor(Color.BLACK);
        g.drawString(value, x + (width / 5), y + height / 2 + 10);
    }

    // Checks if the user's mouse is within the boundaries of a button
    public boolean contains(int mouseX, int mouseY) {
        if ((mouseX >= x && mouseX <= x + width) && (mouseY >= y && mouseY <= y + height)) {
            return true;
        }
        return false;
    }

    // Getters and setters
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
