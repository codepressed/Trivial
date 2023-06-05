package main.trivial;

import main.trivial.model.Question;
import main.trivial.utils.QuestionParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class Game {
    private static final Logger LOGGER = Logger.getLogger(Game.class.getName());
    private static final String DEFAULT_QUESTIONS = "src/main/resources/questions.txt";
    private List<Question> questions = new ArrayList<>();
    public Game(int players){
        Collections.addAll(questions,
                new Question("Pregunta!",true,1),
                new Question("Pregunta2!", true, 3),
                new Question("Pregunta 3", false, 3),
                new Question("Pregunta 4", true, 1),
                new Question("Pregunta 5", false, 2),
                new Question("Pregunta 6", true, 5),
                new Question("Pregunta 7", false, 2),
                new Question("Pregunta 8", true, 3),
                new Question("Pregunta 9", false, 3)
        );
        Collections.sort(questions);
        GameEngine.playGame(questions, players);
    }

    public Game(int players, String filename){
        questions = QuestionParser.parseQuestions(filename);
        Collections.sort(questions);
        GameEngine.playGame(questions, players);
    }
    public static void main(String[] args) {
        if (args.length > 1) {
            int players = Integer.parseInt(args[0]);
            int gameType = Integer.parseInt(args[1]);
            String filename = (args.length > 2) ? args[2] : DEFAULT_QUESTIONS;
            LOGGER.info("Welcome to TrivialGame by DanielAlfredo. Get ready, fun is about to begin.");
            switch (gameType) {
                case 0:
                    new Game(players);
                    break;
                case 1:
                    new Game(players, filename);
                    break;
                default:
                    LOGGER.severe("Invalid game type specified.");
            }
            // Use the 'game' instance as needed
        } else {
            System.out.println("No game or player number specified.");
        }
    }
}
