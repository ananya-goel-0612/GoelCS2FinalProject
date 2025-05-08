// The front-end class
// Handles all the graphics
// Created by Ananya Goel

import javax.swing.*;
import java.awt.*;

public class KpopQuizView extends JFrame {
    public static final int WINDOW_WIDTH = 1500;
    public static final int WINDOW_HEIGHT = 1000;
    // Constant for the dimensions of the home icon
    public static final int HOME_X = 5;
    public static final int HOME_DIM = 50;
    public static final int BAR_OFFSET = 23;

    private final Image home;

    private KpopQuiz game;
    private AnswerButton[] buttons;
    private AnswerButton start;
    private AnswerButton playAgain;
    private Question currentQuestion;

    public KpopQuizView(AnswerButton[] buttons, KpopQuiz game, AnswerButton start, AnswerButton playAgain) {
        this.game = game;
        this.start = start;
        this.home = new ImageIcon("Resources/home.png").getImage();
        this.buttons = buttons;
        this.playAgain = playAgain;
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("K-pop Quiz!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void displayQuestion(Question question) {
        this.currentQuestion = question;
        for (int i = 0; i < 4; i++) {
            buttons[i].setValue(question.getChoices()[i]);
        }
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        int state = game.getState();
        switch (state) {
            case KpopQuiz.HOME:
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 36));
                g.drawString("Welcome to the K-pop Quiz!", 500, 200);
                start.draw(g);
                break;
            case KpopQuiz.PLAYING:
                g.drawImage(this.home, HOME_X, BAR_OFFSET + HOME_X, HOME_DIM, HOME_DIM, this);
                if (currentQuestion != null) {
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Arial", Font.BOLD, 24));
                    g.drawString(currentQuestion.getQuestionText(), 100, 100);
                }
                for (int i = 0; i < 4; i++) {
                    buttons[i].draw(g);
                }
                break;
            case KpopQuiz.END:
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 36));
                g.drawString("Quiz Complete! Your Score: " + game.getScore() + "/10", 500, 400);
                g.drawImage(this.home, HOME_X, BAR_OFFSET + HOME_X, HOME_DIM, HOME_DIM, this);
                playAgain.draw(g);
                break;
        }
    }
}
