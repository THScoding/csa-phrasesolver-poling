import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board {
    private String solvedPhrase;
    private String phrase;
    private int currentLetterValue;

    /**
     * Creates Board based on custom filename
     */
    public Board(String phrasesFilename) {
        solvedPhrase = "";
        phrase = loadPhrase(phrasesFilename);
    }

    public String getPhrase() {
        return phrase;
    }

    public String getSolvedPhrase() {
        return solvedPhrase;
    }

    public int getLetterValue() {
        return currentLetterValue;
    }

    /**
     * Sets the value to a random integer between 100 and 1000.
     */
    public void setLetterValue() {
        currentLetterValue = ((int)(Math.random() * 10) + 1) * 100;
    }

    /**
     * Checks if the phrase has been completely solved
     */
    public boolean isSolved() {
        return removeExtraSpaces(solvedPhrase).equals(phrase);
    }

    /**
     * Checks if a given guess matches the full solution
     */
    public boolean isSolution(String guess) {
        return phrase.equals(guess.trim().toLowerCase());
    }

    /**
     * Removes spaces used for display
     */
    private String removeExtraSpaces(String guess) {
        return guess.replaceAll("(.) ", "$1");
    }

    /**
     * Loads a random phrase from the file
     */
    private String loadPhrase(String phrasesFilename) {
        int numLines = 0;

        // Count lines
        try (Scanner sc = new Scanner(new File(phrasesFilename))) {
            while (sc.hasNextLine()) {
                sc.nextLine();
                numLines++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return "";
        }

        int targetLine = (int)(Math.random() * numLines) + 1;
        String selectedPhrase = "";

        // Read selected line
        try (Scanner sc = new Scanner(new File(phrasesFilename))) {
            int lineNum = 0;
            while (sc.hasNextLine()) {
                lineNum++;
                String line = sc.nextLine().trim().toLowerCase();
                if (lineNum == targetLine) {
                    selectedPhrase = line;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // Initialize solvedPhrase with underscores
        for (int i = 0; i < selectedPhrase.length(); i++) {
            if (selectedPhrase.substring(i, i + 1).equals(" ")) {
                solvedPhrase += "  ";
            } else {
                solvedPhrase += "_ ";
            }
        }

        return selectedPhrase;
    }

    /**
     * Reveals guessed letter in solvedPhrase
     */
    public int guessLetter(String guess) {
        guess = guess.toLowerCase();

        // Already guessed
        if (solvedPhrase.contains(guess)) {
            System.out.println("Letter already guessed.");
            return 0;
        }

        // Letter not in phrase
        if (!phrase.contains(guess)) {
            System.out.println("Letter not in phrase.");
            return 0;
        }

        int count = 0;
        StringBuilder newSolved = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            String current = phrase.substring(i, i + 1);

            if (current.equals(guess)) {
                newSolved.append(guess).append(" ");
                count++;
            } else if (current.equals(" ")) {
                newSolved.append("  ");
            } else {
                newSolved.append(solvedPhrase.substring(i * 2, i * 2 + 1)).append(" ");
            }
        }

        solvedPhrase = newSolved.toString();
        return count;
    }
}