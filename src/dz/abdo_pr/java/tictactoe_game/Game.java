package dz.abdo_pr.java.tictactoe_game;

import java.util.Scanner;

public class Game {

  // the game board
  private Board board;
  // the game first player
  private Player playerA;
  // the game second player
  private Player playerB;
  // the game winner player
  private Player winnerPlayer;
  // the game turn player
  private Player turnPlayer;

  /**
   * create the game object
   * 
   * @param playerA: the first player
   * @param playerB: the second player
   */
  public Game(Player playerA, Player playerB) {
    this.board = new Board(); // create the board object of this game
    this.playerA = playerA;
    this.playerB = playerB;
    this.winnerPlayer = null; // set it null because there is no winner yet
    this.turnPlayer = playerA; // set it playerA by default
  }

  /**
   * play - starting play the game
   * 
   * @param scanner: the console scanner to enter letters positions
   * @return: the winner player if exists
   * @throws InterruptedException // don't worry don't see it, you don't have to
   *                              understand it
   */
  public Player play(Scanner scanner) throws InterruptedException {
    System.out.println("Starting the game");

    // keep lopping while no winner and letters length less then 9
    while (winnerPlayer == null && board.getLetters().length < 9) {
      Utils.clearConsole(); // clear the console output
      board.drawIt();
      System.out.println("Turn: " + turnPlayer.getName() + ", '" + turnPlayer.getLetter() + "' ");

      // enter the new letter position
      Position letterPosition = Position.enterPosition(scanner);
      // create the next letter based with position
      // that entered and turn player letter
      Letter letter = new Letter(letterPosition, turnPlayer.getLetter());

      // try to insert the new letter to the board
      boolean insertSuccess = board.insertLetter(letter);

      // check if inserting is success
      if (insertSuccess) {
        // set the turn player if is a set it b, else b
        turnPlayer = turnPlayer == playerA ? playerB : playerA;
      } else {
        Thread.sleep(2000); // we use it to let user see the error in 2 seconds
      }

      // check for the winner
      checkWinner();
    }

    // clear the console output
    Utils.clearConsole();
    // draw the last insert
    board.drawIt();

    // return the winner player if exists
    return winnerPlayer;
  }

  /**
   * checkCase - check for 3 letters case if are the same
   * 
   * @param letters: the 3 letters table
   * @return: true if is same, false if not or there is one not exists
   */
  public boolean checkCase(Letter[] letters) {
    // check if there 3 letters exists
    for (Letter letter : letters)
      if (letter == null) // if one is not exists
        return false;

    // get case chars
    char char1 = letters[0].getLetterChar();
    char char2 = letters[1].getLetterChar();
    char char3 = letters[2].getLetterChar();

    // check if all is the same and return the result
    return char1 == char2 && char1 == char3;
  }

  /**
   * checkWinner - check if there is winner in all cases
   */
  public void checkWinner() {
    // create the table of table of letters
    Letter[][] cases = {
        // first row case
        {
            board.getLetterAt(1, 1),
            board.getLetterAt(2, 1),
            board.getLetterAt(3, 1),
        },
        // second row case
        {
            board.getLetterAt(1, 2),
            board.getLetterAt(2, 2),
            board.getLetterAt(3, 2),
        },
        // third row case
        {
            board.getLetterAt(1, 3),
            board.getLetterAt(2, 3),
            board.getLetterAt(3, 3),
        },
        // first col case
        {
            board.getLetterAt(1, 1),
            board.getLetterAt(1, 2),
            board.getLetterAt(1, 3),
        },
        // second col case
        {
            board.getLetterAt(2, 1),
            board.getLetterAt(2, 2),
            board.getLetterAt(2, 3),
        },
        // third col case
        {
            board.getLetterAt(3, 1),
            board.getLetterAt(3, 2),
            board.getLetterAt(3, 3),
        },
        // first corn case
        {
            board.getLetterAt(1, 1),
            board.getLetterAt(2, 2),
            board.getLetterAt(3, 3),
        },
        // second corn case
        {
            board.getLetterAt(3, 1),
            board.getLetterAt(2, 2),
            board.getLetterAt(1, 3),
        },
    };

    // lopping into the cases
    for (Letter[] _case : cases)
      if (checkCase(_case)) { // check for the case
        // get the first letter of case
        Letter firstLetterOfCase = _case[0];
        winnerPlayer = playerA.getLetter() == firstLetterOfCase.getLetterChar() ? // check if first char letter case
                                                                                  // letter of
        // player a
            playerA : // so the player a is the winner
            playerB; // ok the player b is the winner
      }

  }

  /**
   * getBoard - get the game board
   * 
   * @return: the game board
   */
  public Board getBoard() {
    return board;
  }

  /**
   * getPlayerA - get the game first player
   * 
   * @return: the game first player
   */
  public Player getPlayerA() {
    return playerA;
  }

  /**
   * getPlayerB - get the game second player
   * 
   * @return: the game second player
   */
  public Player getPlayerB() {
    return playerB;
  }

  /**
   * getPlayerA - get the game winner player
   * 
   * @return: the game winner player
   */
  public Player getWinnerPlayer() {
    return winnerPlayer;
  }

  /**
   * getPlayerA - get the game turn player
   * 
   * @return: the game turn player
   */
  public Player getTurnPlayer() {
    return turnPlayer;
  }

}
