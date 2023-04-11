package be.kdg.integration2.take5.model;

public class Move {
    private int moveNumber;
    private double duration;
    private int score;

    public Move(int moveNumber, double duration, int score) {
        this.moveNumber = moveNumber;
        this.duration = duration;
        this.score = score;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public double getDuration() {
        return duration;
    }

    public int getScore() {
        return score;
    }
}

