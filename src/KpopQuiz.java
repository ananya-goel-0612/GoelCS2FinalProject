import java.awt.event.*;

public class KpopQuiz implements MouseListener, MouseMotionListener, ActionListener {

    private QuizManager quizManager;
    private KpopQuizView window;

    public KpopQuiz() {
        this.window = new KpopQuizView();

        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
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

    }
}
