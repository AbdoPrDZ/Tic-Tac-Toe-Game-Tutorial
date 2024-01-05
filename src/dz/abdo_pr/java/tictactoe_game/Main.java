package dz.abdo_pr.java.tictactoe_game;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    // create the scanner object
    Scanner scanner = new Scanner(System.in);

    // enter the first player derails
    System.out.println("Enter First Player details:");
    Player playerA = Player.enterPlayer(scanner);

    // enter the second player derails
    System.out.println("Enter Second Player details:");
    Player playerB = Player.enterPlayer(scanner, playerA);

    // create a game object
    Game game = new Game(playerA, playerB);
    // start playing the game and get the winner if exists
    Player winner = game.play(scanner);

    // check if there is winner on this game
    if (winner != null)
      // print the winning message and winner details
      System.out.println("Grate The winner player is " + winner);
    else
      // print no winning message
      System.out.println("There is no winner in this game, try again");

    // close the scanner
    scanner.close();
  }

}
