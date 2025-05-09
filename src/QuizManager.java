// Class to handle the importing of the quiz from the text file
// Created by Ananya Goel

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class QuizManager {
    private ArrayList<Question> questions;
    private int score;
    public static final int NUM_QUESTIONS = 10;

    public QuizManager(String filename) {
        createQuiz(filename);
    }

    // Method to read in all the quiz data from the text file
    private void createQuiz(String filename) {
        // Got the basic documentation from Ms. Namasivayam's starter code in MazeSolver
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);

            // Initializes the ArrayList of questions
            this.questions = new ArrayList<Question>();

            for (int i = 0; i < NUM_QUESTIONS; i++) {
                String questionText = myReader.nextLine();
                String correctAnswer = myReader.nextLine();
                String[] choices = new String[4];

                choices[0] = correctAnswer;
                for (int j = 1; j < 4; j++) {
                    choices[j] = myReader.nextLine();
                }
                // Initializes a new question
                Question question = new Question(questionText, choices, correctAnswer, this);
                // Adds the created question to the ArrayList
                questions.add(question);
                myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Getters and Setters
    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore() {
        this.score++;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
