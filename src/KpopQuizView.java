// The front-end class
// Handles all the graphics
// Created by Ananya Goel

import javax.swing.*;
import java.awt.*;

public class KpopQuizView extends JFrame {
    // Window dimensions
    public static final int WINDOW_WIDTH = 1500;
    public static final int WINDOW_HEIGHT = 1000;
    // Constant for the dimensions of the home icon
    public static final int HOME_X = 5;
    public static final int HOME_DIM = 50;
    public static final int BAR_OFFSET = 23;

    private final Image home;
    private final Image homeBackground;
    private final Image quizBackground;
    private final Image endBackground;

    // Instance variables from the backend
    private final KpopQuiz game;
    private final AnswerButton[] buttons;
    private final AnswerButton start;
    private final AnswerButton playAgain;
    private Question currentQuestion;

    public KpopQuizView(AnswerButton[] buttons, KpopQuiz game, AnswerButton start, AnswerButton playAgain) {
        this.game = game;

        // Initialize the buttons
        this.start = start;
        this.buttons = buttons;
        this.playAgain = playAgain;

        // Load in the images
        this.home = new ImageIcon("Resources/home.png").getImage();
        this.homeBackground = new ImageIcon("Resources/homeBG.png").getImage();
        this.quizBackground = new ImageIcon("Resources/quizBG.png").getImage();
        this.endBackground = new ImageIcon("Resources/endBG.png").getImage();

        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("K-pop Quiz!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // Displays the question on the window
    public void displayQuestion(Question question) {
        this.currentQuestion = question;
        for (int i = 0; i < 4; i++) {
            buttons[i].setValue(question.getChoices()[i]);
        }
    }

    // Main paint method
    public void paint(Graphics g) {
        // Clears the window each time
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        int state = game.getState();
        switch (state) {
            case KpopQuiz.HOME:
                drawWelcomeScreen(g);
                break;
            case KpopQuiz.PLAYING:
                drawQuestion(g);
                break;
            case KpopQuiz.END:
                drawEndScreen(g);
                break;
        }
    }

    // Method to draw the welcome screen
    public void drawWelcomeScreen(Graphics g) {
        // Draws the background
        g.drawImage(homeBackground, 0,0, this);
        // Draws the title
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.drawString("Welcome to Ananya's K-pop Quiz!", 450, 200);
        // Draws the start button
        start.draw(g);
    }

    // Method to draw the end screen
    public void drawEndScreen(Graphics g) {
        // Draws the background
        g.drawImage(endBackground, 0,0,this);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        // Displays the user's score
        g.drawString("Quiz Complete! Your Score: " + game.getScore() + "/10", 500, 400);
        // Draws the home icon
        g.drawImage(this.home, HOME_X, BAR_OFFSET + HOME_X, HOME_DIM, HOME_DIM, this);
        // Draws the play again button
        playAgain.draw(g);
    }

    // Method to draw the question and the buttons
    public void drawQuestion(Graphics g) {
        // Draws the background
        g.drawImage(quizBackground, 0,0,this);
        // Draws the home icon
        g.drawImage(this.home, HOME_X, BAR_OFFSET + HOME_X, HOME_DIM, HOME_DIM, this);
        // Draws the valid question
        if (currentQuestion != null) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.drawString(currentQuestion.getQuestionText(), 100, 100);
        }

        // Draws each button with the correct values
        for (int i = 0; i < 4; i++) {
            buttons[i].draw(g);
        }
    }
}
