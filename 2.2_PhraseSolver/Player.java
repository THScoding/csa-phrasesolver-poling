/*
 * Activity 2.2.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  private String name;
  private int points;
  
  public Player()
  {
    points = 0;

    System.out.println("Enter Player Name:");
    Scanner sc = new Scanner(System.in);
    name = sc.nextLine(); //skipping error handling for user input
    sc.close();

    System.out.println("Hello and welcome to the game, " + name);
  }

  public Player(String inputName)
  {
    points = 0;
    name = inputName;
    System.out.println("Hello and welcome to the game, " + name);
  }

  /* your code here - accessor(s) */ 

  /* your code here - mutator(s) */ 
}