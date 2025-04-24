import java.util.ArrayList;

public class Question {
    private String questionText;
    private String[] choices;
    private String correctAnswer;
    private QuizManager quiz;

    public Question(String questionText, String[] choices, String correctAnswer, QuizManager quiz) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
        this.quiz = quiz;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getChoices() {
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

    public void print() {
        System.out.println(questionText);
        System.out.println(correctAnswer);
        for (int i = 0; i < 4; i++) {
            System.out.println(choices[i]);
        }
    }
}
