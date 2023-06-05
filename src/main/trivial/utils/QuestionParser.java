package main.trivial.utils;

import main.trivial.model.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionParser {
    private QuestionParser() {
        throw new IllegalStateException("Utility class");
    }
    public static List<Question> parseQuestions(String filename) {
        List<Question> questions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String question = line.trim();
                    boolean isRight = Boolean.parseBoolean(reader.readLine().trim());
                    int rate = Integer.parseInt(reader.readLine().trim());
                    questions.add(new Question(question, isRight, rate));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
