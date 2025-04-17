import java.util.ArrayList;

public class Question {
    private String questionText;
    private ArrayList<String> choices;
    private String correctAnswer;

    public Question(String questionText, ArrayList<String> choices, String correctAnswer) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public boolean isCorrect(String input) {
        if (input.equals(correctAnswer)) {
            return true;
        }
        return false;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
