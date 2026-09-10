import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void rightAnswerCountsAsCorrect() {
        Game game = new Game();
        assertTrue(game.answer("thee", "thee"));
        assertEquals(1, game.getCorrect());
        assertEquals(0, game.getWrong());
        assertFalse(game.isOver());
    }

    @Test
    public void threeCorrectWinsTheGame() {
        Game game = new Game();
        for (int i = 0; i < 3; i++) {
            game.answer("thee", "thee");
        }
        assertTrue(game.isOver());
        assertTrue(game.isWon());
    }

    // three misses should end it even tho you got none right
    @Test
    public void threeWrongEndsTheGame() {
        Game game = new Game();
        for (int i = 0; i < 3; i++) {
            game.answer("wrong", "thee");
        }
        assertTrue(game.isOver());
        assertFalse(game.isWon());
    }
}
