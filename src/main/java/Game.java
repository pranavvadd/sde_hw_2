// Keeps score. The game ends at three right or three wrong anwsers.
public class Game {

    public static final int TARGET = 3;

    private int correct = 0;
    private int wrong = 0;

    // Checks the guess, updates the score, and says if it was rigth.
    public boolean answer(String guess, String word) {
        boolean right = Sonnet.matches(guess, word);
        if (right) {
            correct++;
        } else {
            wrong++;
        }
        return right;
    }

    public int getCorrect() {
        return correct;
    }

    public int getWrong() {
        return wrong;
    }

    public boolean isOver() {
        return correct >= TARGET || wrong >= TARGET;
    }

    public boolean isWon() {
        return correct >= TARGET;
    }
}
