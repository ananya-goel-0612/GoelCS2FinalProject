// Class to manage each individual question
// Holds the question, all the answer choices, and the correct answer
// Created by Ananya Goel

public class Question {
    private final String questionText;
    private final String[] choices;
    private final String correctAnswer;
    private final QuizManager quiz;

    public Question(String questionText, String[] choices, String correctAnswer, QuizManager quiz) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
        this.quiz = quiz;
    }

    // Getters
    public String getQuestionText() {
        return questionText;
    }

    public String[] getChoices() {
        return choices;
    }

    // Checks if the user's answer is correct
    public void isCorrect(String input) {
        if (input.equals(correctAnswer)) {
            quiz.increaseScore();
        }
    }
}
