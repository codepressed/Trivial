package main.trivial.model;

import java.time.LocalDate;

public class GameStat {
    private int totalAnswers;
    private int correctAnswers;
    private int totalScore;
    private LocalDate scoreDate;

    public GameStat() {
        this.scoreDate = LocalDate.now();
    }

    public int getTotalAnswers() {
        return totalAnswers;
    }

    public void setTotalAnswers(int totalAnswers) {
        this.totalAnswers = totalAnswers;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public LocalDate getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(LocalDate scoreDate) {
        this.scoreDate = scoreDate;
    }

    public void increaseCorrectAnswers(int scoreToIncrease){
        this.correctAnswers++;
        this.totalScore+=scoreToIncrease;
    }
}
