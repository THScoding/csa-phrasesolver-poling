import java.util.Scanner;

public class Player
{
  private String name;
  private int points;

  public Player()
  {
    System.out.println("Enter Player Name:");
    Scanner sc = new Scanner(System.in);
    String newName = sc.nextLine();
   
    name = newName;
    System.out.println("Hello and welcome to the game, " + name);
    points = 0;
  }

  public Player(String inputName)
  {
    name = inputName;
    System.out.println("Hello and welcome to the game, " + name);
    points = 0;
  }

  public String getName()
  {
    return name;
  }
  // Comment
  public int getPoints()
  {
    return points;
  }

  public void addPoints(int pointsToAdd)
  {
    points += pointsToAdd;
  }
}

