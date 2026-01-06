import java.util.Scanner;

/*
 * Activity 2.2.2
 * The runner for the PhraseSolverGame
 */
public class Runner
{
  public static void main(String[] args)
  {
    System.out.println("\n========================\n");
    System.out.println("Welcome to the phrase solver game, find a friend and compete to find the phrase!");

    Scanner sc = new Scanner(System.in);
    boolean quit = false;
    boolean useDefaultFile = true;

    while (!quit)
    {
      PhraseSolver game;

      // Switch between phrase files each round
      if (useDefaultFile)
        game = new PhraseSolver("phrases.txt");
      else
        game = new PhraseSolver("phrases_OG.txt");

      useDefaultFile = !useDefaultFile;
      game.play();

      System.out.print("Do you want to quit? (y/n): ");
      String response = sc.nextLine().trim().toLowerCase();

      if (response.equals("y"))
        quit = true;
    }

    sc.close();
    System.out.println("\nThanks for playing!");
  }
}