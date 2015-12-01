package Othello;

import java.io.PrintStream;
import java.util.Scanner;

public class Othello
{
  public static void main(String[] args)
  {
    Scanner console = new Scanner(System.in);
    System.out.println("Enter the name of Player 1:");
    String player1 = console.next();
    System.out.println("Enter the name of Player 2:");
    String player2 = console.next();
    boolean turn = false;
    Player.values player = Player.values.PLAYER1;
    OthelloBoard board = new OthelloBoard();
    while (!turn)
    {
      System.out.println(player + ": Your Turn.");
      int row = console.nextInt();
      int col = console.nextInt();
      if (player == Player.values.PLAYER1) {
        try
        {
          board.makeChanges(1, row, col);
        }
        catch (InvalidOthelloMoveException e)
        {
          System.out.println("Invalid Input.Try Again");
        }
      } else {
        try
        {
          board.makeChanges(2, row, col);
        }
        catch (InvalidOthelloMoveException e)
        {
          e.printStackTrace();
        }
      }
      player = player == Player.values.PLAYER1 ? Player.values.PLAYER2 : Player.values.PLAYER1;
    }
  }
}
