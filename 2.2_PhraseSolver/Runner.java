/*
 * Activity 2.2.2
 *
 * The runner for the PhraseSolverGame
 */
public class Runner
{
  public static void main(String[] args) 
  {
    System.out.println("\n========================\n");
    //Nicholas T: Printing a welcome message to the game
    System.out.println("Welcome to the phrase solver game, find a friend and compete to find the phrase!");


    //TODO: Add a game loop: Keep looping, querying user if they want to quit; end loop if so
    //TODO: Switch between phrases.txt and phrases_OG.txt on each iteration of the loop.
    PhraseSolver p = new PhraseSolver(); 
    p.play();
  }

} 
