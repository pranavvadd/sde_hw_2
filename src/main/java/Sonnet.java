import java.util.ArrayList;
import java.util.List;

// Holds Sonnet 18 and knows how to print it with one word blanked out.
// The words are all in one list so each one has an index we can pick from.
public class Sonnet {

    private static final String[] LINES = {
            "Shall I compare thee to a summer's day?",
            "Thou art more lovely and more temperate:",
            "Rough winds do shake the darling buds of May,",
            "And summer's lease hath all too short a date;",
            "Sometime too hot the eye of heaven shines,",
            "And often is his gold complexion dimm'd;",
            "And every fair from fair sometime declines,",
            "By chance or nature's changing course untrimm'd;",
            "But thy eternal summer shall not fade,",
            "Nor lose possession of that fair thou ow'st;",
            "Nor shall death brag thou wander'st in his shade,",
            "When in eternal lines to time thou grow'st:",
            "   So long as men can breathe or eyes can see,",
            "   So long lives this, and this gives life to thee."
    };

    private final List<String> words = new ArrayList<>();

    public Sonnet() {
        for (String line : LINES) {
            for (String word : line.trim().split("\\s+")) {
                words.add(word);
            }
        }
    }

    public int wordCount() {
        return words.size();
    }

    // The word at the given postion, punctuation and all.
    public String wordAt(int index) {
        return words.get(index);
    }

    // Prints the sonnet up to the blanked word, then stopps.
    // Everything after the blank does not get printed.
    public String textUpTo(int index) {
        StringBuilder out = new StringBuilder();
        int current = 0;
        for (String line : LINES) {
            String[] lineWords = line.trim().split("\\s+");
            StringBuilder built = new StringBuilder();
            if (line.startsWith(" ")) {
                built.append("   ");
            }
            for (String word : lineWords) {
                if (current == index) {
                    built.append("_".repeat(word.length()));
                    out.append(built);
                    return out.toString();
                }
                built.append(word).append(" ");
                current++;
            }
            out.append(built.toString().stripTrailing()).append("\n");
        }
        return out.toString();
    }

    // Compares a guess to the real word, ignoreing case and punctuation.
    public static boolean matches(String guess, String word) {
        return clean(guess).equals(clean(word));
    }

    private static String clean(String word) {
        return word.toLowerCase().replaceAll("[^a-z']", "");
    }
}
