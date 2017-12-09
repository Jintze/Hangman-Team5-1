package com.example.nathanpelletier.hangman;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
  private String[] TEST_WORDS = {"easy", "medium", "harrrdq"};

  /**
   * Displays result of each character guess (in game screen)
   */
  private LinearLayout LINEARLAYOUT_GUESS_RESULTS;

  /**
   * onCreate is used to initialize all and set view attributes
   * @param savedInstanceState
   */



  public char key;

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

    inGameMenu();






    /*//check player progress
    if (CORRECT_GUESSES<=CHOSEN_WORD.length()) {
      if (WRONG_GUESSES <= 3) {
        charCompare('r');
      } else {
        //end game
      }//else
    }else{
        //end game
    }//else*/

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
    for(int i = 0; i < CHOSEN_WORD.length(); i++){
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
        displayCorrectGuesses(i,inputLetter); // peter I just added this
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

  /**
   * onClick listener for corner menu button with fade in animation
   */
  public void inGameMenu(){
    ImageButton IN_GAME_MENU_BUTTON = findViewById(R.id.backToeMenuButton);
    final LayoutInflater LAYOUT_INFLATER = this.getLayoutInflater();

    final RelativeLayout GAMESCREEN = findViewById(R.id.inGameMainParent);

    IN_GAME_MENU_BUTTON.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
       view = LAYOUT_INFLATER.inflate(R.layout.popwindow,null);

       view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in));

       GAMESCREEN.addView(view);
      }
    });

  }//inGameMenu



































//------------------------------------------------------------------------------------------

    /**
     * onClick for every key in the keyboard
     */
  /*public void keyboard1(){

    final Button Guess_Key = findViewById(R.id.LetterQ);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress(Guess_Key.getTag().toString().charAt(0));


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard*/

  /**
   *
   * @param KEY_LETTER
   */
  public void keyPress(char KEY_LETTER){
    charCompare(KEY_LETTER);
  }


  /*public void onClick(View v) {
    switch (v.getId()) {

      case R.id.LetterA: {
        keyPress('a');

      }//A

      case R.id.LetterB: {
        keyPress('b');
      }//B

      case R.id.LetterC: {
        keyPress('c');
      }//C

      case R.id.LetterD: {
        keyPress('d');
      }//D

      case R.id.LetterE: {
        keyPress('e');
      }//E

      case R.id.LetterF: {
        keyPress('f');
      }//F

      case R.id.LetterG: {
        keyPress('g');
      }//G

      case R.id.LetterH: {
        keyPress('h');
      }//H

      case R.id.LetterI: {
        keyPress('i');
      }//I

      case R.id.LetterJ: {
        keyPress('j');
      }//J

      case R.id.LetterK: {
        keyPress('k');
      }//K

      case R.id.LetterL: {
        keyPress('l');
      }//L

      case R.id.LetterM: {
        keyPress('m');
      }//M

      case R.id.LetterN: {
        keyPress('n');
      }//N

      case R.id.LetterO: {
        keyPress('o');
      }//O

      case R.id.LetterP: {
        keyPress('p');
      }//P

      case R.id.LetterQ: {
        keyPress('q');
      }//Q

      case R.id.LetterR: {
        keyPress('r');
      }//R

      case R.id.LetterS: {
        keyPress('s');
      }//S

      case R.id.LetterT: {
        keyPress('t');
      }//T

      case R.id.LetterU: {
        keyPress('u');
      }//U

      case R.id.LetterV: {
        keyPress('v');
      }//V

      case R.id.LetterW: {
        keyPress('w');
      }//W

      case R.id.LetterX: {
        keyPress('x');
      }//X

      case R.id.LetterY: {
        keyPress('y');
      }//Y


      case R.id.LetterZ: {
        keyPress('z');
      }//Z

    }//Switch*/

  //onClick
} // Game
