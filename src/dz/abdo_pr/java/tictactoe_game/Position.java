package dz.abdo_pr.java.tictactoe_game;

import java.util.Scanner;

public class Position {

  // the position in x axis
  private int x;
  // the position in y axis
  private int y;

  /**
   * create the position object
   * 
   * @param x: the position in x axis
   * @param y: the position in y axis
   */
  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /***
   * enterPosition - enter the position from scanner
   * 
   * @param scanner: the console scanner
   * @return: the new position object
   */
  public static Position enterPosition(Scanner scanner) {
    // position values
    int x = 0, y = 0;
    // to lopping the loop
    boolean validPosition = false;

    // keep lopping while validPosition is false
    while (!validPosition) {
      System.out.print("Enter position x (1, 2, 3): "); // display the message to user to enter position x
      x = scanner.nextInt();// read the x int
      System.out.print("Enter position y (1, 2, 3): "); // display the message to user to enter position y
      y = scanner.nextInt(); // read the y int

      // check for x and y values
      if (x < 1 || x > 3 || y < 1 || y > 3)
        System.err.println("Please enter valid position"); // display error message
      else
        validPosition = true; // set it valid
    }

    // create the position object and return it
    return new Position(x, y);
  }

  /**
   * getPosX - get the position in x axis
   * 
   * @return: the position in x axis
   */
  public int getPosX() {
    return x;
  }

  /**
   * getPosY - get the position in y axis
   * 
   * @return: the position in y axis
   */
  public int getPosY() {
    return y;
  }

}
