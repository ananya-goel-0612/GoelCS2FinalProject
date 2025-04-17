import java.util.ArrayList;

public class Question {
    private String questionText;
    private ArrayList<String> choices;
    private String correctAnswer;

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


}
