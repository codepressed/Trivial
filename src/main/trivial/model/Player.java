package main.trivial.model;

public class Player implements Comparable<Player>{
    private String username;
    private GameStat stat;

    public Player() {
    }

    public Player(String username, GameStat stat) {
        this.username = username;
        this.stat = stat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public GameStat getStat() {
        return stat;
    }

    public void setStat(GameStat stat) {
        this.stat = stat;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(o.getStat().getTotalScore(), this.stat.getTotalScore());
    }
}
