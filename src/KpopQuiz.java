import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KpopQuiz implements MouseListener, MouseMotionListener, ActionListener {

    private QuizManager quizManager;
    private KpopQuizView window;
    private AnswerButton button;
    private Timer clock;
    public static final int DELAY_IN_MILLISECONDS = 20;

    public KpopQuiz() {
        button = new AnswerButton();

        this.window = new KpopQuizView(button);


        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);

        clock = new Timer(DELAY_IN_MILLISECONDS, this);
        clock.start();
    }

    public void start() {

    }

    public static void main(String[] args) {
        KpopQuiz quiz = new KpopQuiz();
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
}
