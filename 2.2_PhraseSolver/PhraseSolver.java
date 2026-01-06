import java.util.Scanner;
  
public class  PhraseSolver
{
  private Player player1;
  private Player player2;
  private Board game;
  private int solveBonus;
  private String remainingLetters = "a b c d e f g h i j k l m n o p q r s t u v w x y z ";
  private String defaultPhrasesFilename = "phrases.txt";

  public PhraseSolver() 
  {
    player1 = new Player();
    player2 = new Player();
    game = new Board(defaultPhrasesFilename);
  }
  //erranous change - lucca
  /**
   * Creates PhraseSolver (and thus Board) based on custom filename
   * NOTE: File must have:
   *    > 1 phrase per line
   *    > sixty seven
   *    > only letters a-z, no other characters (comma, apostrophe, hyphen, etc)
   * @param phrasesFilename
   */
  public PhraseSolver(String phrasesFilename) 
  {
    //TODO: Implement this Constructor
      // (Must accomplish the same tasks as the default Constructor, except the Board must be instantiated using the phrasesFilename parameter
      // Tip: Don't Repeat Yourself (DRY): Use the *this* keyword and accomplish this in just 2 lines of code
    this();
    game = new Board(phrasesFilename);
  }
  public void displayBoardAndScores() {
    System.out.println("\n" + game.getSolvedPhrase() + "\n");
    System.out.println("\nScores: \n" + player1.getName() + " : " + player1.getPoints());
    System.out.println(player2.getName() + " : " + player2.getPoints());
  }

  public void play()
  { 
    boolean solved = false;
    int guesses = 0;
    solveBonus = 100 * game.getPhrase().length();
    System.out.println("\n========================\n");
    System.out.println("You earn a bonus of " + solveBonus + " for solving the phrase early");    
    Player currentPlayer = player1;
    Scanner sc = new Scanner(System.in);
    displayBoardAndScores();

    while (!solved) 
    { 
      guesses++; 
      System.out.println(remainingLetters + "\n");

      //Set & display current letter bounty
      game.setLetterValue();
      int letterVal = game.getLetterValue();
      System.out.println("Current Letter Value: " + letterVal);
      
      //Switch currentPlayer after each guess 
      currentPlayer = player1;
      if (guesses % 2 == 0)
      {
        currentPlayer = player2;      
      }
      
      System.out.println("\n" + currentPlayer.getName() + ", guess a letter (or the whole phrase, with no extra spaces): ");
      String guess = sc.nextLine().trim().toLowerCase();

      if (guess.length() == 1) //Is player guessing a letter, or the whole phrase?
      {
        remainingLetters = remainingLetters.replaceFirst(guess + " ", "");
        int occurrences = game.guessLetter(guess); //guessLetter returns count of letter in phrase (IF not already guessed)
        //Add points per occurence of letter in phrase; 
        if (occurrences > 0) {
          currentPlayer.addPoints(letterVal * occurrences);
          solved = game.isSolved(); //check if puzzle is complete
        }

      } else { //assume player is guessing the whole phrase
        solved = game.isSolution(guess);
        if (!solved) {
            System.out.println("\nSorry, that's not the correct phrase.\n");
        }
      }
      if (solved) currentPlayer.addPoints(solveBonus);
      displayBoardAndScores();

    } //end of while (!solved) loop

    //Print final game result
    System.out.println("\n************************\n");
    System.out.println("\nNice job, " + currentPlayer.getName() + "!  You solved the puzzle. That earned you a points bonus of " + solveBonus);
    
    //Assigns winner name from points
    String winnerName;
    if(player1.getPoints() > player2.getPoints()) {
      winnerName = player1.getName();
    } else {
      winnerName = player2.getName();
    }

    System.out.println("\nCongratulations, " + winnerName +"!  You won, with the most points\n");
    
    sc.close();
  } //end of play
  
}