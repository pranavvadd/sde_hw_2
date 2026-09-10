import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SonnetTest {

    @Test
    public void sonnetHasAllTheWords() {
        Sonnet sonnet = new Sonnet();
        assertEquals(114, sonnet.wordCount());
        assertEquals("Shall", sonnet.wordAt(0));
    }

    // the blank should be the same lenght as the missing word
    @Test
    public void blankIsUnderscoresAndTheRestIsCutOff() {
        Sonnet sonnet = new Sonnet();
        String text = sonnet.textUpTo(2);
        assertEquals("Shall I _______", text);
    }

    @Test
    public void earlierLinesStillPrint() {
        Sonnet sonnet = new Sonnet();
        String text = sonnet.textUpTo(8);
        assertTrue(text.startsWith("Shall I compare thee to a summer's day?\n"));
        assertTrue(text.endsWith("____"));
        assertFalse(text.contains("Rough winds"));
    }

    @Test
    public void guessIgnoresCaseAndPunctuation() {
        assertTrue(Sonnet.matches("day", "day?"));
        assertTrue(Sonnet.matches("SHALL", "Shall"));
        assertFalse(Sonnet.matches("night", "day?"));
    }
}
