package main.trivial.model;

import main.trivial.model.factor.Category;
import main.trivial.model.factor.QuestionDifficulty;

public class Question implements Comparable<Question>{
    private String affirmation;
    private boolean isRight;
    private int rate;
    private QuestionDifficulty difficulty;
    private Category category;

    public Question(String affirmation, boolean isRight, int rate) {
        this.affirmation = affirmation;
        this.isRight = isRight;
        this.rate = rate;
    }

    public String getAffirmation() {
        return affirmation;
    }

    public void setAffirmation(String affirmation) {
        this.affirmation = affirmation;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public int compareTo(Question other) {
        return Integer.compare(this.rate, other.getRate());
    }
}

