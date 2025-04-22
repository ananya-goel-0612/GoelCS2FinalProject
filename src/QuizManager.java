import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class QuizManager {
    private ArrayList<Question> questions;
    private int currentIndex;
    private int score;
    public static final int NUM_QUESTIONS = 2;

    public QuizManager(String filename) {
        createQuiz(filename);
    }

    private void createQuiz(String filename) {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);

            this.questions = new ArrayList<Question>();

            for (int i = 0; i < NUM_QUESTIONS; i++) {
                String questionText = myReader.nextLine();
                String correctAnswer = myReader.nextLine();
                ArrayList<String> choices = new ArrayList<String>();

                choices.add(correctAnswer);
                for (int j = 0; j < 3; j++) {
                    choices.add(myReader.nextLine());
                }
                questions.add(new Question(questionText, choices, correctAnswer));
                myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Question getNextQuestion() {
        currentIndex++;
        return questions.get(currentIndex);
    }

    public boolean checkAnswer(String userAnswer) {
        if (questions.get(currentIndex).isCorrect(userAnswer)) {
            return true;
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
}
