package com.example.actfirst1;

public class Algorithm {

    public int score = 0;

    public Algorithm() {
        this.score = 0;
    }

    public void correctAction() {
        score++;
    }

    public void wrongAction() {
        score--;
    }

    public int getScore() {
        return score;
    }

    public boolean isCorrectSequence(int action, int[] correctSequence, int currentIndex) {
        return action == correctSequence[currentIndex];
    }
}
