// Backend for the Kpop Quiz
// Manages all the logic of the game
// Created by Ananya Goel

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class KpopQuiz implements MouseListener, MouseMotionListener, ActionListener {

    // Instance variables
    private final QuizManager quizManager;
    private final KpopQuizView window;
    private final ArrayList<Question> questions;
    private String userAnswer;
    private int currentQuestionIndex;

    // Buttons
    private final AnswerButton[] buttons;
    private final AnswerButton start;
    private final AnswerButton playAgain;

    // Game states
    private int state;
    public static final int HOME = 0;
    public static final int PLAYING = 1;
    public static final int END = 2;

    // Constants
    public static final int SPACING_Y_BUFFER = 150;
    public static final int SPACING_X_BUFFER = 300;
    public static final int START_COORDINATE = 500;
    public static final int NUM_QUESTIONS = 10;

    private final Timer clock;
    public static final int DELAY_IN_MILLISECONDS = 20;

    // Initalizes the game
    public KpopQuiz() {
        state = HOME;
        currentQuestionIndex = 0;
        buttons = new AnswerButton[4];
        // Initalizes all 4 buttons for the quiz itself
        buttons[0] = new AnswerButton(START_COORDINATE, START_COORDINATE);
        buttons[1] = new AnswerButton(START_COORDINATE + SPACING_X_BUFFER, START_COORDINATE);
        buttons[2] = new AnswerButton(START_COORDINATE, START_COORDINATE + SPACING_Y_BUFFER);
        buttons[3] = new AnswerButton(START_COORDINATE + SPACING_X_BUFFER, START_COORDINATE + SPACING_Y_BUFFER);

        // Loads in the quiz from the text file and returns the questions
        this.quizManager = new QuizManager("Resources/quiz.txt");
        this.questions = quizManager.getQuestions();

        // More buttons
        this.start = new AnswerButton(625, 350, 200,200, "START");
        this.playAgain = new AnswerButton(600,500, 350,150, "PLAY AGAIN");

        // Initializes the front-end once all of the instance variables have been initialized
        this.window = new KpopQuizView(buttons, this, start, playAgain);

        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);

        clock = new Timer(DELAY_IN_MILLISECONDS, this);
        clock.start();
    }

    // Resets the game to the start of the quiz
    public void start() {
        currentQuestionIndex = 0;
        userAnswer = null;
        showNextQuestion();
    }

    // Asks the next question until there are no more questions to ask
    public void showNextQuestion() {
        if (currentQuestionIndex >= NUM_QUESTIONS) {
            // Game is over if there are no more questions left
            state = END;
        }
        else {
            Question currentQuestion = questions.get(currentQuestionIndex);
            // Updates the buttons' values with the current question's answer choices
            setAnswerChoices(currentQuestion);
            // Displays the question on the window
            window.displayQuestion(currentQuestion);
        }
    }

    // Shuffles the answer choices so that the order is random when appearing on the buttons
    public static String[] shuffle(String[] array) {
        // Documentation from Stack Overflow
        Random rand = new Random();
        for (int i = 3; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        // Returns a shuffled array of anaswer choices
        return array;
    }

    // Updates each button's value with the new answer choices
    public void setAnswerChoices(Question question) {
        String[] choices = question.getChoices();
        choices = shuffle(choices);

        for (int i = 0; i < 4; i++) {
            buttons[i].setValue(choices[i]);
        }
    }

    // Action performed method to prevent lagging
    @Override
    public void actionPerformed(ActionEvent e) {
        window.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Location of the mouse
        int x = e.getX();
        int y = e.getY();

        // If the user is hovering over a button, change the color to blue
        // To make the mouse location clear
        for (int i = 0; i < 4; i++) {
            if (buttons[i].contains(x, y)) {
                buttons[i].setColor(Color.BLUE);
            }
            else {
                buttons[i].setColor(Color.RED);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Location of the mouse
        int x = e.getX();
        int y = e.getY();

        // If the home button icon was pressed, go back to the home screen
        if (inHome(x, y)) {
            state = HOME;
            // Resets the game
            quizManager.setScore(0);
            start();
            return;
        }

        // If the user is at the home screen or the end game screen
        if (state != PLAYING) {
            // If they choose to start the game or play again, the game resets
            if (start.contains(x, y) || playAgain.contains(x, y)) {
                state = PLAYING;
                quizManager.setScore(0);
                start();
                return;
            }
        }

        // Checks if the user clicked a certain button
        for (int i = 0; i < 4; i++) {
            if (buttons[i].contains(x, y)) {
                // Sets the user's answer to the value of the button they clicked
                userAnswer = buttons[i].getValue();
                // Updates the user's score if their answer was correct
                questions.get(currentQuestionIndex).isCorrect(userAnswer);
                // Moves on to the next question
                currentQuestionIndex++;
                showNextQuestion();
                break;
            }
        }
    }

    // Returns true if the user's mouse is on the home button
    public boolean inHome(int x, int y) {
        // Dimensions of the home button icon
        return (x >= 5 && x <= 55) && (y >= 30 && y <= 80);
    }

    // Other required methods for the mouse event class
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    // Getters
    public int getState() {
        return this.state;
    }

    public int getScore() {
        return quizManager.getScore();
    }

    // Main method to initialize the game
    public static void main(String[] args) {
        KpopQuiz quiz = new KpopQuiz();
    }
}
