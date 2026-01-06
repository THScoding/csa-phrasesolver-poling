import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board {
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue;

  /**
   * Creates Board based on custom filename
   * NOTE: file must have:
   * > 1 phrase per line
   * > only letters a-z, no other characters (comma, apostrophe, hyphen, etc)
   * 
   * @param phrasesFilename
   */
  public Board(String phrasesFilename) {
    solvedPhrase = "";
    this.phrase = loadPhrase(phrasesFilename);
  }

  public String getPhrase() {
    return this.phrase;
  }

  public String getSolvedPhrase() {
    return solvedPhrase;
  }

  public int getLetterValue() {
    return currentLetterValue;
  }

  // TODO: Add Javadoc explaining intent of this method
  public void setLetterValue() {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;
    currentLetterValue = randomInt;
  }

  public boolean isSolved() {
    return removeExtraSpaces(solvedPhrase).equals(phrase);
  }

  public boolean isSolution(String guess) {
    // TODO: Replace the if/else with a single line return statement.
    if (this.phrase.equals(guess.trim().toLowerCase())) {
      return true;
    }
    return false;
  }

  /**
   * Expects a String in the format of the solvedPhrase displayed to the user:
   * Each letter has an extra space after it,
   * and removes those spaces
   * 
   * @param guess
   * @return string with extra spaces removed
   */
  private String removeExtraSpaces(String guess) {
    return guess.replaceAll("(.) ", "$1");
    // Alternative that doesn't use regex: solvedPhrase.replace(" ", "|").replace("
    // ", "").replace("|", " ")
  }

  /**
   * TODO: Add explanation (Javadoc) text for the loadPhrase method
<<<<<<< HEAD
   * @param phrasesFilename is a file with phrases to load, one line at a time
   * @return One random line from provided phrasesFilename File
=======
   * 
   * @param
   * @return
>>>>>>> d0efb3d (added randon change)
   */
  private String loadPhrase(String phrasesFilename) {
    String selectedPhrase = "";
    int numOfLines = 0;

<<<<<<< HEAD
    //TODO: Add comment explaining what this first try/catch does
    //Tries to load the file provided, and parese it, catching exceptions if the file is not found.
    try 
    {
      //TODO: Resolve unclosed Scanner: Replace this try/catch with try-with-resources (Google it)
=======
    // TODO: Add comment explaining what this first try/catch does
    try {
      // TODO: Resolve unclosed Scanner: Replace this try/catch with
      // try-with-resources (Google it)
>>>>>>> d0efb3d (added randon change)
      Scanner sc = new Scanner(new File(phrasesFilename));
      while (sc.hasNextLine()) {
        sc.nextLine();
        numOfLines++;
      }
    } catch (FileNotFoundException e) {
      System.out.println("Specified phrases file not found: " + phrasesFilename);
    }

    int targetLineNumber = (int) ((Math.random() * numOfLines) + 1);

    // This try/catch attempts to open the phrases file and read it line by line.
    // If the file cannot be found, it prevents the program from crashing and
    // instead prints a helpful error message.
    try (Scanner sc = new Scanner(new File(phrasesFilename))) {
      int lineNumber = 0;

      // Read through the file one line at a time
      while (sc.hasNextLine()) {
        lineNumber++;

        // Remove leading/trailing whitespace from the line
        String currentLine = sc.nextLine();

        // If this is the line we want, store it in lowercase
        if (lineNumber == targetLineNumber) {
          selectedPhrase = currentLine.trim().toLowerCase();
        }
      }
    }
    // This catch runs if the file does not exist or cannot be opened.
    // It handles the error gracefully instead of crashing the program.
    catch (FileNotFoundException e) {
      System.out.println("Specified phrases file not found: " + phrasesFilename);
    }

    // TODO: Explain intent of this for loop (Also: why the extra spaces?)
    for (int i = 0; i < selectedPhrase.length(); i++) {
      String currentChar = selectedPhrase.substring(i, i + 1);
      if (currentChar.equals(" ")) {
        solvedPhrase += "  ";
      } else {
        solvedPhrase += "_ ";
      }
    }

    return selectedPhrase;
  }
  /**
   * Update solvedPhrase by replacing underscore with the guessed letter, for each
   * position it appears in the phrase.
   * 
   * @return count of letter in phrase; Returns 0 if letter not found OR if letter
   *         was already guessed
   */
  public int guessLetter(String guess) {
    // Skip processing if letter was already guessed (or if guess is a space)
    if (solvedPhrase.indexOf(guess) >= 0) {
      System.out.println("this letter has already been guessed");
      return 0;
    }

    // this check shows if the letter does not exist in the phrase.
    if (this.phrase.indexOf(guess) < 0) {
      System.out.println("your letter does not exist in the phrase");
      return 0;
    }

    // Now, construct the
    int foundLetterCount = 0;
    String newSolvedPhrase = "";
    // TODO: Add comments to explain how this for loop works
    for (int i = 0; i < this.phrase.length(); i++) {
      String currentLetter = this.phrase.substring(i, i + 1);
      if (currentLetter.equals(guess)) {
        newSolvedPhrase += guess + " ";
        foundLetterCount++;
      } else {
        if (currentLetter.equals(" ")) {
          newSolvedPhrase += "  ";
        } else {
          // return an underscore
          if (currentLetter.equals("_")) {
            newSolvedPhrase += "_ ";
          } else {
            newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";
          }
        }
      }
    }
    solvedPhrase = newSolvedPhrase;
    return foundLetterCount;
  }

  int asdf;
}