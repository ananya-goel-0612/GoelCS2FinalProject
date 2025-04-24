import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Array;
import java.util.ArrayList;

public class KpopQuiz implements MouseListener, MouseMotionListener, ActionListener {

    private QuizManager quizManager;
    private KpopQuizView window;
    private ArrayList<Question> questions;
    private AnswerButton[] buttons;

    private int state;
    public static final int HOME = 0;
    public static final int PLAYING = 1;
    public static final int END = 2;

    public static final int SPACING_Y_BUFFER = 150;
    public static final int SPACING_X_BUFFER = 300;
    public static final int START_COORDINATE = 500;

    private Timer clock;
    public static final int DELAY_IN_MILLISECONDS = 20;

    public KpopQuiz() {
        state = HOME;
        buttons = new AnswerButton[4];
        buttons[0] = new AnswerButton(START_COORDINATE, START_COORDINATE);
        buttons[1] = new AnswerButton(START_COORDINATE + SPACING_X_BUFFER, START_COORDINATE);
        buttons[2] = new AnswerButton(START_COORDINATE, START_COORDINATE + SPACING_Y_BUFFER);
        buttons[3] = new AnswerButton(START_COORDINATE + SPACING_X_BUFFER, START_COORDINATE + SPACING_Y_BUFFER);

        this.quizManager = new QuizManager("Resources/quiz.txt");
        this.questions = quizManager.getQuestions();

        this.window = new KpopQuizView(buttons, this);

        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);

        clock = new Timer(DELAY_IN_MILLISECONDS, this);
        clock.start();
    }

    public void start() {

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

//        if (button.contains(x, y)) {
//            button.setColor(Color.BLUE);
//        }
//        else {
//            button.setColor(Color.RED);
//        }

    }

    public int getState() {
        return this.state;
    }

    public static void main(String[] args) {
        KpopQuiz quiz = new KpopQuiz();
    }
}
