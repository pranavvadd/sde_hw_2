import java.util.Random;
import java.util.Scanner;

// Runs the Prithee game in the consle.
public class Main {
    public static void main(String[] args) {
        Sonnet sonnet = new Sonnet();
        Game game = new Game();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Prithee! Call out the missing word.");
        System.out.println("Three right or three wrong ends the show.\n");

        while (!game.isOver()) {
            int blank = random.nextInt(sonnet.wordCount());
            System.out.println(sonnet.textUpTo(blank));
            System.out.print("\nPrithee, what is the next word? ");

            String guess = scanner.nextLine();
            String word = sonnet.wordAt(blank);

            if (game.answer(guess, word)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Error! The word was \"" + word + "\".");
            }
            System.out.println("Score: " + game.getCorrect() + " correct, "
                    + game.getWrong() + " incorrect.\n");
        }

        if (game.isWon()) {
            System.out.println("Three correct, the play goes on. Well done!");
        } else {
            System.out.println("Three misses. Better study the script!");
        }
        scanner.close();
    }
}
