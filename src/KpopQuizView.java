import javax.swing.*;
import java.awt.*;

public class KpopQuizView extends JFrame {
    public static final int WINDOW_WIDTH = 700;
    public static final int WINDOW_HEIGHT = 500;


    private QuizManager quizManager;
    private AnswerButton button;
    //- questionLabel: JLabel
    //- buttons: List<JButton>
    //- scoreLabel: JLabel

    public KpopQuizView(AnswerButton button) {
        this.button = button;
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("K-pop Quiz!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void displayQuestion(Question q) {

    }

    public void updateScore() {

    }

    public void showResult() {

    }

    public void setupUI() {

    }

    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        button.draw(g);
    }

}
