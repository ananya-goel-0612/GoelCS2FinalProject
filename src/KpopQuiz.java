import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class KpopQuiz implements MouseListener, MouseMotionListener, ActionListener {

    private final QuizManager quizManager;
    private final KpopQuizView window;
    private final ArrayList<Question> questions;
    private final AnswerButton[] buttons;
    private final AnswerButton start;
    private final AnswerButton playAgain;
    private String userAnswer;
    private int currentQuestionIndex;

    private int state;
    public static final int HOME = 0;
    public static final int PLAYING = 1;
    public static final int END = 2;

    public static final int SPACING_Y_BUFFER = 150;
    public static final int SPACING_X_BUFFER = 300;
    public static final int START_COORDINATE = 500;
    public static final int NUM_QUESTIONS = 10;


    private final Timer clock;
    public static final int DELAY_IN_MILLISECONDS = 20;

    public KpopQuiz() {
        state = HOME;
        currentQuestionIndex = 0;
        buttons = new AnswerButton[4];
        buttons[0] = new AnswerButton(START_COORDINATE, START_COORDINATE);
        buttons[1] = new AnswerButton(START_COORDINATE + SPACING_X_BUFFER, START_COORDINATE);
        buttons[2] = new AnswerButton(START_COORDINATE, START_COORDINATE + SPACING_Y_BUFFER);
        buttons[3] = new AnswerButton(START_COORDINATE + SPACING_X_BUFFER, START_COORDINATE + SPACING_Y_BUFFER);

        this.quizManager = new QuizManager("Resources/quiz.txt");
        this.questions = quizManager.getQuestions();

        this.start = new AnswerButton(625, 350, 200,200, "START");
        this.playAgain = new AnswerButton(600,500, 350,150, "PLAY AGAIN");

        this.window = new KpopQuizView(buttons, this, start, playAgain);

        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);

        clock = new Timer(DELAY_IN_MILLISECONDS, this);
        clock.start();
    }

    public void start() {
        currentQuestionIndex = 0;
        userAnswer = null;
        showNextQuestion();
    }

    public void showNextQuestion() {
        if (currentQuestionIndex >= NUM_QUESTIONS) {
            state = END;
        }
        else {
            Question currentQuestion = questions.get(currentQuestionIndex);
            setAnswerChoices(currentQuestion);
            window.displayQuestion(currentQuestion);
        }
    }

    // Shuffles the answer choices so that the order is random when appearing on the buttons
    public static String[] shuffleFour(String[] array) {
        Random rand = new Random();
        for (int i = 3; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    public void setAnswerChoices(Question question) {
        String[] choices = question.getChoices();
        choices = shuffleFour(choices);

        for (int i = 0; i < 4; i++) {
            buttons[i].setValue(choices[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        // If the home button icon was pressed
        if (x >= 5 && x <= 55 && y >= 30 && y <= 80) {
            state = HOME;
            quizManager.setScore(0);
            start();
        }

        if (start.contains(x, y) || playAgain.contains(x, y)) {
            state = PLAYING;
            start();
        }

        if (state == PLAYING) {
            for (int i = 0; i < 4; i++) {
                if (buttons[i].contains(x, y)) {
                    userAnswer = buttons[i].getValue();
                    questions.get(currentQuestionIndex).isCorrect(userAnswer);
                    currentQuestionIndex++;
                    showNextQuestion();
                    break;
                }
            }
        }
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

    @Override
    public void mouseMoved(MouseEvent e) {
        // For demo purposes only
        int x = e.getX();
        int y = e.getY();

        for (int i = 0; i < 4; i++) {
            if (buttons[i].contains(x, y)) {
                buttons[i].setColor(Color.BLUE);
            }
            else {
                buttons[i].setColor(Color.RED);
            }
        }
    }

    public int getState() {
        return this.state;
    }

    public int getScore() {
        return quizManager.getScore();
    }

    public static void main(String[] args) {
        KpopQuiz quiz = new KpopQuiz();
    }
}
