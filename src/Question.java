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

    public void isCorrect(String input) {
        if (input.equals(correctAnswer)) {
            quiz.increaseScore();
        }
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
