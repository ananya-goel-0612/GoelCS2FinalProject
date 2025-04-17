import javax.swing.*;
import java.awt.*;

public class KpopQuizView extends JFrame {
    public static final int WINDOW_WIDTH = 700;
    public static final int WINDOW_HEIGHT = 500;
    // Constant for the dimensions of the home icon
    public static final int HOME_DIM = 50;

    private final Image home;

    private QuizManager quizManager;
    private AnswerButton button;
    //- questionLabel: JLabel
    //- buttons: List<JButton>
    //- scoreLabel: JLabel

    public KpopQuizView(AnswerButton button) {
        this.home = new ImageIcon("Resources/home.png").getImage();
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

        g.drawImage(this.home, 5, 30, HOME_DIM, HOME_DIM,this);

        button.draw(g);
    }

}
