package com.example.nathanpelletier.hangman;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
  @Test
  public void addition_isCorrect() throws Exception {
    GetWord getWord = new GetWord();
    Game game = new Game();
    Keyboard keyboard = new Keyboard();
    Menu menu = new Menu();
    assertEquals(4, 2 + 2);

    //assertSame( getWord.MEDIUM, getWord.changeDifficultyToStringList("medium"));

   // assertSame( getWord.HARD, getWord.changeDifficultyToStringList("hard"));

  }
}