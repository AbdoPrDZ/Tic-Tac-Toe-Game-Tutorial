package dz.abdo_pr.java.tictactoe_game;

public class Utils {

  /**
   * clearConsole - clear the console output text
   */
  public static void clearConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * insertLetter - insert the letter into the letters table
   * 
   * @param letters: the letters table
   * @param letter:  the letter we will insert
   * @return: the new letters table
   */
  public static Letter[] insertLetter(Letter[] letters, Letter letter) {
    // get the current letters table length
    int len = letters.length;

    // create a new letters table with length (len + 1)
    // to add the new letter at new position
    Letter[] newLetters = new Letter[len + 1];

    // fill the new letters table with the current letters table items
    for (int i = 0; i < letters.length; i++)
      newLetters[i] = letters[i];

    // add the new letter
    newLetters[len] = letter;

    // return the new letters table
    return newLetters;
  }

}
