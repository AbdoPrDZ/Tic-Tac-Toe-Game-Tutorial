package dz.abdo_pr.java.tictactoe_game;

public class Board {

  // the board letters
  private Letter[] letters;

  /**
   * create the board object
   * 
   * @param letters: the board letters
   */
  public Board() {
    this.letters = new Letter[0]; // create an empty table of letters
    // the letters we will insert it later when the game is running
  }

  /**
   * getLetterAt - get the letter at position x, y if exists
   * 
   * @param x: the position in x axis
   * @param y: the position in y axis
   * @return: the letter if exists, null if not exists
   */
  public Letter getLetterAt(int x, int y) {
    for (Letter letter : letters) // looping into letters table
      // check if letter x, y is equals to x, y parameters
      if (letter.getPosX() == x && letter.getPosY() == y)
        return letter; // return the letter we find

    return null; // return null if not exists
  }

  /**
   * drawIt - draw the game board and place the letters exists
   */
  public void drawIt() {
    // first row letters
    Letter letter11 = getLetterAt(1, 1); // col 1 row 1
    Letter letter21 = getLetterAt(2, 1); // col 2 row 1
    Letter letter31 = getLetterAt(3, 1); // col 3 row 1
    // second row letters
    Letter letter12 = getLetterAt(1, 2); // col 1 row 2
    Letter letter22 = getLetterAt(2, 2); // col 2 row 2
    Letter letter32 = getLetterAt(3, 2); // col 3 row 2
    // third row letters
    Letter letter13 = getLetterAt(1, 3); // col 1 row 3
    Letter letter23 = getLetterAt(2, 3); // col 2 row 3
    Letter letter33 = getLetterAt(3, 3); // col 3 row 3

    // the draw string
    String draw = "";

    draw += "X----1-----2-----3---\n"; // draw x axis

    /// first row
    draw += "|  _____ _____ _____\n"; // draw the first row blank line
    draw += "| :     :     :     :\n"; // draw the blank line of first row
    // draw the letter (1, 1) if exists, else draw space
    draw += "1 :  " + (letter11 != null ? letter11.getLetterChar() : " ");
    // draw the letter (2, 1) if exists, else draw space
    draw += "  :  " + (letter21 != null ? letter21.getLetterChar() : " ");
    // draw the letter (3, 1) if exists, else draw space
    // with right border and end line
    draw += "  :  " + (letter31 != null ? letter31.getLetterChar() : " ") + "  :\n";

    /// second row
    draw += "| :_____:_____:_____:\n"; // draw the second row blank line
    draw += "| :     :     :     :\n"; // draw the blank line of second row
    // draw the letter (1, 2) if exists, else draw space
    draw += "2 :  " + (letter12 != null ? letter12.getLetterChar() : " ");
    // draw the letter (2, 2) if exists, else draw space
    draw += "  :  " + (letter22 != null ? letter22.getLetterChar() : " ");
    // draw the letter (3, 2) if exists, else draw space
    // with right border and end line
    draw += "  :  " + (letter32 != null ? letter32.getLetterChar() : " ") + "  :\n";

    /// third row
    draw += "| :_____:_____:_____:\n"; // draw the third row blank line
    draw += "| :     :     :     :\n"; // draw the blank line of third row
    // draw the letter (1, 3) if exists, else draw space
    draw += "3 :  " + (letter13 != null ? letter13.getLetterChar() : " ");
    // draw the letter (2, 3) if exists, else draw space
    draw += "  :  " + (letter23 != null ? letter23.getLetterChar() : " ");
    // draw the letter (3, 3) if exists, else draw space
    // with right border and end line
    draw += "  :  " + (letter33 != null ? letter33.getLetterChar() : " ") + "  :\n";
    draw += "| :_____:_____:_____:\n"; // draw the bottom border of third row

    draw += "Y"; // draw the y axis letter

    System.out.println(draw);// print the board draw
  }

  /**
   * insertLetter - insert the new letter to the board
   * 
   * @param letter: the new letter
   * @return: true if success, false if fail
   */
  public boolean insertLetter(Letter letter) {
    // get if there is letter on this position
    Letter oldLetter = getLetterAt(letter.getPosX(), letter.getPosY());

    // check if is not null
    if (oldLetter != null) {
      System.err.println("This position is used before, please chose other position");
      return false; // return false for inserting fail
    } else {
      // insert the new letter to board letters table
      letters = Utils.insertLetter(letters, letter);
      return true; // return false for inserting success
    }
  }

  /**
   * getLetters - get the board letters
   * 
   * @return: the board letters
   */
  public Letter[] getLetters() {
    return letters;
  }

}
