import java.util.Scanner;
import java.io.File;

public class  Board
{ 
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  public Board ()
  {
    solvedPhrase = "";
    phrase = loadPhrase();
    setLetterValue();
  }

  /* students create new accessor methods */
  public String getPhrase()
  {
    return phrase;
  }

  public String getSolvedPhrase()
  {
    return solvedPhrase;
  }

  public int getLetterValue()
  {
    return currentLetterValue;
  }

 /* ---------- provided code, do not modify ---------- */
   public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }
  
  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";

    int numOfLines = 0;
    // a try is like an if statement, "throwing" an error if the body of the try fails
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
	  int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count=0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        // String method trim remove whitespace from beginning and end of string
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else //return an underscore
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  } 

  /**
   *  return count of letter in phrase; so 0 means guess failed
   */ 
  public int guessLetter(String guess)
  {
    //Skip processing if letter was already guessed
    if (solvedPhrase.indexOf(guess) >= 0)  
    {
      return 0;
    }
    int foundLetterCount = 0;
    String newSolvedPhrase = "";
    for (int i = 0; i < phrase.length(); i++)
    {
      if (phrase.substring(i, i + 1).equals(guess))
      {
        newSolvedPhrase += guess + " ";
        foundLetterCount++;
      }
      else
      {
        if (phrase.substring(i, i + 1).equals(" "))
        {
          newSolvedPhrase += "  ";
        }  
        else
        {
          //return an underscore
          if (phrase.substring(i, i + 1).equals("_"))
          {
            newSolvedPhrase += "_ ";
          }  
          else
          {  
           newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
          }  
        }
      }
    }
    solvedPhrase = newSolvedPhrase;
    return foundLetterCount;
  }

} 
