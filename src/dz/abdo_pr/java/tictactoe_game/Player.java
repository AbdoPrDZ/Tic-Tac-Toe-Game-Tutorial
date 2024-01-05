package dz.abdo_pr.java.tictactoe_game;

import java.util.Scanner;

public class Player {

  // the player name
  private String name;
  // the player letter
  private char letter;

  /**
   * create the player object
   * 
   * @param name:   the player name
   * @param letter: the player letter char
   */
  public Player(String name, char letter) {
    this.name = name;
    this.letter = letter;
  }

  /**
   * enterPlayer - enter the player details from scanner without first player
   * 
   * @param scanner: the console scanner object
   * @return: the new player that we create
   */
  public static Player enterPlayer(Scanner scanner) {
    return enterPlayer(scanner, null);
  }

  /**
   * enterPlayer - enter the player details from scanner with first player
   * 
   * @param scanner:     the console scanner object
   * @param firstPlayer: the first player if exists
   * @return: the new player that we create
   */
  public static Player enterPlayer(Scanner scanner, Player firstPlayer) {
    // the player name
    String playerName;
    // the player letter
    char playerLetter;

    // enter the player name
    System.out.print("Enter your name: "); // display the message to user in console
    playerName = scanner.nextLine();

    // check if there is no first player
    if (firstPlayer == null) {
      String input = "";// the scanner input
      boolean validLetter = false;// we use it to looping

      // keep looping while validLetter is false
      while (!validLetter) {
        // display the message to user in console to enter the letter
        System.out.print("Enter your letter (X, x, O, o): ");
        input = scanner.nextLine();

        // convert the input text to upper case
        input = input.toUpperCase();

        // verify the input text
        if (input.length() != 1 ||
            (input.charAt(0) != 'X' && input.charAt(0) != 'O')) {
          System.err.println("Please enter valid letter");// show error message
        } else
          validLetter = true; // set validLetter if is valid
      }

      playerLetter = input.charAt(0);
    } else // otherwise set the next letter
      // if first player has x the next will 'O' else 'X'
      playerLetter = firstPlayer.getLetter() == 'X' ? 'O' : 'X';

    return new Player(playerName, playerLetter);
  }

  /**
   * getName - get the player name
   * 
   * @return: the player name
   */
  public String getName() {
    return name;
  }

  /**
   * getLetter - get the player letter
   * 
   * @return: the player letter
   */
  public char getLetter() {
    return letter;
  }

  @Override
  public String toString() {
    return "Player: (name: " + name + ", letter: " + letter + ")";
  }

}
