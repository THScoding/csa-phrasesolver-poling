import java.util.Scanner;
  
public class  PhraseSolver
{
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;
  private final int solveBonus = 1000;

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
    Player currentPlayer = player1;
    Scanner sc = new Scanner(System.in);
    String boardStatus = game.getSolvedPhrase();

    while (!solved) 
    { 
      guesses++; //

      // Show current game board status, and player points
      System.out.println(boardStatus);
      System.out.println("Scores: \n" + player1.getName() + " : " + player1.getPoints());
      System.out.println(player2.getName() + " : " + player2.getPoints());
      
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
      
      System.out.println(currentPlayer.getName() + " guess a letter: ");
      String guess = sc.nextLine();

      if (guess.length() == 1) //Is player guessing a letter, or the whole phrase?
      {
        //Add points per occurence of letter in phrase; My guessLetter returns count of letter guessed
        currentPlayer.addPoints(letterVal * game.guessLetter(guess));
        solved = game.isSolved(game.getSolvedPhrase()); //check if puzzle is complete
      } else { //assume player is guessing the whole phrase
        solved = game.isSolved(guess);
        currentPlayer.addPoints(solveBonus);
      }
      boardStatus = game.getSolvedPhrase();

    } //end of while (!solved) loop
    sc.close();

    //Print final game result, scores
    System.out.println("\nNice job, " + currentPlayer.getName() + "!  You solved the puzzzle. That's earns you a points bonus of " + solveBonus);
    String winnerName = player1.getPoints() > player2.getPoints() ? player1.getName() : player2.getName();
    System.out.println("\nCongratulations, " + winnerName +"!  You won, with the most points.\n");
  } //end of play
  
}