package dz.abdo_pr.java.tictactoe_game;

public class Letter extends Position {

  // the letter char
  private char letterChar;

  /**
   * create the letter object
   * 
   * @param x:          the letter position in x axis
   * @param y:          the letter position in y axis
   * @param letterChar: the letter char
   */
  public Letter(int x, int y, char letterChar) {
    super(x, y);
    this.letterChar = letterChar;
  }

  /**
   * create the letter object using position object
   * 
   * @param position:   the position object
   * @param letterChar: the letter char
   */
  public Letter(Position position, char letterChar) {
    super(position.getPosX(), position.getPosY());
    this.letterChar = letterChar;
  }

  /**
   * getLetterChar - get the letter char
   * 
   * @return: the letter char
   */
  public char getLetterChar() {
    return letterChar;
  }

}
