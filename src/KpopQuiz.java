import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class KpopQuiz implements MouseListener, MouseMotionListener, ActionListener {

    private QuizManager quizManager;
    private KpopQuizView window;
    private AnswerButton button;
    private ArrayList<Question> questions;

    public static final int START = 0;
    public static final int HOME = 1;
    public static final int PLAYING = 2;
    public static final int END = 3;

    private Timer clock;
    public static final int DELAY_IN_MILLISECONDS = 20;

    public KpopQuiz() {
        button = new AnswerButton();
        this.quizManager = new QuizManager("Resources/quiz.txt");
        this.questions = quizManager.getQuestions();

        this.window = new KpopQuizView(button);

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

        if (button.contains(x, y)) {
            button.setColor(Color.GREEN);
        }
        else {
            button.setColor(Color.RED);
        }

    }

    public static void main(String[] args) {
        KpopQuiz quiz = new KpopQuiz();
    }
}
