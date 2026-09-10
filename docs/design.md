# Prithee - Design

## What it does

Prithee prints Shakespeare's Sonnet 18 but stops at a random word and prints underscores
instead of that word. The rest of the sonnet is not shown. The user is asked for the missing
word. The program says correct or error, then starts the sonnet over and picks a new word.
It keeps going until the user has three correct or three incorrect answers.

## Classes

**Sonnet** - stores the 14 lines of the sonnet and flattens them into a list of words so each
word has an index. `wordCount()` gives the number of words, `wordAt(i)` gives one word, and
`textUpTo(i)` builds the string that gets printed: every line before the blank, then the words
of the current line, then underscores matching the length of the missing word. It stops there
so the rest of the sonnet is never shown. `matches()` compares a guess to the real word,
ignoring capitalization and punctuation, so "day" counts for "day?".

**Game** - holds the score. `answer()` checks a guess, adds to the correct or incorrect count,
and returns whether it was right. `isOver()` is true at three of either, and `isWon()` says
which one it was.

**Main** - the console loop. It picks a random word index, prints the sonnet from Sonnet,
reads a line with Scanner, reports correct or error, prints the score, and repeats until
the game is over.

Splitting the sonnet and the score into their own classes keeps Main short and makes both of
them easy to test without any console input.

## Tests

JUnit 5 tests are in `src/test/java`.

- `SonnetTest` - checks the word count, that the blank is the right number of underscores,
  that lines before the blank still print, that the rest of the sonnet is cut off, and that
  guesses ignore case and punctuation.
- `GameTest` - checks scoring and that three correct or three incorrect ends the game.

## How to run

From the project folder:

    ./gradlew run

On Windows use `gradlew.bat run`. Type the missing word at each prompt and press enter.

To run the tests:

    ./gradlew test

Gradle uses a Java 26 toolchain and will download it if it is not already installed.
