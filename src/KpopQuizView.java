import javax.swing.*;
import java.awt.*;

public class KpopQuizView extends JFrame {
    public static final int WINDOW_WIDTH = 700;
    public static final int WINDOW_HEIGHT = 500;
    // Constant for the dimensions of the home icon
    public static final int HOME_DIM = 50;
    public static final int BAR_OFFSET = 23;

    private final Image home;

    private KpopQuiz game;
    private QuizManager quizManager;
    private AnswerButton button;
    //- questionLabel: JLabel
    //- buttons: List<JButton>
    //- scoreLabel: JLabel

    public KpopQuizView(AnswerButton button, KpopQuiz game) {
        this.game = game;
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
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        int state = game.getState();
        switch (state) {
            case KpopQuiz.HOME:
                break;
            case KpopQuiz.PLAYING:
                g.drawImage(this.home, 5, BAR_OFFSET + 7, HOME_DIM, HOME_DIM, this);
                button.draw(g);
                break;
            case KpopQuiz.END:
                break;
        }
    }
}
