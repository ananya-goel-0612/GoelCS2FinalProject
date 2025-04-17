import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class QuizManager {
    private ArrayList<Question> questions;
    private int currentIndex;
    private int score;

//    public void loadQuestions() {
//
//    }
//
//    public Question getNextQuestion() {
//
//    }
//
//    public boolean checkAnswer(String userAnswer) {
//
//    }
//
//    public int getScore() {
//
//    }
//
//    public boolean hasNext() {
//
//    }


    public QuizManager(String filename) {
        createQuiz(filename);
    }

    private void createQuiz(String filename) {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);

            this.questions = new ArrayList<Question>();

            for (int i = 0; i < 10; i++) {
                String questionText = myReader.nextLine();
                String correctAnswer = myReader.nextLine();
                ArrayList<String> choices = new ArrayList<String>();

                choices.add(correctAnswer);
                for (int j = 0; j < 3; j++) {
                    choices.add(myReader.nextLine());
                }

                questions.add(new Question(questionText, choices, correctAnswer));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
