package com.example.nathanpelletier.hangman;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Game extends AppCompatActivity {

  /**
   * Maximum amount of errors before the game ends.
   */
  private final int STRIKES = 6;

  /**
   * keeps track of every time the user makes a wrong guess
   */
  private int WRONG_GUESSES = 0;

  /**
   * keeps track of every time the user makes a right guess
   */
  private  int CORRECT_GUESSES = 0;

  /**
   * the random word selected by computer based off of difficulty selected
   */
  private String CHOSEN_WORD;

  /**
   * Character array to store output. Might need to add final so only this class can modify the
   * variable.
   */
  public char[] REVEALED_LETTERS;

  /**
   * Test array to test out word selection
   *
   * DELETE THIS
   */
  private String[] TEST_WORDS = {"easy", "medium", "harrrd"};

  /**
   * Displays result of each character guess (in game screen)
   */
  private LinearLayout LINEARLAYOUT_GUESS_RESULTS;

  /**
   * onCreate is used to initialize all and set view attributes
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ingame);

    LINEARLAYOUT_GUESS_RESULTS = findViewById(R.id.guess__result); // match or nahh

  } // onCreate(Bundle)

  /**
   * Runs all methods in game class.
   *
   * also checks player progress (win/loss)
   */
  public void onStart() {
    super.onStart();

    wordPicker(getIntentData());

    printDashes();

    //check player progress
    if (CORRECT_GUESSES<=CHOSEN_WORD.length()) {
      if (WRONG_GUESSES <= 3) {
        charCompare('e');
      } else {
        //end game
      }//else
    }else{
        //end game
    }//else

  } // onStart()

    /**
     * displays the correctly guessed letter in the proper TextView for the user
     * @param LETTER_LOCATION
     * @param GUESSED_LETTER
     */
    public void displayCorrectGuesses(int LETTER_LOCATION,char GUESSED_LETTER){
      TextView view = findViewById(LETTER_LOCATION);
      view.setText(String.valueOf(GUESSED_LETTER));
    }//displayCorrectGuesses

  /**
   * Creates as many textviews as the CHOSEN_WORD has letters and placing them in LINEARLAYOUT_GUESS_RESULTS
   * chronologically id from 1 - n; n = CHOSEN_WORD length
   */
  public void printDashes (){
    for(int i = 1; i < CHOSEN_WORD.length()+1; i++){
      TextView CORRECT_GUESS = new TextView(this);
      CORRECT_GUESS.setText(" ___ ");
      CORRECT_GUESS.setId(i);

      LINEARLAYOUT_GUESS_RESULTS.addView(CORRECT_GUESS);
    }//for
  }//printDashes


  /**
   * Takes in user selected difficulty(Easy, Medium, Hard) from main menu and transfers it to Game class
   * @return String SELECTED_DIFFICULTY
   */
  public String getIntentData() {

    Intent intent = getIntent();

    String SELECTED_DIFFICULTY = intent.getStringExtra("Difficulty");

    Log.d("lets see 0;", ";the final array yay" + SELECTED_DIFFICULTY);

    return SELECTED_DIFFICULTY;

  } // getIntentData()

  /**
   * compares inputLetter to CHOSEN_WORD
   * ToDo: return correct char and location
   * Train of thought: use a global variable to represent letters that are uncovered by the user;
   * go through chosen word with selected letter; if selected character match at location of chosen
   * word, add that character to the ith position in the global variable. The other method can just
   * access this file's global variable.
   * @param inputLetter: users input char
   */
  public void charCompare(char inputLetter) {
    boolean alreadyGuessed = false;
    for (int i = 0; i < CHOSEN_WORD.length(); i++) {
      if (inputLetter == CHOSEN_WORD.charAt(i)) {
        //displayCorrectGuesses(i,inputLetter); // peter I just added this
        REVEALED_LETTERS[i] = CHOSEN_WORD.charAt(i);
        // displayCorrectGuesses();


        for(int j = 0; j < REVEALED_LETTERS.length; j++){
          if(REVEALED_LETTERS[i] == CHOSEN_WORD.charAt(j)){
            alreadyGuessed = true;
          } // if
        } // for

        if(alreadyGuessed == false){
          CORRECT_GUESSES = CORRECT_GUESSES + 1;
        }//
      } // if
      else {
        WRONG_GUESSES++;
      } // else
    } // for
    if(CORRECT_GUESSES == CHOSEN_WORD.length()){
      //endGameWin();
    } // if
    if(WRONG_GUESSES == STRIKES){
      //endGameLose();
    } // if
  } // charCompare

  /**
   * For Testing: takes selectedDifficulty and selects a word from TEST_WORD String array
   * This then manipulates global variable CHOSEN_WORD
   * Initialize REVEALED_LETTERS to spaces.
   * @param selectedDifficulty
   */
  public void wordPicker(String selectedDifficulty) {
    switch(selectedDifficulty){
      case "easy":
        CHOSEN_WORD = TEST_WORDS[0];
        break;
      case "medium":
        CHOSEN_WORD = TEST_WORDS[1];
        break;
      case "hard":
        CHOSEN_WORD = TEST_WORDS[2];
        break;
    } // switch
    REVEALED_LETTERS = new char[CHOSEN_WORD.length()];
    for(int i = 0; i < REVEALED_LETTERS.length; i++){
      REVEALED_LETTERS[i] = ' ';
    } // for
  } // wordPicker(String)


} // Game
