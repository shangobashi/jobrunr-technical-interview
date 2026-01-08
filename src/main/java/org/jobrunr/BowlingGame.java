package org.jobrunr;

public class BowlingGame {

    private int score = 0;
    private int rollsInFrame = 0;
    private int frame = 1;
    private int previousRoll = 0;
    private boolean spare = false;
    private boolean strike = false;

    public void roll(int pinsDown) {

        // bonus handling
        if (strike) {
            score += pinsDown * 2;
            strike = false;
        } else if (spare) {
            score += pinsDown;
            spare = false;
        }

        score += pinsDown;
        rollsInFrame++;

        if (pinsDown == 10) {
            strike = true;
            frame++;
            rollsInFrame = 0;
        } else if (rollsInFrame == 2) {
            if (previousRoll + pinsDown == 10) {
                spare = true;
            }
            frame++;
            rollsInFrame = 0;
        }

        previousRoll = pinsDown;
    }

    public int score() {
        return score;
    }
}
