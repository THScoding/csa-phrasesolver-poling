/*
 * Activity 2.2.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  private Player player1;
  private Player player2;
  private Board board;
  private boolean solved;

  public PhraseSolver()
  {
    player1 = new Player();
    player2 = new Player();
    board = new Board();
    solved = false;
  }

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      
      /* your code here - game logic */
      
      
      /* your code here - determine how game ends */
      solved = true; 
    } 
   
  }
  
}