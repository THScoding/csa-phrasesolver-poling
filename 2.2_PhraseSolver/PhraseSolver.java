import java.util.Scanner;
  
public class  PhraseSolver
{
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;
  private int solveBonus;

  public PhraseSolver() 
  {
    player1 = new Player();
    player2 = new Player();
    game = new Board();
    solved = false;
  }
  
  public void play()
  {
    int guesses = 0;
    solveBonus = 100 * game.getPhrase().length();
    System.out.println("\n========================\n");
    System.out.println("You earn a bonus of " + solveBonus + " for solving the phrase early");    
    Player currentPlayer = player1;
    Scanner sc = new Scanner(System.in);
    String boardStatus = game.getSolvedPhrase();
    System.out.println("\n" + boardStatus + "\n");

    while (!solved) 
    { 
      guesses++; 

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
      
      System.out.println(currentPlayer.getName() + " guess a letter (or the whole phrase): ");
      String guess = sc.nextLine();

      if (guess.length() == 1) //Is player guessing a letter, or the whole phrase?
      {
        //Add points per occurence of letter in phrase; My guessLetter returns count of letter guessed
        currentPlayer.addPoints(letterVal * game.guessLetter(guess));
        boardStatus= game.getSolvedPhrase();
        solved = game.isSolved(boardStatus); //check if puzzle is complete
        System.out.println("\n" + boardStatus); //Display current game board

      } else { //assume player is guessing the whole phrase
        solved = game.isSolved(guess);
        if (solved) {
            currentPlayer.addPoints(solveBonus);
        } else {
            System.out.println("\nSorry, that's not the correct phrase.\n");
            continue;
        }
      }
      
      // Show scores
      System.out.println("\nScores: \n" + player1.getName() + " : " + player1.getPoints());
      System.out.println(player2.getName() + " : " + player2.getPoints());

    } //end of while (!solved) loop

    //Print final game result
    System.out.println("\n************************\n");
    System.out.println("\nNice job, " + currentPlayer.getName() + "!  You solved the puzzzle. That earns you a points bonus of " + solveBonus);
    String winnerName = player1.getPoints() > player2.getPoints() ? player1.getName() : player2.getName();
    System.out.println("\nCongratulations, " + winnerName +"!  You won, with the most points\n");
    
    sc.close();
  } //end of play
  
}