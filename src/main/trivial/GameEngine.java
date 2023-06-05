package main.trivial;

import main.trivial.model.GameStat;
import main.trivial.model.Player;
import main.trivial.model.Question;

import java.util.*;
import java.util.logging.Logger;

public class GameEngine {
    private static final Logger LOGGER = Logger.getLogger(GameEngine.class.getName());

    private static Player playerScoring(List<Question> questions){
        GameStat gameStat = new GameStat();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your username: ");
        String username = scanner.nextLine();
        LOGGER.config("Your username has been set as: "+username);
        for(Question question : questions){
            System.out.println("-------------------------\nPregunta: "+question.getAffirmation());
            try {
                boolean answer = scanner.nextBoolean();
            if(answer == question.isRight()){
                System.out.println("Well played "+username);
                gameStat.increaseCorrectAnswers(question.getRate());
            }else{
                System.out.println("Bad job "+username);
            }}
            catch(InputMismatchException exception){
                System.out.println("Error de formato. No sumas puntos");
            }
        }
        System.out.println("*** GAME OVER ***");
        System.out.println("Correct answers: "+gameStat.getCorrectAnswers());
        System.out.println("Score achieved: "+gameStat.getTotalScore());
        double ratio = ((double) gameStat.getCorrectAnswers()/questions.size() * 100);
        String formattedRatio = String.format("%.2f%%", ratio);
        System.out.println("Correct answer ratio: "+ formattedRatio);
        return new Player(username, gameStat);
    }
    public static void playGame(List<Question> questions, int playersNum){
        List<Player> players = new ArrayList<>();
        for(int i = 0; i<playersNum; i++){
            players.add(playerScoring(questions));
        }
        if(playersNum>1){
            showRanking(players);
        }
    }

    private static void showRanking(List<Player> players){
        Collections.sort(players);
        int counter = 1;
        System.out.println("----------------");
        System.out.println("#### RANKING #### ");
        for(Player player : players){
            System.out.println("#"+counter++ +": "+player.getUsername()+" - "+player.getStat().getTotalScore());
        }
    }

}

