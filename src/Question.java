import java.util.ArrayList;

public class Question {
    private String questionText;
    private ArrayList<String> choices;
    private String correctAnswer;
    private QuizManager quiz;

    public Question(String questionText, ArrayList<String> choices, String correctAnswer, QuizManager quiz) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
        this.quiz = quiz;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public boolean isCorrect(String input) {
        if (input.equals(correctAnswer)) {
            quiz.increaseScore();
            return true;
        }
        return false;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
